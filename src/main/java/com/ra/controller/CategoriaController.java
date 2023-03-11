/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ra.controller;


import com.ra.ejb.CategoriaFacadeLocal;
import com.ra.model.Categoria;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped; //verifique el paquete view y no bean
import javax.inject.Named;

/**
 *
 * @author ramos
 */
@Named //valida a partir de jsf 2.2
@ViewScoped

public class CategoriaController implements Serializable{
    
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
    @PostConstruct
    public void init(){
        categoria = new Categoria();
    }
    
    
    public void registrar(){
        try {
            categoriaEJB.create(categoria);
            
        } catch (Exception e) {
            //mensaje prime
        }
    }
    
}
