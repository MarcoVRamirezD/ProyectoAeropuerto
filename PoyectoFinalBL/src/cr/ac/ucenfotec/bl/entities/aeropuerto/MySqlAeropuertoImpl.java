package cr.ac.ucenfotec.bl.entities.aeropuerto;

import cr.ac.ucenfotec.dl.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlAeropuertoImpl implements IAeropuertoDAO {
    String sql;
    @Override
    public String registrarAeropuerto(Aeropuerto aeropuerto) throws Exception {
        sql = "INSERT INTO AEROPUERTO (NOMBREAEROPUERTO, CODIGOAEROPUERTO, CODIGOPAIS, IDENTIFICACIONADMINISTRADOR)" +
                "VALUES ('"+aeropuerto.getNombre()+"', '"+aeropuerto.getCodigoAeropuerto()+"', '"+aeropuerto.getCodigoPais()+"', '"+aeropuerto.getIdentificacionAdministrador()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El aeropuerto con el código "+ aeropuerto.getCodigoAeropuerto()+", fue registrado con éxito!";
    }

    @Override
    public String modificarAeropuerto(Aeropuerto aeropuerto) throws Exception {
        sql = "UPDATE AEROPUERTO SET NOMBREAEROPUERTO = '"+aeropuerto.getNombre()+"', CODIGOAEROPUERTO = '"+aeropuerto.getCodigoAeropuerto()+"', CODIGOPAIS = '"+aeropuerto.getCodigoPais()+"', IDENTIFICACIONADMINISTRADOR = '"+aeropuerto.getIdentificacionAdministrador()+"' WHERE CODIGOAEROPUERTO = '"+aeropuerto.getCodigoAeropuerto()+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue modificada con éxito!";
    }

    @Override
    public String eliminarAeropuerto(String codigoAeropuerto) throws Exception {
        sql = "DELETE AEROPUERTO FROM AEROPUERTO WHERE CODIGOAEROPUERTO = '"+codigoAeropuerto+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue eliminada con éxito!";
    }

    @Override
    public ArrayList<Aeropuerto> listarAeropuertos() throws Exception {
        ArrayList<Aeropuerto> listaAeropuertos = new ArrayList<>();
        sql = "SELECT NOMBREAEROPUERTO, CODIGOAEROPUERTO, CODIGOPAIS, IDENTIFICACIONADMINISTRADOR FROM AEROPUERTO";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while (rs.next()){
            Aeropuerto aeropuertoEncontrado = new Aeropuerto(rs.getString("NOMBREAEROPUERTO"),
                                                             rs.getString("CODIGOAEROPUERTO"),
                                                             rs.getString("CODIGOPAIS"),
                                                             rs.getString("IDENTIFICACIONADMINISTRADOR"));
            listaAeropuertos.add(aeropuertoEncontrado);
        }
        return listaAeropuertos;
    }

    @Override
    public Aeropuerto buscarAeropuerto(String codigoAeropuerto) throws Exception {
        sql = "SELECT NOMBREAEROPUERTO, CODIGOAEROPUERTO, CODIGOPAIS, IDENTIFICACIONADMINISTRADOR FROM AEROPUERTO WHERE CODIGOAEROPUERTO = '"+codigoAeropuerto+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if (rs.next()){
            Aeropuerto aeropuertoEncontrado = new Aeropuerto(rs.getString("NOMBREAEROPUERTO"),
                                                             rs.getString("CODIGOAEROPUERTO"),
                                                             rs.getString("CODIGOPAIS"),
                                                             rs.getString("IDENTIFICACIONADMINISTRADOR"));
            return aeropuertoEncontrado;
        }
        return null;
    }
}
