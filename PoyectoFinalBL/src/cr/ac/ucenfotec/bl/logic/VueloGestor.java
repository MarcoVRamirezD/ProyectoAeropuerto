package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.vuelo.Vuelo;
import cr.ac.ucenfotec.bl.entities.vuelo.IVueloDAO;
import cr.ac.ucenfotec.bl.entities.vuelo.MySqlVueloImpl;

import java.util.ArrayList;

public class VueloGestor {
    private IVueloDAO datos;
    public VueloGestor(){
        datos = new MySqlVueloImpl();
    }
    public String registrarVuelo(String cedulaJuridica, String aeropuertoOrigen, String paisOrigen, String horaLlegada, String horaSalida, String estado,
                                 String aeropuertoDestino, String paisDestino, String tipoVuelo, String avion, String gateSalida, String gateLlegada,
                                 String tripulacion) throws Exception {
        Vuelo vueloEncontrado = datos.buscarVuelo(horaLlegada, horaSalida, tripulacion);
        if (vueloEncontrado == null){
            try {
                Vuelo vuelo = new Vuelo(cedulaJuridica, aeropuertoOrigen, paisOrigen, horaLlegada, horaSalida, estado, aeropuertoDestino, paisDestino, tipoVuelo, avion, gateSalida, gateLlegada, tripulacion);
                return datos.registrarVuelo(vuelo);
            } catch (Exception e){
                return "Hubo un error al intentar registrar, revise la información solicitada e intente de nuevo!";
            }
        }
        return "El vuelo con esa información ya existe!";
    }

    public String modificarVuelo(String cedulaJuridica, String aeropuertoOrigen, String paisOrigen, String horaLlegada, String horaSalida, String estado,
                                 String aeropuertoDestino, String paisDestino, String tipoVuelo, String avion, String gateSalida, String gateLlegada,
                                 String tripulacion) throws Exception {
        try {
            Vuelo vuelo = new Vuelo(cedulaJuridica, aeropuertoOrigen, paisOrigen, horaLlegada, horaSalida, estado, aeropuertoDestino, paisDestino, tipoVuelo, avion, gateSalida, gateLlegada, tripulacion);
            return datos.modificarVuelo(vuelo);
        } catch (Exception e){
            return "Hubo un error al intentar actualizar, revise la información e intente de nuevo!";
        }
    }

    public String eliminarVuelo(String horaLlegada, String horaSalida, String tripulacion) throws Exception {
        //Vuelo vueloEncontrado = datos.buscarVuelo(horaLlegada, horaSalida, tripulacion);
        //if (vueloEncontrado == null){
            try {
                return datos.eliminarVuelo(horaLlegada, horaSalida, tripulacion);
            } catch (Exception e){
                return "Hubo un error al intentar eliminar, revise la información e intente de nuevo!";
            }
        //}
        //return "Ese vuelo no existe!";
    }

    public ArrayList<Vuelo> listarVuelos() throws Exception {
        return datos.listarVuelos();
    }
}
