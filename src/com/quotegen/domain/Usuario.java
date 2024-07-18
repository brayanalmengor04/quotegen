
package com.quotegen.domain;

public class Usuario extends Rol{
    private String username , email,password; 

    public Usuario(String username, String email, String password, String nameRol, Boolean permission) {
        super(nameRol, permission);
        this.username = username;
        this.email = email;
        this.password = password;
    }
    // Si le agregamos permision true va ser admin - si no user normal  
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
   
}
