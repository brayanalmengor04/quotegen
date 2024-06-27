
package com.quotegen.domain;


public class Customer {
   private String nameCompany,address,phone,email;  

    public Customer(String nameCompany, String address, String phone, String email) {
        this.nameCompany = nameCompany;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Customer() {
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
   
   
   
}
