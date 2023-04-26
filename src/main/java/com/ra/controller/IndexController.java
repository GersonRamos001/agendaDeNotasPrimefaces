/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ra.controller;

import com.ra.ejb.UsuarioFacadeLocal;
import com.ra.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ramos
 */
@Named
@ViewScoped
public class IndexController implements Serializable {

    @EJB
    private UsuarioFacadeLocal EJBUsuario;

    private Usuario usuario;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion() {
        Usuario us;
        String redireccion = null;
        try {
            
           us =  EJBUsuario.iniciarSesion(usuario);
           if(us!=null){
                 redireccion = "/protegido/principal?faces-redirect=true";
           }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","Credenciales incorrectos"));
        }

        } catch (Exception e) {
              FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso","error"));
        }
        return redireccion;
    }

}
