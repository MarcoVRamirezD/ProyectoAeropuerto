package cr.ac.ucenfotec.bl.entities.gate;

/**
 * Esta clase incluye la informacion del gate con todos sus atributos, constructores, getters, setters y toString.
 * @Author Marco Ramirez
 */
public class Gate {
    /*
    Aquí encontramos los atributos
    */
    private String nombre;
    private String codigo;
    private String ubicacion;

    /*
    Aquí encontramos los constructores
     */
    public Gate() {
    }

    public Gate(String nombre, String codigo, String ubicacion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /*
    Aquí encontramos el toString
     */
    @Override
    public String toString() {
        return "Gate{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }

    /*
    Aquí encontramos el equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gate gate = (Gate) o;

        return codigo == gate.codigo;
    }

}
