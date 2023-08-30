
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

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void editarDatos(Mascota masco, String nombreMasco, String raza,
            String color, String observaciones, String alergico,
            String atencionEsp, String nombreDuenio, String celDuenio) {
        
        masco.setNombreMascota(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAtencion_especial(atencionEsp);
        masco.setAlergico(alergico);
        
        //modifico la mascota
        controlPersis.editarMascota(masco);
        //creamos el metodo buscarDuenio en la controladora logica para
        //poder utilizarlo cuando querramos buscar un duenio
        Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        duenio.setCelDuenio(celDuenio);
        duenio.setNombre(nombreDuenio);
        
        //Llamar al modificar Duenio
        this.modificarDuenio(duenio);
        
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
    
    
}
