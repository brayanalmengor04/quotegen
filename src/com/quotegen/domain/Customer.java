package com.quotegen.domain;

public class Customer {

    private String namecustommer, addresscustommer, phonecustommer, emailcustommer;

    public Customer() {
    }

    public Customer(String namecustommer, String addresscustommer, String phonecustommer, String emailcustommer) {
        this.namecustommer = namecustommer;
        this.addresscustommer = addresscustommer;
        this.phonecustommer = phonecustommer;
        this.emailcustommer = emailcustommer;
    }

    public String getNamecustommer() {
        return namecustommer;
    }

    public void setNamecustommer(String namecustommer) {
        this.namecustommer = namecustommer;
    }

    public String getAddresscustommer() {
        return addresscustommer;
    }

    public void setAddresscustommer(String addresscustommer) {
        this.addresscustommer = addresscustommer;
    }

    public String getPhonecustommer() {
        return phonecustommer;
    }

    public void setPhonecustommer(String phonecustommer) {
        this.phonecustommer = phonecustommer;
    }

    public String getEmailcustommer() {
        return emailcustommer;
    }

    public void setEmailcustommer(String emailcustommer) {
        this.emailcustommer = emailcustommer;
    }

}
