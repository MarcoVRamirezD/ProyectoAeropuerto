package cr.ac.ucenfotec.bl.entities.miembroTripulacion;

/*
Aquí se pueden encontrar los imports
 */
import cr.ac.ucenfotec.bl.entities.persona.Persona;
import java.util.Objects;

public class MiembroTripulacion extends Persona{
    /*
    Aquí encontramos los atributos
    */
    private String genero;
    private int annosExperiencia;
    private String fechaGraduacion;
    private String numeroLicencia;
    private String puesto;
    private String telefono;

    /*
    Aquí encontramos los constructores
     */
    public MiembroTripulacion() {
    }

    public MiembroTripulacion(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion, String nacionalidad, String genero, int annosExperiencia, String fechaGraduacion, String numeroLicencia, String puesto, String telefono) {
        super(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad);
        this.genero = genero;
        this.annosExperiencia = annosExperiencia;
        this.fechaGraduacion = fechaGraduacion;
        this.numeroLicencia = numeroLicencia;
        this.puesto = puesto;
        this.telefono = telefono;
    }

    /*
    Aquí encontramos los getters and setters
     */

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnnosExperiencia() {
        return annosExperiencia;
    }

    public void setAnnosExperiencia(int annosExperiencia) {
        this.annosExperiencia = annosExperiencia;
    }

    public String getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(String fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /*
    Aquí encontramos el toString
     */
    @Override
    public String toString() {
        return "MiembroTripulacion{" +
                "genero='" + genero + '\'' +
                ", annosExperiencia=" + annosExperiencia +
                ", fechaGraduacion='" + fechaGraduacion + '\'' +
                ", numeroLicencia='" + numeroLicencia + '\'' +
                ", puesto='" + puesto + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    /*
    Aquí encontramos el equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MiembroTripulacion that = (MiembroTripulacion) o;

        return Objects.equals(numeroLicencia, that.numeroLicencia);
    }

}
