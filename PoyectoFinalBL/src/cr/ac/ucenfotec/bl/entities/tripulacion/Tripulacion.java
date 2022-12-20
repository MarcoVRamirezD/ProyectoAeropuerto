package cr.ac.ucenfotec.bl.entities.tripulacion;

/*
Aquí se pueden encontrar los imports
 */
import java.util.ArrayList;
import cr.ac.ucenfotec.bl.entities.miembroTripulacion.MiembroTripulacion;

/**
 * Esta clase incluye la informacion de tripulacion con todos sus atributos, constructores, getters, setters y toString.
 * @Author Marco Ramirez
 */
public class Tripulacion {
    /*
    Aquí encontramos los atributos
    */
    private int codigo;
    private String nombreClave;
    protected ArrayList<MiembroTripulacion> miembrosTripulacion = new ArrayList<>();

    /*
    Aquí encontramos los constructores
     */
    public Tripulacion() {
    }

    public Tripulacion(int codigo, String nombreClave, ArrayList<MiembroTripulacion> miembrosTripulacion) {
        this.codigo = codigo;
        this.nombreClave = nombreClave;
        this.miembrosTripulacion = miembrosTripulacion;
    }

    /*
    Aquí encontramos los getters and setters
     */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreClave() {
        return nombreClave;
    }

    public void setNombreClave(String nombreClave) {
        this.nombreClave = nombreClave;
    }

    public ArrayList<MiembroTripulacion> getMiembrosTripulacion() {
        return miembrosTripulacion;
    }

    public void setMiembrosTripulacion(ArrayList<MiembroTripulacion> miembrosTripulacion) {
        this.miembrosTripulacion = miembrosTripulacion;
    }

    /*
    Aquí encontramos el toString
     */
    @Override
    public String toString() {
        return "Tripulacion{" +
                "codigo=" + codigo +
                ", nombreClave='" + nombreClave + '\'' +
                ", miembrosTripulacion=" + miembrosTripulacion +
                '}';
    }

    /*
    Aquí encontramos el equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tripulacion that = (Tripulacion) o;

        return codigo == that.codigo;
    }

}
