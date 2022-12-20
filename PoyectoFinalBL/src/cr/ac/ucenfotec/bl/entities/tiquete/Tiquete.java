package cr.ac.ucenfotec.bl.entities.tiquete;

/**
 * Esta clase incluye la informacion de tiquete con todos sus atributos, constructores, getters, setters y toString.
 * @Author Marco Ramirez
 */
public class Tiquete {
    /*
    Aquí encontramos los atributos
    */
    private String fecha;
    private String paisOrigen;
    private String aeropuertoOrigen;
    private String paisDestino;
    private String aeropuertoDestino;
    private int numeroAsiento;
    private String precio;
    private String numeroVuelo;
    private String tipoAsiento;

    /*
    Aquí encontramos los constructores
     */
    public Tiquete() {
    }

    public Tiquete(String fecha, String paisOrigen, String aeropuertoOrigen, String paisDestino, String aeropuertoDestino, int numeroAsiento, String precio, String numeroVuelo, String tipoAsiento) {
        this.fecha = fecha;
        this.paisOrigen = paisOrigen;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.paisDestino = paisDestino;
        this.aeropuertoDestino = aeropuertoDestino;
        this.numeroAsiento = numeroAsiento;
        this.precio = precio;
        this.numeroVuelo = numeroVuelo;
        this.tipoAsiento = tipoAsiento;
    }

    /*
        Aquí encontramos los getters and setters
         */
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(String aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(String aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    /*
    Aquí encontramos el toString
     */
    @Override
    public String toString() {
        return "Tiquete{" +
                "fecha='" + fecha + '\'' +
                ", paisOrigen='" + paisOrigen + '\'' +
                ", aeropuertoOrigen='" + aeropuertoOrigen + '\'' +
                ", paisDestino='" + paisDestino + '\'' +
                ", aeropuertoDestino='" + aeropuertoDestino + '\'' +
                ", numeroAsiento=" + numeroAsiento +
                ", precio=" + precio +
                ", numeroVuelo=" + numeroVuelo +
                ", tipoAsiento='" + tipoAsiento + '\'' +
                '}';
    }

    /*
    Aquí encontramos el equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tiquete tiquete = (Tiquete) o;

        if (numeroAsiento != tiquete.numeroAsiento) return false;
        return numeroVuelo == tiquete.numeroVuelo;
    }

}
