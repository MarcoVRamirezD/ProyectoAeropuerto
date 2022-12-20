package cr.ac.ucenfotec.bl.entities.pais;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlPaisImpl implements IPaisDAO{
    String sql;
    public String registrarPais(Pais pais) throws Exception {
        sql = "INSERT INTO PAIS(NOMBRE, ABREVIATURA) VALUES('"+pais.getNombre()+"','"+pais.getAbreviatura()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El pais con la abreviatura "+ pais.getAbreviatura() +", fue registrado con éxito!";
    }

    public String modificarPais(Pais pais) throws Exception {
        sql = "UPDATE PAIS SET NOMBRE = '"+pais.getNombre()+"', ABREVIATURA = '"+pais.getAbreviatura()+"' WHERE ABREVIATURA = '"+pais.getAbreviatura()+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue modificada con éxito!";
    }

    public String eliminarPais(String abreviatura) throws Exception {
        sql = "DELETE PAIS FROM PAIS WHERE ABREVIATURA = '"+abreviatura+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue eliminada con éxito!";
    }

    public ArrayList<Pais> listarPaises() throws Exception {
        ArrayList<Pais> listaPaises = new ArrayList<>();
        sql = "SELECT NOMBRE, ABREVIATURA FROM PAIS";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while(rs.next()){
            Pais paisEncontrado = new Pais(rs.getString("NOMBRE"),
                                           rs.getString("ABREVIATURA"));
            listaPaises.add(paisEncontrado);
        }
        return listaPaises;
    }

    public Pais buscarPaises(String abreviatura) throws Exception {
        sql = "SELECT NOMBRE, ABREVIATURA FROM PAIS WHERE ABREVIATURA = '"+abreviatura+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if (rs.next()){
            Pais paisEncontrado = new Pais(rs.getString("NOMBRE"),
                                           rs.getString("ABREVIATURA"));
            return paisEncontrado;
        }
        return null;
    }
}
