package cr.ac.ucenfotec.bl.entities.pais;

/*
Aquí se pueden encontrar los imports
 */
import java.util.Objects;

/**
 * Esta clase incluye la informacion de pais con todos sus atributos, constructores, getters, setters y toString.
 * @Author Marco Ramirez
 */
public class Pais {
    /*
    Aquí encontramos los atributos
    */
    private String nombre;
    private String abreviatura;

    /*
    Aquí encontramos los constructores
     */
    public Pais() {
    }

    public Pais(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /*
    Aquí encontramos el toString
     */
    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                '}';
    }

    /*
    Aquí encontramos el equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pais pais = (Pais) o;

        return Objects.equals(nombre, pais.nombre);
    }

}