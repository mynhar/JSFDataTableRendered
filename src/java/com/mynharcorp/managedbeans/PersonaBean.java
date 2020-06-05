/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.managedbeans;

import com.mynharcorp.beans.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author Harold M Bonilla L
 */
@Named(value = "personaBean")
@RequestScoped
public class PersonaBean {
    
    private Persona persona = new Persona();
    private static List<Persona> personaList = new ArrayList();

    /**
     * Creates a new instance of PersonaBean
     */
    public PersonaBean() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }
        
    public void agregar(){
        PersonaBean.personaList.add(this.persona);
    }
    
     public void eliminar(Persona obj){
        boolean remove = PersonaBean.personaList.remove(obj);
    }
     
     
     /**
      * 
      * @param context : contexto de JSF. Acceso a todad las variables manejadas por el framework.
      * @param tovalidate : Componente que invoca al metodo. Desde donde se esta invocando.
      * @param value : El valor que trae el componento. El texto que se ingresa.
      */
     public void validar(FacesContext context, UIComponent toValidate, Object value){
         
         context = FacesContext.getCurrentInstance();
         String texto = (String) value;
         
         if(!texto.equalsIgnoreCase("M") && !texto.equalsIgnoreCase("F")){
             ((UIInput)toValidate).setValid(false);
             context.addMessage(toValidate.getClientId(context), new FacesMessage("Sexo NO Valido!"));
         }
     }
}
