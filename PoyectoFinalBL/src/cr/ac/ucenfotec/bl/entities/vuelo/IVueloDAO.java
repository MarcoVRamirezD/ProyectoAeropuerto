package cr.ac.ucenfotec.bl.entities.vuelo;

import java.util.ArrayList;

public interface IVueloDAO {
    String registrarVuelo(Vuelo vuelo) throws Exception;
    String modificarVuelo(Vuelo vuelo) throws Exception;
    String eliminarVuelo(String horaLlegada, String horaSalida, String tripulacion) throws Exception;
    ArrayList<Vuelo> listarVuelos() throws Exception;
    Vuelo buscarVuelo(String horaLlegada, String horaSalida, String tripulacion) throws Exception;
}
