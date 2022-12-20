package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.gate.Gate;
import cr.ac.ucenfotec.bl.entities.gate.IGateDAO;
import cr.ac.ucenfotec.bl.entities.gate.MySqlGateImpl;

import java.util.ArrayList;

public class GateGestor {
    private IGateDAO datos;

    public GateGestor(){
        datos = new MySqlGateImpl();
    }

    public String registrarGate(String nombre, String codigo, String ubicacion) throws Exception{
        Gate gateEncontrado = datos.buscarGate(codigo);

        if (gateEncontrado == null){
            Gate gate = new Gate(nombre, codigo, ubicacion);
            return datos.registrarGate(gate);
        }

        return "El gate con el código "+ codigo + ", ya está registrado!";
    }

    public String modificarGate(String nombre, String codigo, String ubicacion) throws Exception{
        try{
            Gate gate = new Gate(nombre, codigo, ubicacion);
            return datos.modificarGate(gate);
        } catch (Exception e){
            return "Hubo un error al intentar actualizar, revise la información e intente de nuevo!";
        }
    }

    public String eliminarGate(String codigo) throws Exception{
        Gate gateEncontrado = datos.buscarGate(codigo);
        if (gateEncontrado != null){
            try{
                return datos.eliminarGate(codigo);
            } catch (Exception e){
                return "Hubo un error al intentar eliminar, revise la información e intente de nuevo!";
            }
        }
        return "El gate con el código "+codigo+", no existe!";
    }

    public ArrayList<Gate> listarGates() throws Exception{
        return datos.listarGates();
    }
}
