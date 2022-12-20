package cr.ac.ucenfotec.bl.entities.gate;

import java.util.ArrayList;

public interface IGateDAO {

    String registrarGate(Gate gate) throws Exception;
    String modificarGate(Gate gate) throws Exception;
    String eliminarGate(String codigo) throws Exception;
    ArrayList<Gate> listarGates() throws Exception;
    Gate buscarGate(String codigo) throws Exception;

}
