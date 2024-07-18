
package com.quotegen.domain;


public class Producto {
    private String description; 
    private int unit ; 
    private double price;
   
    
    
    public Producto(String descrition, int unit, double price) {
        this.description = descrition;
        this.unit = unit;
        this.price = price;
    }

    public String getDescrition() {
        return description;
    }

    public void setDescrition(String descrition) {
        this.description = descrition;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    
}
