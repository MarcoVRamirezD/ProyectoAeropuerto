package cr.ac.ucenfotec.bl.entities.lineaAerea;


import java.util.ArrayList;

public interface ILineaAereaDAO {
    String registrarLineaAerea(LineaAerea lineaAerea) throws Exception;
    String modificarLineaAerea(LineaAerea lineaAerea) throws Exception;
    String elminarLineaAerea(String cedulaJuridica)throws Exception;
    ArrayList<LineaAerea> listarLineasAereas()throws Exception;
    LineaAerea buscarLineaAerea(String cedulaJuridica)throws Exception;
}
