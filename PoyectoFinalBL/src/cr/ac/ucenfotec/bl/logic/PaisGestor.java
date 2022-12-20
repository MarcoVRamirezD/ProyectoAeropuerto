package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.pais.Pais;
import cr.ac.ucenfotec.bl.entities.pais.IPaisDAO;
import cr.ac.ucenfotec.bl.entities.pais.MySqlPaisImpl;

import java.util.ArrayList;

public class PaisGestor {
    private IPaisDAO datos;
    public PaisGestor(){
        datos = new MySqlPaisImpl();
    }
    public String registrarPais(String nombre, String abreviatura) throws Exception {
        Pais paiseEncontrado = datos.buscarPaises(abreviatura);
        if (paiseEncontrado == null){
            Pais pais = new Pais(nombre, abreviatura);
            return datos.registrarPais(pais);
        }
        return "El pais con la abreviatura "+abreviatura+", ya está registrado!";
    }

    public String modificarPais(String nombre, String abreviatura) throws Exception {
        try {
            Pais pais = new Pais(nombre, abreviatura);
            return datos.modificarPais(pais);
        } catch (Exception e){
            return "Hubo un error al intentar actualizar, revise la información e intente de nuevo!";
        }

    }

    public String eliminarPais(String abreviatura) throws Exception {
        Pais paisEncontrado = datos.buscarPaises(abreviatura);
        if (paisEncontrado != null){
            try {
                return datos.eliminarPais(abreviatura);
            } catch (Exception e){
                return "Hubo un error al intentar eliminar, revise la información e intente de nuevo!";
            }
        }
        return "El pais con la abreviatura "+abreviatura+", no existe!";
    }

    public ArrayList<Pais> listarPaises() throws Exception {
        return datos.listarPaises();
    }
}
