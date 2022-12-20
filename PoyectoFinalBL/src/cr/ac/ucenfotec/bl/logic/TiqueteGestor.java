package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.tiquete.Tiquete;
import cr.ac.ucenfotec.bl.entities.tiquete.ITiqueteDAO;
import cr.ac.ucenfotec.bl.entities.tiquete.MySqlTiqueteImpl;

import java.util.ArrayList;

public class TiqueteGestor {

    private ITiqueteDAO datos;
    public TiqueteGestor(){
        datos = new MySqlTiqueteImpl();
    }
    public String registrarTiquete(String fecha, String paisOrigen, String aeropuertoOrigen, String paisDestino, String aeropuertoDestino,
                                   String numeroAsiento, String precio, String numeroVuelo, String tipoAsiento) throws Exception {
        int numAsiento = Integer.parseInt(numeroAsiento);
        Tiquete tiqueteEncontrado = datos.buscarTiquete(numAsiento, numeroVuelo);
        if (tiqueteEncontrado == null){
            try{
                Tiquete tiquete = new Tiquete(fecha, paisOrigen, aeropuertoOrigen, paisDestino, aeropuertoDestino, numAsiento, precio, numeroVuelo, tipoAsiento);
                return datos.registrarTiquete(tiquete);
            } catch (Exception e){
                return "Hubo un error al intentar registrar, revise la información solicitada e intente de nuevo!";
            }
        }
        return "El tiquete se registró con éxito!";
    }

    public String modificarTiquete(String fecha, String paisOrigen, String aeropuertoOrigen, String paisDestino, String aeropuertoDestino,
                                   String numeroAsiento, String precio, String numeroVuelo, String tipoAsiento) throws Exception {
        try{
            int numAsiento = Integer.parseInt(numeroAsiento);
            Tiquete tiquete = new Tiquete(fecha, paisOrigen, aeropuertoOrigen, paisDestino, aeropuertoDestino, numAsiento, precio, numeroVuelo, tipoAsiento);
            return datos.modificarTiquete(tiquete);
        }catch (Exception e){
            return "Hubo un error al intentar actualizar, revise la información e intente de nuevo!";
        }
    }

    public String eliminarTiquete(String numeroAsiento, String numeroVuelo) throws Exception {
        int numAsiento = Integer.parseInt(numeroAsiento);
        Tiquete tiqueteEncontrado = datos.buscarTiquete(numAsiento, numeroVuelo);
        if (tiqueteEncontrado != null){
            try{
                return datos.eliminarTiquete(numAsiento, numeroVuelo);
            } catch (Exception e){
                return "Hubo un error al intentar eliminar, revise la información e intente de nuevo!";
            }
        }
        return "Ese tiquete no existe!";
    }

    public ArrayList<Tiquete> listarTiquetes() throws Exception {
        return datos.listarTiquetes();
    }
}
