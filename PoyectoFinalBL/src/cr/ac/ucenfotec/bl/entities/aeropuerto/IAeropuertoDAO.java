package cr.ac.ucenfotec.bl.entities.aeropuerto;

import java.util.ArrayList;

public interface IAeropuertoDAO {
    String registrarAeropuerto(Aeropuerto aeropuerto) throws Exception;
    String modificarAeropuerto(Aeropuerto aeropuerto) throws Exception;
    String eliminarAeropuerto(String codigoAeropuerto) throws Exception;
    ArrayList<Aeropuerto> listarAeropuertos() throws Exception;
    Aeropuerto buscarAeropuerto(String codigoAeropuerto) throws Exception;
}
