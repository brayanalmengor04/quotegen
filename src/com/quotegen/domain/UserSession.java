package com.quotegen.domain;

public class UserSession {
     private static UserSession instance;
    private Usuario usuarioLogIn;
    
    private UserSession() {} // Singleton: Constructor privado
    
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    
    public Usuario getUsuarioLogIn() {
        return usuarioLogIn;
    }
    
    public void setUsuarioLogIn(Usuario usuarioLogIn) {
        this.usuarioLogIn = usuarioLogIn;
    }
}
