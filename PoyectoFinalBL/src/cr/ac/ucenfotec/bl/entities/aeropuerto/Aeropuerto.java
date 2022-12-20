package cr.ac.ucenfotec.bl.entities.aeropuerto;
/*
Aquí se pueden encontrar los imports
 */
import cr.ac.ucenfotec.bl.entities.administrador.Administrador;

import java.util.Objects;

/**
 * Esta clase incluye la informacion del aeropuerto con todos sus atributos, constructores, getters, setters y toString.
 * @Author Marco Ramirez
 */
public class Aeropuerto {
    /*
    Aquí encontramos los atributos
    */
    private String nombre;
    private String codigoAeropuerto;
    private String codigoPais;
    private String identificacionAdministrador;

    /*
    Aquí encontramos los constructores
     */
    public Aeropuerto() {
    }

    public Aeropuerto(String nombre, String codigoAeropuerto, String codigoPais) {
        this.nombre = nombre;
        this.codigoAeropuerto = codigoAeropuerto;
        this.codigoPais = codigoPais;
    }

    public Aeropuerto(String nombre, String codigoAeropuerto, String codigoPais, String identificacionAdministrador) {
        this.nombre = nombre;
        this.codigoAeropuerto = codigoAeropuerto;
        this.codigoPais = codigoPais;
        this.identificacionAdministrador = identificacionAdministrador;
    }

    /*
    Aquí encontramos los getters and setters
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoAeropuerto() {
        return codigoAeropuerto;
    }

    public void setCodigoAeropuerto(String codigoAeropuerto) {
        this.codigoAeropuerto = codigoAeropuerto;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getIdentificacionAdministrador() {
        return identificacionAdministrador;
    }

    public void setIdentificacionAdministrador(String identificacionAdministrador) {
        this.identificacionAdministrador = identificacionAdministrador;
    }
    /*
    Aquí encontramos el toString
     */

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "nombre='" + nombre + '\'' +
                ", codigoAeropuerto=" + codigoAeropuerto +
                ", codigoPais='" + codigoPais + '\'' +
                ", identificacionAdministrador='" + identificacionAdministrador + '\'' +
                '}';
    }
    /*
    Aquí encontramos el equals
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aeropuerto that = (Aeropuerto) o;

        if (codigoAeropuerto != that.codigoAeropuerto) return false;
        return Objects.equals(identificacionAdministrador, that.identificacionAdministrador);
    }
}
