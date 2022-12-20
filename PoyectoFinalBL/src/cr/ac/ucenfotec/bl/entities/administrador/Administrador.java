package cr.ac.ucenfotec.bl.entities.administrador;

/*
Aquí se pueden encontrar los imports
 */
import cr.ac.ucenfotec.bl.entities.usuario.Usuario;
import java.time.LocalDate;

public class Administrador extends Usuario{
    /*
    Aquí encontramos los atributos
     */
    private String genero;

    /*
    Aquí encontramos los constructores
     */
    public Administrador() {
    }

    public Administrador(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero) {
        super(nombre, apellidos, identificacion, correo, direccion, nacionalidad, fechaNacimiento, edad);
        this.genero = genero;
    }

    public Administrador(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero) {
        super(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad, fechaNacimiento, edad);
        this.genero = genero;
    }

    /*
        Aquí encontramos los getters and setters
         */
    public String getGenero() {
        return genero;
    }

    /*
    Aquí encontramos el toString
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /*
    Aquí encontramos el equals
     */
    @Override
    public String toString() {
        return "Administrador{" +
                "genero='" + genero + '\'' +
                '}';
    }
}
