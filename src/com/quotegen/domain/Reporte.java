
package com.quotegen.domain;

public class Reporte {
    private byte [] logotipe ;  
    private String nameCompany,address,phone,email; 
    private Customer customer; 

    public Reporte() {
    }

    public Reporte(byte[] logotipe, String nameCompany, String address, String phone, String email, Customer customer) {
        this.logotipe = logotipe;
        this.nameCompany = nameCompany;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.customer = customer;
    }

    
    
    
    
    public byte[] getLogotipe() {
        return logotipe;
    }

    public void setLogotipe(byte[] logotipe) {
        this.logotipe = logotipe;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

  
    
    
}
