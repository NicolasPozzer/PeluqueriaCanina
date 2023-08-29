
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistence.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color,
            String observaciones, String alergico, String atencionEsp,
            String nombreDuenio, String celDuenio) {
        
        //Creamos el duenio y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        
        //Creamos la mascota y asignamos los valores
        Mascota masco = new Mascota();
        masco.setNombreMascota(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atencionEsp);
        masco.setObservaciones(observaciones);
        //Y asigmanos el duenio de la mascota por medio del 1 a 1 asignado
        masco.setUnDuenio(duenio);
        //----------------------------------------------------------------
        
        //Guardamos en la base de datos
        controlPersis.guardar(duenio, masco);
        
        
    }

    public List<Mascota> traerMascotas() {
        //metodo que retorna algo asi q si o si tiene q tener un return
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }
    
    
}
