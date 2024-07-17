
package com.quotegen.domain;


public class Producto {
    private String description; 
    private int unit ; 
    private double price;
    private double total;

    public Producto() {
    }
    
    // Volatile instance to ensure thread safety
    
    public Producto(String descrition, int unit, double price) {
        this.description = descrition;
        this.unit = unit;
        this.price = price;
    }

    public Producto(String description, int unit, double price, double total) {
        this.description = description;
        this.unit = unit;
        this.price = price;
        this.total = total;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("description=").append(description);
        sb.append(", unit=").append(unit);
        sb.append(", price=").append(price);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
