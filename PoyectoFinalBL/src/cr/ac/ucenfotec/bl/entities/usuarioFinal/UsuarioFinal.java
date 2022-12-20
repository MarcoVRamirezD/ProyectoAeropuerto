package cr.ac.ucenfotec.bl.entities.usuarioFinal;

/*
Aquí se pueden encontrar los imports
 */
import cr.ac.ucenfotec.bl.entities.usuario.Usuario;
import cr.ac.ucenfotec.bl.entities.tiquete.Tiquete;
import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioFinal extends Usuario{
    /*
    Aquí encontramos los atributos
    */
    private String provincia;
    private String canton;
    private String distrito;
    private ArrayList<Tiquete> tiquetes;

    /*
    Aquí encontramos los constructores
     */
    public UsuarioFinal() {
    }

    public UsuarioFinal(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad, LocalDate fechaNacimiento, int edad, String provincia, String canton, String distrito) {
        super(nombre, apellidos, identificacion, correo, direccion, nacionalidad, fechaNacimiento, edad);
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
    }

    public UsuarioFinal(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion, String nacionalidad, LocalDate fechaNacimiento, int edad, String provincia, String canton, String distrito) {
        super(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad, fechaNacimiento, edad);
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
    }

    public UsuarioFinal(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad, LocalDate fechaNacimiento, int edad, String provincia, String canton, String distrito, ArrayList<Tiquete> tiquetes) {
        super(nombre, apellidos, identificacion, correo, direccion, nacionalidad, fechaNacimiento, edad);
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.tiquetes = tiquetes;
    }

    public UsuarioFinal(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion, String nacionalidad, LocalDate fechaNacimiento, int edad, String provincia, String canton, String distrito, ArrayList<Tiquete> tiquetes) {
        super(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad, fechaNacimiento, edad);
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.tiquetes = tiquetes;
    }

    /*
        Aquí encontramos los getters and setters
         */
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public ArrayList<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(ArrayList<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }

    /*
    Aquí encontramos el toString
     */
    @Override
    public String toString() {
        return "UsuarioFinal{" +
                "provincia='" + provincia + '\'' +
                ", canton='" + canton + '\'' +
                ", distrito='" + distrito + '\'' +
                ", tiquetes=" + tiquetes +
                '}';
    }
}
