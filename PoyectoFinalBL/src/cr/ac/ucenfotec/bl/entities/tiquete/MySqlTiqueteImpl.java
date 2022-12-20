package cr.ac.ucenfotec.bl.entities.tiquete;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlTiqueteImpl implements ITiqueteDAO{
    String sql;
    public String registrarTiquete(Tiquete tiquete) throws Exception {
        sql = "INSERT INTO TIQUETE(FECHA, PAISORIGEN, AEROPUERTOORIGEN, PAISDESTINO, AEROPUERTODESTINO, NUMEROASIENTO, PRECIO, NUMEROVUELO, TIPOASIENTO)VALUES('"+tiquete.getFecha()+"','"+tiquete.getAeropuertoOrigen()+"','"+tiquete.getAeropuertoOrigen()+"','"+tiquete.getPaisDestino()+"','"+tiquete.getAeropuertoDestino()+"','"+tiquete.getNumeroAsiento()+"','"+tiquete.getPrecio()+"','"+tiquete.getNumeroVuelo()+"','"+tiquete.getTipoAsiento()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El tiquete fue registrado con éxito!";
    }

    public String modificarTiquete(Tiquete tiquete) throws Exception {
        sql = "UPDATE TIQUETE SET FECHA = '"+tiquete.getFecha()+"', PAISORIGEN = '"+tiquete.getPaisOrigen()+"', AEROPUERTOORIGEN = '"+tiquete.getAeropuertoOrigen()+"', PAISDESTINO = '"+tiquete.getPaisDestino()+"', AEROPUERTODESTINO = '"+tiquete.getAeropuertoDestino()+"', NUMEROASIENTO = '"+tiquete.getNumeroAsiento()+"', PRECIO = '"+tiquete.getPrecio()+"', NUMEROVUELO = '"+tiquete.getNumeroVuelo()+"', TIPOASIENTO = '"+tiquete.getTipoAsiento()+"' WHERE NUMEROASIENTO = '"+tiquete.getNumeroAsiento()+"' AND NUMEROVUELO = '"+tiquete.getNumeroVuelo()+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue modificada con éxito!";
    }

    public String eliminarTiquete(int numeroAsiento, String numeroVuelo) throws Exception {
        sql = "DELETE TIQUETE FROM TIQUETE WHERE NUMEROASIENTO = '"+numeroAsiento+"' AND NUMEROVUELO = '"+numeroVuelo+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue eliminada con éxito!";
    }

    public ArrayList<Tiquete> listarTiquetes() throws Exception {
        ArrayList<Tiquete> listaTiquetes = new ArrayList<>();
        sql = "SELECT FECHA, PAISORIGEN, AEROPUERTOORIGEN, PAISDESTINO, AEROPUERTODESTINO, NUMEROASIENTO, PRECIO, NUMEROVUELO, TIPOASIENTO FROM TIQUETE";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while (rs.next()){
            Tiquete tiqueteEncontrado = new Tiquete(rs.getString("FECHA"),
                                                    rs.getString("PAISORIGEN"),
                                                    rs.getString("AEROPUERTOORIGEN"),
                                                    rs.getString("PAISDESTINO"),
                                                    rs.getString("AEROPUERTODESTINO"),
                                                    rs.getInt("NUMEROASIENTO"),
                                                    rs.getString("PRECIO"),
                                                    rs.getString("NUMEROVUELO"),
                                                    rs.getString("TIPOASIENTO"));
            listaTiquetes.add(tiqueteEncontrado);
        }
        return listaTiquetes;
    }

    public Tiquete buscarTiquete(int numeroAsiento, String numeroVuelo) throws Exception {
        sql = "SELECT FECHA, PAISORIGEN, AEROPUERTOORIGEN, PAISDESTINO, AEROPUERTODESTINO, NUMEROASIENTO, PRECIO, NUMEROVUELO, TIPOASIENTO FROM TIQUETE WHERE NUMEROASIENTO = '"+numeroAsiento+"' AND NUMEROVUELO = '"+numeroVuelo+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if (rs.next()){
            Tiquete tiqueteEncontrado = new Tiquete(rs.getString("FECHA"),
                    rs.getString("PAISORIGEN"),
                    rs.getString("AEROPUERTOORIGEN"),
                    rs.getString("PAISDESTINO"),
                    rs.getString("AEROPUERTODESTINO"),
                    rs.getInt("NUMEROASIENTO"),
                    rs.getString("PRECIO"),
                    rs.getString("NUMEROVUELO"),
                    rs.getString("TIPOASIENTO"));
            return tiqueteEncontrado;
        }
        return null;
    }
}
