package cr.ac.ucenfotec.bl.entities.lineaAerea;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlLineaAereaImpl implements ILineaAereaDAO{
    String sql;

    public String registrarLineaAerea(LineaAerea lineaAerea) throws Exception {
        sql = "INSERT INTO LINEAAEREA(NOMBRECOMERCIAL, CEDULAJURIDICA, NOMBREEMPRESADUENNA, CODIGOPAIS) VALUES ('"+lineaAerea.getNombreComercial()+"','"+lineaAerea.getCedulaJuridica()+"','"+lineaAerea.getNombreEmpresaDuenna()+"','"+lineaAerea.getCodigoPais()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "La linea aérea con la cédula jurídica "+lineaAerea.getCedulaJuridica()+", fue registrada con éxito!";
    }

    public String modificarLineaAerea(LineaAerea lineaAerea) throws Exception {
        sql = "UPDATE LINEAAEREA SET NOMBRECOMERCIAL = '"+lineaAerea.getNombreComercial()+"', CEDULAJURIDICA = '"+lineaAerea.getCedulaJuridica()+"', NOMBREEMPRESADUENNA = '"+lineaAerea.getNombreEmpresaDuenna()+"', CODIGOPAIS = '"+lineaAerea.getCodigoPais()+"' WHERE CEDULAJURIDICA = '"+lineaAerea.getCedulaJuridica()+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue modificada con éxito!";
    }

    public String elminarLineaAerea(String cedulaJuridica) throws Exception {
        sql = "DELETE LINEAAEREA FROM LINEAAEREA WHERE CEDULAJURIDICA = '"+cedulaJuridica+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue eliminada con éxito!";
    }

    public ArrayList<LineaAerea> listarLineasAereas() throws Exception {
        ArrayList<LineaAerea> listaLineaAereas = new ArrayList<>();
        sql = "SELECT NOMBRECOMERCIAL, CEDULAJURIDICA, NOMBREEMPRESADUENNA, CODIGOPAIS FROM LINEAAEREA";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while (rs.next()){
            LineaAerea lineaAereaEncontrada = new LineaAerea(rs.getString("NOMBRECOMERCIAL"),
                                                   rs.getString("CEDULAJURIDICA"),
                                                   rs.getString("NOMBREEMPRESADUENNA"),
                                                   rs.getString("CODIGOPAIS"));
            listaLineaAereas.add(lineaAereaEncontrada);
        }
        return listaLineaAereas;
    }

    public LineaAerea buscarLineaAerea(String cedulaJuridica) throws Exception {
        sql = "SELECT NOMBRECOMERCIAL, CEDULAJURIDICA, NOMBREEMPRESADUENNA, CODIGOPAIS FROM LINEAAEREA WHERE CEDULAJURIDICA = '"+cedulaJuridica+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if (rs.next()){
            LineaAerea lineaAereaEncontrada = new LineaAerea(rs.getString("NOMBRECOMERCIAL"),
                                                             rs.getString("CEDULAJURIDICA"),
                                                             rs.getString("NOMBREEMPRESADUENNA"),
                                                             rs.getString("CODIGOPAIS"));
            return lineaAereaEncontrada;
        }
        return null;
    }
}
