package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.avion.Avion;
import cr.ac.ucenfotec.bl.entities.avion.IAvionDAO;
import cr.ac.ucenfotec.bl.entities.avion.MySqlAvionImpl;

import java.util.ArrayList;

public class AvionGestor {
    private IAvionDAO datos;
    public AvionGestor(){
        datos = new MySqlAvionImpl();
    }

    public String registrarAvion(String placa, String marca, String modelo, String txtcapacidad) throws Exception{
        Avion avionEncontrado = datos.buscarAvion(placa);
        if (avionEncontrado == null){
            try{
                int capacidad = Integer.parseInt(txtcapacidad);
                Avion avion = new Avion(placa, marca, modelo, capacidad);
                return datos.registrarAvion(avion);
            } catch (Exception e){
                return "Hubo un error al intentar registrar, revise la información solicitada e intente de nuevo!";
            }
        }
        return "El avión con la placa "+placa+", ya está registrado!";
    }

    public String modificarAvion(String placa, String marca, String modelo, String txtcapacidad)throws Exception{
        try{
            int capacidad = Integer.parseInt(txtcapacidad);
            Avion avion = new Avion(placa, marca, modelo, capacidad);
            return datos.modificarAvion(avion);
        } catch (Exception e){
            return "Hubo un error al intentar actualizar, revise la información e intente de nuevo!";
        }
    }

    public String eliminarAvion(String placa) throws Exception{
        Avion avionEncontrado = datos.buscarAvion(placa);
        if (avionEncontrado != null){
            try{
                return datos.eliminarAvion(placa);
            } catch (Exception e){
                return "Hubo un error al intentar eliminar, revise la información e intente de nuevo!";
            }
        }
        return "El avión con la placa "+placa+", no existe!";
    }

    public ArrayList<Avion> listarAviones() throws Exception{
        return datos.listarAviones();
    }
}
