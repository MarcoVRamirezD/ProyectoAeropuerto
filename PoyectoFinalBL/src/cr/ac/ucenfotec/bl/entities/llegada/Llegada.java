package cr.ac.ucenfotec.bl.entities.llegada;

/*
Aquí se pueden encontrar los imports
 */
import cr.ac.ucenfotec.bl.entities.aeropuerto.Aeropuerto;
import cr.ac.ucenfotec.bl.entities.gate.Gate;
import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.entities.movimiento.Movimiento;

public class Llegada extends Movimiento{
    /*
    Aquí encontramos los constructores
     */
    public Llegada() {
    }

    public Llegada(int numeroVuelo, Gate gate, LineaAerea lineaAerea, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoLlegada) {
        super(numeroVuelo, gate, lineaAerea, aeropuertoSalida, aeropuertoLlegada);
    }

    /*
        Aquí encontramos el toString
         */
    @Override
    public String toString() {
        return "Llegada{"+super.toString()+"}";
    }
}
