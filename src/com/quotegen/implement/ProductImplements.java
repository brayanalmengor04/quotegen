/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quotegen.implement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import static com.lowagie.text.pdf.BaseFont.RESOURCE_PATH;
import com.quotegen.domain.Producto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProductImplements implements IProduct{ 
     private static final String RESOURCE_PATH = "/com/quotegen/assets/productos.json";
   private static final String USER_HOME_DIR = System.getProperty("user.home");
    private static final String EXTERNAL_FILE_PATH = USER_HOME_DIR + File.separator + "productos.json";
    
@Override
public ArrayList<Producto> readProduct(String urlJson) { 
    
    List<Producto> productos = new ArrayList<>();
    InputStream inputStream = getClass().getResourceAsStream(urlJson);

    if (inputStream != null) {
        try {
            String jsonText = readFromInputStream(inputStream);
            JSONArray jsonArray = new JSONArray(jsonText);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Producto producto = new Producto(
                        jsonObject.getString("description"),
                        jsonObject.getInt("unit"),
                        jsonObject.getDouble("price"),
                        jsonObject.getDouble("total")
                );
                productos.add(producto);
            }
            return (ArrayList<Producto>) productos;

        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.err.println("Archivo JSON no encontrado");
    }
    return null;
}

@Override
public void insertProduct(Producto producto) { 
    String jsonFilePathInJar = "/productos.json";

try {
    // Crear un InputStream para leer el archivo desde el JAR
    InputStream inputStream = getClass().getResourceAsStream(jsonFilePathInJar);

    if (inputStream != null) {
        // Leer el contenido del archivo JSON
        String jsonString = new BufferedReader(new InputStreamReader(inputStream))
                                  .lines().collect(Collectors.joining("\n"));

        // Aquí puedes modificar jsonString según sea necesario

        // Ejemplo: Convertir jsonString a un objeto JSON usando Jackson ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);

        // Ejemplo: Modificar el JSON
        ((ObjectNode) rootNode).put("description", producto.getDescription());
        ((ObjectNode) rootNode).put("unit", producto.getUnit()); 
        ((ObjectNode) rootNode).put("price", producto.getPrice());
         ((ObjectNode) rootNode).put("total", producto.getTotal());
        
        // Guardar el JSON modificado en un archivo temporal
        File tempFile = File.createTempFile("tempfile", ".json");
        try (FileWriter fileWriter = new FileWriter(tempFile)) {
            objectMapper.writeValue(fileWriter, rootNode);
        }

        // Ahora puedes usar tempFile para leer el JSON modificado y realizar otras operaciones

    } else {
        System.out.println("No se pudo encontrar el archivo JSON dentro del JAR.");
    }
} catch (IOException e) {
    System.err.println("Error al procesar el archivo JSON desde el JAR: " + e.getMessage());
}
} 


 private static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line);
            }
        }
        return resultStringBuilder.toString();
    }

 // no se puede cargar los datos pero si se modifica en otro archivo externo.
 
    @Override
    public void updateProduct(Producto producto) { 
         try {
            // Check if the external file exists, if not copy it from the jar
            File externalFile = new File(EXTERNAL_FILE_PATH);
            if (!externalFile.exists()) {
                try (InputStream inputStream = getClass().getResourceAsStream(RESOURCE_PATH)) {
                    if (inputStream == null) {
                        throw new IOException("Resource not found: " + RESOURCE_PATH);
                    }
                    Files.copy(inputStream, externalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }

            // Now work with the external file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(externalFile);

            if (rootNode.isArray()) {
                ArrayNode productos = (ArrayNode) rootNode;
                boolean productFound = false;

                for (int i = 0; i < productos.size(); i++) {
                    JsonNode currentNode = productos.get(i);
                    if (currentNode.get("description").asText().equals(producto.getDescription())) {
                        ((ObjectNode) currentNode).put("description", producto.getDescription());
                        ((ObjectNode) currentNode).put("unit", producto.getUnit());
                        ((ObjectNode) currentNode).put("price", producto.getPrice());
                        ((ObjectNode) currentNode).put("total", producto.getTotal());
                        productFound = true;
                        break;
                    }
                }

                if (productFound) {
                    // Write the updated JSON back to the external file
                    objectMapper.writeValue(externalFile, rootNode);
                    JOptionPane.showMessageDialog(null, "Producto actualizado correctamente!");
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado!");
                }
            } else {
                System.out.println("El archivo JSON no contiene un array válido.");
            }
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo JSON: " + e.getMessage());
        }
    }
}
