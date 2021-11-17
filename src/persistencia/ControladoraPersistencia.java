package persistencia;

import logica.Mascota;


public class ControladoraPersistencia {
    
    MascotaJpaController mascotaJPA = new MascotaJpaController();
    
    
    /*Dado que es necesario tener un objeto Mascota creado en memoria, para poder retornar
      el nro de cliente, se utiliza solo el constructor que recibe por parámetro dicho objeto.
    */
    public void crearMascota(Mascota masc){
        
        mascotaJPA.create(masc);
    }
    
}
