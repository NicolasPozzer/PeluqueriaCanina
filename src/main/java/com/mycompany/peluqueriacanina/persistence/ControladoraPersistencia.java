
package com.mycompany.peluqueriacanina.persistence;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import java.util.List;

public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        
        //Crear en la db el duenio
        duenioJpa.create(duenio);
        
        //Crear en la db la mascota
        mascoJpa.create(masco);
        
    }

    public List<Mascota> traerMascotas() {
        //devuelve algo si o si asi q usamos return
        return mascoJpa.findMascotaEntities();
    }
    
    
    
    
}
