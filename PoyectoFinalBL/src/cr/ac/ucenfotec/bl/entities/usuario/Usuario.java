package cr.ac.ucenfotec.bl.entities.usuario;

/*
Aquí se pueden encontrar los imports
 */
import cr.ac.ucenfotec.bl.entities.persona.Persona;
import java.time.LocalDate;

public class Usuario extends Persona{
    /*
    Aquí encontramos los atributos
    */
    private LocalDate fechaNacimiento;
    private int edad;

    /*
    Aquí encontramos los constructores
    */
    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad, LocalDate fechaNacimiento, int edad) {
        super(nombre, apellidos, identificacion, correo, direccion, nacionalidad);
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
    }

    public Usuario(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion, String nacionalidad, LocalDate fechaNacimiento, int edad) {
        super(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad);
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
    }

    /*
        Aquí encontramos los getters and setters
         */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /*
    Aquí encontramos el toString
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "fechaNacimiento=" + fechaNacimiento +
                ", edad=" + edad +
                '}';
    }
}
