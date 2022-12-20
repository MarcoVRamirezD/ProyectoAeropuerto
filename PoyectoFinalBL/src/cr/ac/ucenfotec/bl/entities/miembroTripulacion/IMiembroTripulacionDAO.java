package cr.ac.ucenfotec.bl.entities.miembroTripulacion;

import java.util.ArrayList;

public interface IMiembroTripulacionDAO {
    String registrarMiembroTripulacion(MiembroTripulacion miembroTripulacion) throws Exception;
    String modificarMiembroTripulacion(MiembroTripulacion miembroTripulacion) throws Exception;
    ArrayList<MiembroTripulacion> listarMiembrosTripulacion() throws Exception;
    MiembroTripulacion buscarMiembroTripulacion(String numeroLicencia) throws Exception;
    MiembroTripulacion validarMiembroTripulacion(MiembroTripulacion miembroTripulacion) throws Exception;
}
