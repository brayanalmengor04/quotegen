
package com.quotegen.implement;


// Para aplicar el metodo solo intancias esta clase  
                            // Implementar Metodo de IUser
public class UserImplements implements IUser{
    
    // Sobre escribimos el metodo o implementamos metodo 
    @Override
    public String pruebaMetodo(String prueba) { 
        prueba ="Hola Mundo"; 
        
        return prueba;
    }
    
}
