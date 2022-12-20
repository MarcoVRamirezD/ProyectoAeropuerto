package cr.ac.ucenfotec.bl.entities.vuelo;

/*
Aquí se pueden encontrar los imports
 */
import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.entities.aeropuerto.Aeropuerto;
import cr.ac.ucenfotec.bl.entities.pais.Pais;
import cr.ac.ucenfotec.bl.entities.avion.Avion;
import cr.ac.ucenfotec.bl.entities.gate.Gate;
import cr.ac.ucenfotec.bl.entities.tripulacion.Tripulacion;

import java.util.Objects;

/**
 * Esta clase incluye la informacion de vuelo con todos sus atributos, constructores, getters, setters y toString.
 * @Author Marco Ramirez
 */
public class Vuelo {
    /*
    Aquí encontramos los atributos
    */
    private String lineaAerea;
    private String aeropuertoOrigen;
    private String paisOrigen;
    private String horaLlegada;
    private String horaSalida;
    private String estado;
    private String aeropuertoDestino;
    private String paisDestino;
    private String tipoVuelo;
    private String avion;
    private String gateSalida;
    private String gateLlegada;
    private String tripulacion;

    /*
    Aquí encontramos los constructores
     */
    public Vuelo() {
    }

    public Vuelo(String lineaAerea, String aeropuertoOrigen, String paisOrigen, String horaLlegada, String horaSalida, String estado, String aeropuertoDestino, String paisDestino, String tipoVuelo, String avion, String gateSalida, String gateLlegada, String tripulacion) {
        this.lineaAerea = lineaAerea;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.paisOrigen = paisOrigen;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.estado = estado;
        this.aeropuertoDestino = aeropuertoDestino;
        this.paisDestino = paisDestino;
        this.tipoVuelo = tipoVuelo;
        this.avion = avion;
        this.gateSalida = gateSalida;
        this.gateLlegada = gateLlegada;
        this.tripulacion = tripulacion;
    }

    /*
        Aquí encontramos los getters and setters
         */

    public String getLineaAerea() {
        return lineaAerea;
    }

    public void setLineaAerea(String lineaAerea) {
        this.lineaAerea = lineaAerea;
    }

    public String getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(String aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(String aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }

    public String getGateSalida() {
        return gateSalida;
    }

    public void setGateSalida(String gateSalida) {
        this.gateSalida = gateSalida;
    }

    public String getGateLlegada() {
        return gateLlegada;
    }

    public void setGateLlegada(String gateLlegada) {
        this.gateLlegada = gateLlegada;
    }

    public String getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(String tripulacion) {
        this.tripulacion = tripulacion;
    }

    /*
        Aquí encontramos el toString
         */
    @Override
    public String toString() {
        return "Vuelo{" +
                "lineaAerea=" + lineaAerea +
                ", aeropuertoOrigen=" + aeropuertoOrigen +
                ", paisOrigen=" + paisOrigen +
                ", horaLlegada='" + horaLlegada + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", estado='" + estado + '\'' +
                ", aeropuertoDestino=" + aeropuertoDestino +
                ", paisDestino=" + paisDestino +
                ", tipoVuelo='" + tipoVuelo + '\'' +
                ", avion=" + avion +
                ", gateSalida=" + gateSalida +
                ", gateLlegada=" + gateLlegada +
                ", tripulacion=" + tripulacion +
                '}';
    }

    /*
    Aquí encontramos el equals
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vuelo vuelo = (Vuelo) o;

        if (!Objects.equals(horaLlegada, vuelo.horaLlegada)) return false;
        if (!Objects.equals(horaSalida, vuelo.horaSalida)) return false;
        return Objects.equals(tripulacion, vuelo.tripulacion);
    }

}