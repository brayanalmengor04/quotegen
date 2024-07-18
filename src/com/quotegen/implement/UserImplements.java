
package com.quotegen.implement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.quotegen.domain.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;


// Para aplicar el metodo solo intancias esta clase  
                            // Implementar Metodo de IUser
public class UserImplements implements IUser{  
     private static final String JSON_FILE_PATH = "/com/quotegen/assets/userSession.json";

    
     ArrayList<Usuario> usuarioValidate = new ArrayList<>(); 
     
    @Override
    public Usuario logIn(Usuario usuario) {  
       usuarioValidate =  readUser("/com/quotegen/assets/userSession.json");  
       
       Usuario  usuarioIn =null;
       
        for (int i = 0; i < usuarioValidate.size(); i++) {
            Usuario usuariovalidate = usuarioValidate.get(i);
            if (usuariovalidate.getUsername().equals(usuario.getUsername())
                    && usuariovalidate.getEmail().equals(usuario.getEmail())
                    && usuariovalidate.getPassword().equals(usuario.getPassword())) {

                usuarioIn = new Usuario(
                        usuariovalidate.getUsername(),
                        usuariovalidate.getEmail(),
                        usuariovalidate.getPassword(),
                        usuariovalidate.getNameRol(),
                        usuariovalidate.getPermission()
                );

                return usuarioIn; // Retorna el usuario encontrado
            }
        }
        return null;
    }

    @Override
    public ArrayList<Usuario> readUser(String urlJson) {  
          List<Usuario> usuarios = new ArrayList<>();
          InputStream inputStream = getClass().getResourceAsStream(urlJson);

        if (inputStream != null) {
            try {
                String jsonText = readFromInputStream(inputStream);
                JSONArray jsonArray = new JSONArray(jsonText);
              
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Usuario usuario = new Usuario(
                            jsonObject.getString("nombre"),
                            jsonObject.getString("email"),
                            jsonObject.getString("password"),
                            jsonObject.getString("nombrerol"),
                            jsonObject.getBoolean("permision")
                    );
                    usuarios.add(usuario);
                } 
                return (ArrayList<Usuario>) usuarios;

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Archivo JSON no encontrado");
        }
        return null;
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
     // URLJSON /com/quotegen/assetss/userSession.json 
    @Override
    public void insertUser(Usuario usuario) {  
         String filePath = "src/com/quotegen/assets/userSession.json";

        try {
            // Crear ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Leer el archivo JSON existente
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Verificar si es un array JSON
            if (rootNode.isArray()) {
                // Convertir el nodo raíz a un ArrayNode
                ArrayNode usuarios = (ArrayNode) rootNode;

                // Crear un nuevo objeto para la persona a agregar
                ObjectNode nuevaPersona = objectMapper.createObjectNode(); 
                
                nuevaPersona.put("nombre", usuario.getUsername());
                nuevaPersona.put("email", usuario.getEmail());
                nuevaPersona.put("password",usuario.getPassword());
                nuevaPersona.put("nombrerol",usuario.getNameRol());
                nuevaPersona.put("permision",usuario.getPermission()); 

                // Agregar la nueva persona al array de usuarios
                usuarios.add(nuevaPersona);
                // Escribir el JSON actualizado de vuelta al archivo
                objectMapper.writeValue(new File(filePath), rootNode);

                
                JOptionPane.showMessageDialog(null, "Se ha agregado correctamente!");
            } else {
                System.out.println("El archivo JSON no contiene un array válido.");
            }

        } catch (IOException e) {
            System.err.println("Error al procesar el archivo JSON: " + e.getMessage());
        }
        
    }
        
       
    

   
    
   
}
