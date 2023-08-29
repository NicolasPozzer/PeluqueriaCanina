
package com.mycompany.peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mascota implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//Para que se cree automaticamente y el usuario no tenga q agregar su id
    private int numCliente;
    @Basic
    private String nombreMascota;
    private String raza;
    private String color;
    private String alergico;
    private String atencion_especial;
    private String observaciones;
    
    /*===Indicamos la relacion 1 a 1 de la mascota con su duenio===*/
    @OneToOne
    private Duenio unDuenio;
    /*============================================================*/
    
    public Mascota() {
    }

    public Mascota(int numCliente, String nombreMascota, String raza, String color, String alergico, String atencion_especial, String observaciones, Duenio unDuenio) {
        this.numCliente = numCliente;
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencion_especial = atencion_especial;
        this.observaciones = observaciones;
        this.unDuenio = unDuenio;
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getAtencion_especial() {
        return atencion_especial;
    }

    public void setAtencion_especial(String atencion_especial) {
        this.atencion_especial = atencion_especial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Duenio getUnDuenio() {
        return unDuenio;
    }

    public void setUnDuenio(Duenio unDuenio) {
        this.unDuenio = unDuenio;
    }
    
    
    
    
}
