package logica;

import igu.PantallaPrincipal;


/**
 *
 * @author axelb
 */
public class TPPeluqueriaCanina {

    
    public static void main(String[] args) {
        
        Controladora controladora = new Controladora();
        PantallaPrincipal pantalla = new PantallaPrincipal(controladora);
        controladora.setPantalla(pantalla);
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        
        
    }
    
}
