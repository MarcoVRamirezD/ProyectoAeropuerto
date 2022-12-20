package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.entities.lineaAerea.ILineaAereaDAO;
import cr.ac.ucenfotec.bl.entities.lineaAerea.MySqlLineaAereaImpl;

import java.util.ArrayList;

public class LineaAereaGestor {
    private ILineaAereaDAO datos;
    public LineaAereaGestor(){
        datos = new MySqlLineaAereaImpl();
    }

    public String registrarLineaAerea(String nombreComercial, String cedulaJuridica, String nombreEmpresaDuenna, String codigoPais) throws Exception {
        LineaAerea lineaAereaEncontrada = datos.buscarLineaAerea(cedulaJuridica);
        if (lineaAereaEncontrada == null){
            try {
                LineaAerea lineaAerea = new LineaAerea(nombreComercial, cedulaJuridica, nombreEmpresaDuenna, codigoPais);
                return datos.registrarLineaAerea(lineaAerea);
            } catch (Exception e){
                return "Hubo un error al intentar registrar, revise la información solicitada e intente de nuevo!";
            }
        }
        return "La linea aérea con la cédula jurídica "+cedulaJuridica+", ya está registrada!";
    }

    public String modificarLineaAerea(String nombreComercial, String cedulaJuridica, String nombreEmpresaDuenna, String codigoPais) throws Exception {
        try {
            LineaAerea lineaAerea = new LineaAerea(nombreComercial, cedulaJuridica, nombreEmpresaDuenna, codigoPais);
            return datos.modificarLineaAerea(lineaAerea);
        } catch (Exception e){
            return "Hubo un error al intentar registrar, revise la información solicitada e intente de nuevo!";
        }
    }

    public String elminarLineaAerea(String cedulaJuridica) throws Exception {
        LineaAerea lineaAereaEncontrada = datos.buscarLineaAerea(cedulaJuridica);
        if (lineaAereaEncontrada != null){
            try {
                return datos.elminarLineaAerea(cedulaJuridica);
            }catch (Exception e){
                return "Hubo un error al intentar eliminar, revise la información e intente de nuevo!";
            }
        }
        return "La linea aérea con la cédula jurídica "+cedulaJuridica+", no existe!";
    }

    public ArrayList<LineaAerea> listarLineasAereas() throws Exception {
        return datos.listarLineasAereas();
    }
}
