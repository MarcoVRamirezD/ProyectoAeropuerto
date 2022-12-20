package cr.ac.ucenfotec.bl.entities.avion;

import java.util.ArrayList;

public interface IAvionDAO {
    String registrarAvion(Avion avion)throws Exception;
    String modificarAvion(Avion avion)throws Exception;
    String eliminarAvion(String numeroPlaca) throws Exception;
    ArrayList<Avion> listarAviones()throws Exception;
    Avion buscarAvion(String numeroPlaca)throws Exception;
}
