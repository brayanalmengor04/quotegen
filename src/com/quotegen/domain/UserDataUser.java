package com.quotegen.domain;

import java.util.ArrayList;

public class UserDataUser {
    private static UserDataUser instance;
    private ArrayList<Usuario> datausuario;

    // Constructor privado para evitar instanciación externa
    private UserDataUser() {
        datausuario = new ArrayList<>();
    }
    
    // Método estático para obtener la instancia única
    public static UserDataUser getInstance() {
        if (instance == null) {
            instance = new UserDataUser();
        }
        return instance;
    }

    public ArrayList<Usuario> getDatausuario() {
        return datausuario;
    }

    public void setDatausuario(ArrayList<Usuario> datausuario) {
        this.datausuario = datausuario;
    }
}
