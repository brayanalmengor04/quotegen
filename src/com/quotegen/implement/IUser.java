
package com.quotegen.implement;

import com.quotegen.domain.Usuario;
import java.util.ArrayList;
import java.util.List;


public interface IUser {
    
    Usuario logIn (Usuario usuario);
    ArrayList<Usuario> readUser (String urlJson); 
    void insertUser(Usuario usuario);
    
}
