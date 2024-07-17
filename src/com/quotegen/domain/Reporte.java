
package com.quotegen.domain;

public class Reporte {
    private byte [] logotipe ;  
    private String namecompany,addresscompany,phonecompany,emailcompany; 
    private Customer customer; 

    public Reporte() {
    }

    public Reporte(byte[] logotipe, String namecompany, String addresscompany, String phonecompany, String emailcompany, Customer customer) {
        this.logotipe = logotipe;
        this.namecompany = namecompany;
        this.addresscompany = addresscompany;
        this.phonecompany = phonecompany;
        this.emailcompany = emailcompany;
        this.customer = customer;
    }

    public Reporte(String namecompany, String addresscompany, String phonecompany, String emailcompany, Customer customer) {
        this.namecompany = namecompany;
        this.addresscompany = addresscompany;
        this.phonecompany = phonecompany;
        this.emailcompany = emailcompany;
        this.customer = customer;
    }

    
    public byte[] getLogotipe() {
        return logotipe;
    }

    public void setLogotipe(byte[] logotipe) {
        this.logotipe = logotipe;
    }

    public String getNamecompany() {
        return namecompany;
    }

    public void setNamecompany(String namecompany) {
        this.namecompany = namecompany;
    }

    public String getAddresscompany() {
        return addresscompany;
    }

    public void setAddresscompany(String addresscompany) {
        this.addresscompany = addresscompany;
    }

    public String getPhonecompany() {
        return phonecompany;
    }

    public void setPhonecompany(String phonecompany) {
        this.phonecompany = phonecompany;
    }

    public String getEmailcompany() {
        return emailcompany;
    }

    public void setEmailcompany(String emailcompany) {
        this.emailcompany = emailcompany;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    
}
