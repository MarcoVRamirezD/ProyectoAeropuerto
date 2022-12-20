package cr.ac.ucenfotec.bl.entities.pais;

import java.util.ArrayList;

public interface IPaisDAO {
    String registrarPais(Pais pais) throws Exception;
    String modificarPais(Pais pais)throws  Exception;
    String eliminarPais(String abreviatura) throws Exception;
    ArrayList<Pais> listarPaises()throws Exception;
    Pais buscarPaises(String abreviatura)throws Exception;
}
