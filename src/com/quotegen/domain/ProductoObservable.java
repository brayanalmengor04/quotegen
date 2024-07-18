/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quotegen.domain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductoObservable { 
    
    private static ProductoObservable instance;
    private ObservableList<Producto> productos;

    private ProductoObservable() {
        // Inicialización del ObservableList
        productos = FXCollections.observableArrayList();
    }

    // Método estático para obtener la instancia única
    public static synchronized ProductoObservable getInstance() {
        if (instance == null) {
            instance = new ProductoObservable();
        }
        return instance;
    }

    // Método para obtener el ObservableList de productos
    public ObservableList<Producto> getProductos() {
        return productos;
    }

    // Método para añadir un producto al ObservableList
    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    // Método para remover un producto del ObservableList
    public void removeProducto(Producto producto) {
        productos.remove(producto);
    }
}
