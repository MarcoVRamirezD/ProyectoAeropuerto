package cr.ac.ucenfotec.bl.entities.salida;

/*
Aquí se pueden encontrar los imports
 */
import cr.ac.ucenfotec.bl.entities.aeropuerto.Aeropuerto;
import cr.ac.ucenfotec.bl.entities.gate.Gate;
import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.entities.movimiento.Movimiento;

public class Salida extends Movimiento{

    /*
    Aquí encontramos los constructores
     */
    public Salida() {
    }

    public Salida(int numeroVuelo, Gate gate, LineaAerea lineaAerea, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoLlegada) {
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
