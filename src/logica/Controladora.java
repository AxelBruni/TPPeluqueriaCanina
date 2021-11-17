package logica;

import igu.PantallaPrincipal;
import persistencia.ControladoraPersistencia;


public class Controladora {
    
    private ControladoraPersistencia contPers;
    private Mascota mascota;
    private PantallaPrincipal pantalla;
    
    public Controladora () {
        
        this.contPers = new ControladoraPersistencia();
    }
    
    
    /*Crea un objeto de la clase Mascota, y se lo pasa por parámetro al objeto controladora de persistencia para
    que esta cree la fila en la base de datos. Al tener el objeto mascota en memoria, pero también mapeado en la BD,
    el objeto controladora le envía el mensaje a la pantalla para que esta muestre el Nro de cliente generado.
    */
    
    public void crearMascota (String nombrePerro, String raza, String color, 
                              Boolean esAlergico, Boolean atencionEspecial, String nombreDuenio, 
                              String celularDuenio, String observaciones) {
        
        mascota = new Mascota(nombrePerro, raza, color, esAlergico, atencionEspecial, nombreDuenio, celularDuenio, observaciones);
        
        contPers.crearMascota(mascota);
        
        pantalla.confirmarCliente(this.mostrarId());
        
        
    }
    
    public String mostrarId() {
        return mascota.getNumCliente().toString();
    }

    /* La relación entre las clases Controladora y PantallaPrincipal es bidireccional, por lo cual es
       necesario tener un método para setearle a un objeto Controladora un objeto PantallaPrincipal. 
       El sentido contrario de la relación se resuelve en el constructor de la clase PantallaPrincipal. 
    */
    public void setPantalla(PantallaPrincipal pantalla) {
        this.pantalla = pantalla;
    }
    
    
}
