package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author axelb
 */

@Entity
@Table(name="Mascotas")
public class Mascota implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer numCliente;
    
    @Basic
    private String nombrePerro;
    private String raza;
    private String color;
    private Boolean esAlergico;
    private Boolean atencionEspecial;
    private String nombreDuenio;
    private String celularDuenio;
    private String observaciones;

    public Mascota() {
    }

    public Mascota(Integer numCliente, String nombrePerro, String raza, String color, Boolean esAlergico, Boolean atencionEspecial, String nombreDuenio, String celularDuenio, String observaciones) {
        this.numCliente = numCliente;
        this.nombrePerro = nombrePerro;
        this.raza = raza;
        this.color = color;
        this.esAlergico = esAlergico;
        this.atencionEspecial = atencionEspecial;
        this.nombreDuenio = nombreDuenio;
        this.celularDuenio = celularDuenio;
        this.observaciones = observaciones;
    }

    /*Dado que se optó por la estrategia de que la persistencia tenga la responsabilidad de generar un Nro
      de cliente, que es la PK de esa tabla, al construir el objeto que luego se va a persistir no se debe
      pasarle un valor para esa propiedad.
      Este es el constructor, entonces, que usa la clase Controladora.
    */
    public Mascota(String nombrePerro, String raza, String color, Boolean esAlergico, Boolean atencionEspecial, String nombreDuenio, String celularDuenio, String observaciones) {
        this.nombrePerro = nombrePerro;
        this.raza = raza;
        this.color = color;
        this.esAlergico = esAlergico;
        this.atencionEspecial = atencionEspecial;
        this.nombreDuenio = nombreDuenio;
        this.celularDuenio = celularDuenio;
        this.observaciones = observaciones;
    }

    
    
    public Integer getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(Integer numCliente) {
        this.numCliente = numCliente;
    }

    public String getNombrePerro() {
        return nombrePerro;
    }

    public void setNombrePerro(String nombrePerro) {
        this.nombrePerro = nombrePerro;
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

    public Boolean getEsAlergico() {
        return esAlergico;
    }

    public void setEsAlergico(Boolean esAlergico) {
        this.esAlergico = esAlergico;
    }

    public Boolean getAtencionEspecial() {
        return atencionEspecial;
    }

    public void setAtencionEspecial(Boolean atencionEspecial) {
        this.atencionEspecial = atencionEspecial;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    public String getCelularDuenio() {
        return celularDuenio;
    }

    public void setCelularDuenio(String celularDuenio) {
        this.celularDuenio = celularDuenio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    //Para ver los objetos creados en la terminal
    @Override
    public String toString() {
        return "Mascota{" + "numCliente=" + numCliente + ", nombrePerro=" + nombrePerro + ", raza=" + raza + ", color=" + color + ", esAlergico=" + esAlergico + ", atencionEspecial=" + atencionEspecial + ", nombreDuenio=" + nombreDuenio + ", celularDuenio=" + celularDuenio + ", observaciones=" + observaciones + '}';
    }
    
    
    
}
