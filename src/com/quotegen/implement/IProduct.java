/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.quotegen.implement;

import com.quotegen.domain.Producto;
import java.util.ArrayList;


public interface IProduct {
     ArrayList<Producto> readProduct (String urlJson); 
    void insertProduct(Producto usuario); 
    void updateProduct(Producto producto);
}
