package cr.ac.ucenfotec.bl.entities.movimiento;

/*
Aquí se pueden encontrar los imports
 */
import cr.ac.ucenfotec.bl.entities.gate.Gate;
import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.entities.aeropuerto.Aeropuerto;

public class Movimiento {
    /*
    Aquí encontramos los atributos
    */
    private int numeroVuelo;
    private Gate gate;
    private LineaAerea lineaAerea;
    private Aeropuerto aeropuertoSalida;
    private Aeropuerto aeropuertoLlegada;

    /*
    Aquí encontramos los constructores
     */
    public Movimiento() {
    }

    public Movimiento(int numeroVuelo, Gate gate, LineaAerea lineaAerea, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoLlegada) {
        this.numeroVuelo = numeroVuelo;
        this.gate = gate;
        this.lineaAerea = lineaAerea;
        this.aeropuertoSalida = aeropuertoSalida;
        this.aeropuertoLlegada = aeropuertoLlegada;
    }

    /*
    Aquí encontramos los getters and setters
     */
    public int getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(int numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public LineaAerea getLineaAerea() {
        return lineaAerea;
    }

    public void setLineaAerea(LineaAerea lineaAerea) {
        this.lineaAerea = lineaAerea;
    }

    public Aeropuerto getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
        this.aeropuertoSalida = aeropuertoSalida;
    }

    public Aeropuerto getAeropuertoLlegada() {
        return aeropuertoLlegada;
    }

    public void setAeropuertoLlegada(Aeropuerto aeropuertoLlegada) {
        this.aeropuertoLlegada = aeropuertoLlegada;
    }

    /*
    Aquí encontramos el toString
     */
    @Override
    public String toString() {
        return "Movimiento{" +
                "numeroVuelo=" + numeroVuelo +
                ", gate=" + gate +
                ", lineaAerea=" + lineaAerea +
                ", aeropuertoSalida=" + aeropuertoSalida +
                ", aeropuertoLlegada=" + aeropuertoLlegada +
                '}';
    }

    /*
    Aquí encontramos el equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movimiento that = (Movimiento) o;

        return numeroVuelo == that.numeroVuelo;
    }

}
