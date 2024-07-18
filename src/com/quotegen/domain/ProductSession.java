package com.quotegen.domain;

public class ProductSession {
     private static ProductSession instance;
    private Producto producto;

    private ProductSession() {} // Singleton: Constructor privado

    public static ProductSession getInstance() {
        if (instance == null) {
            instance = new ProductSession();
        }
        return instance;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
