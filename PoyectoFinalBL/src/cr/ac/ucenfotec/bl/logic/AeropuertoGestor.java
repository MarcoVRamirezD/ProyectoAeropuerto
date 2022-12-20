package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.aeropuerto.Aeropuerto;
import cr.ac.ucenfotec.bl.entities.aeropuerto.IAeropuertoDAO;
import cr.ac.ucenfotec.bl.entities.aeropuerto.MySqlAeropuertoImpl;

import java.util.ArrayList;

public class AeropuertoGestor {
    private IAeropuertoDAO datos;
    public AeropuertoGestor(){
        datos = new MySqlAeropuertoImpl();
    }

    public String registrarAeropuerto(String nombreAeropuerto, String codigoAeropuerto, String codigoPais, String identificacionAdministrador) throws Exception{
        Aeropuerto aeropuertoEncontrado = datos.buscarAeropuerto(codigoAeropuerto);
        if (aeropuertoEncontrado == null){
            try{
                Aeropuerto aeropuerto = new Aeropuerto(nombreAeropuerto, codigoAeropuerto, codigoPais, identificacionAdministrador);
                return datos.registrarAeropuerto(aeropuerto);
            } catch (Exception e){
                return "Hubo un error al intentar registrar, revise la información solicitada e intente de nuevo!";
            }
        }
        return "El aeropuerto con el código "+ codigoAeropuerto +", ya está registrado!";
    }

    public String modificarAeropuerto(String nombreAeropuerto, String codigoAeropuerto, String codigoPais, String identificacionAdministrador) throws Exception{
        try{
            Aeropuerto aeropuerto = new Aeropuerto(nombreAeropuerto, codigoAeropuerto, codigoPais, identificacionAdministrador);
            return datos.modificarAeropuerto(aeropuerto);
        } catch (Exception e){
            return "Hubo un error al intentar actualizar, revise la información e intente de nuevo!";
        }
    }

    public String eliminarAeropuerto(String codigoAeropuerto) throws Exception{
        Aeropuerto aeropuertoEncontrado = datos.buscarAeropuerto(codigoAeropuerto);
        if (aeropuertoEncontrado != null){
            try {
                return datos.eliminarAeropuerto(codigoAeropuerto);
            } catch (Exception e){
                return "Hubo un error al intentar eliminar, revise la información e intente de nuevo!";
            }
        }
        return "El aeropuerto con el código "+codigoAeropuerto+", no existe!";
    }

    public ArrayList<Aeropuerto> listarAeropuertos() throws Exception{
        return datos.listarAeropuertos();
    }
}
