package com.quotegen.domain;

import java.util.ArrayList;


public class ProductData { 
    
private static ProductData instance;
private ArrayList<Producto> dataProductos;

// Constructor privado para evitar instanciación externa
private ProductData() {
    dataProductos = new ArrayList<>();
}

// Método estático para obtener la instancia única
public static ProductData getInstance() {
    if (instance == null) {
        instance = new ProductData();
    }
    return instance;
}

public ArrayList<Producto> getDataProductos() {
    return dataProductos;
}

public void setDataProductos(ArrayList<Producto> dataProductos) {
    this.dataProductos = dataProductos;
}
}
