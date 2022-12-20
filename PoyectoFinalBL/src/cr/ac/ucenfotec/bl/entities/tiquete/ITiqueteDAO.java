package cr.ac.ucenfotec.bl.entities.tiquete;

import java.util.ArrayList;

public interface ITiqueteDAO {
    String registrarTiquete(Tiquete tiquete) throws Exception;
    String modificarTiquete(Tiquete tiquete) throws Exception;
    String eliminarTiquete(int numeroAsiento, String numeroVuelo) throws Exception;
    ArrayList<Tiquete> listarTiquetes() throws Exception;
    Tiquete buscarTiquete(int numeroAsiento, String numeroVuelo) throws Exception;
}
