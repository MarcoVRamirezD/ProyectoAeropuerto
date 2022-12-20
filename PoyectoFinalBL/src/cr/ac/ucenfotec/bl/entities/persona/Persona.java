package cr.ac.ucenfotec.bl.entities.persona;

/*
Aquí se pueden encontrar los imports
 */
import java.util.Objects;

public class Persona {
    /*
    Aquí encontramos los atributos
    */
    private String nombre;
    private String apellidos;
    private String identificacion;
    private String correo;
    private String contrasenna;
    private String direccion;
    private String nacionalidad;

    /*
    Aquí encontramos los constructores
     */
    public Persona() {
    }

    public Persona(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.correo = correo;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
    }

    public Persona(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion, String nacionalidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.correo = correo;
        this.contrasenna = contrasenna;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /*
    Aquí encontramos el toString
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }

    /*
    Aquí encontramos el equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        return Objects.equals(identificacion, persona.identificacion);
    }


}
