package cr.ac.ucenfotec.bl.entities.vuelo;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlVueloImpl implements IVueloDAO{
    String sql;
    public String registrarVuelo(Vuelo vuelo) throws Exception {
        sql = "INSERT INTO VUELO (CEDULAJURIDICA, AEROPUERTOORIGEN, PAISORIGEN,HORALLEGADA,HORASALIDA,ESTADO,AEROPUERTODESTINO,PAISDESTINO,TIPOVUELO,AVION,GATESALIDA,GATELLEGADA,TRIPULACION) VALUES('"+vuelo.getLineaAerea()+"','"+vuelo.getAeropuertoOrigen()+"','"+vuelo.getPaisOrigen()+"','"+vuelo.getHoraLlegada()+"','"+vuelo.getHoraSalida()+"','"+vuelo.getEstado()+"','"+vuelo.getAeropuertoDestino()+"','"+vuelo.getPaisDestino()+"','"+vuelo.getTipoVuelo()+"','"+vuelo.getAvion()+"','"+vuelo.getGateLlegada()+"','"+vuelo.getGateSalida()+"','"+vuelo.getTripulacion()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El vuelo fue registrado con éxito";
    }

    public String modificarVuelo(Vuelo vuelo) throws Exception {
        sql = "UPDATE VUELO SET CEDULAJURIDICA = '"+vuelo.getLineaAerea()+"', AEROPUERTOORIGEN = '"+vuelo.getAeropuertoOrigen()+"', PAISORIGEN = '"+vuelo.getPaisOrigen()+"',HORALLEGADA = '"+vuelo.getHoraLlegada()+"',HORASALIDA = '"+vuelo.getHoraSalida()+"',ESTADO = '"+vuelo.getEstado()+"',AEROPUERTODESTINO = '"+vuelo.getAeropuertoDestino()+"',PAISDESTINO = '"+vuelo.getPaisDestino()+"',TIPOVUELO = '"+vuelo.getTipoVuelo()+"',AVION = '"+vuelo.getAvion()+"',GATESALIDA = '"+vuelo.getGateSalida()+"',GATELLEGADA = '"+vuelo.getGateLlegada()+"',TRIPULACION = '"+vuelo.getTripulacion()+"' WHERE HORALLEGADA = '"+vuelo.getHoraLlegada()+"' AND HORASALIDA = '"+vuelo.getHoraSalida()+"' AND TRIPULACION = '"+vuelo.getTripulacion()+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue modificada con éxito!";
    }

    public String eliminarVuelo(String horaLlegada, String horaSalida, String tripulacion) throws Exception {
        sql = "DELETE VUELO FROM VUELO WHERE HORALLEGADA = '"+horaLlegada+"'AND HORASALIDA = '"+horaSalida+"' AND TRIPULACION = '"+tripulacion+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue eliminada con éxito!";
    }

    public ArrayList<Vuelo> listarVuelos() throws Exception {
        ArrayList<Vuelo> listaVuelos = new ArrayList<>();
        sql = "SELECT CEDULAJURIDICA, AEROPUERTOORIGEN, PAISORIGEN,HORALLEGADA,HORASALIDA,ESTADO,AEROPUERTODESTINO,PAISDESTINO,TIPOVUELO,AVION,GATESALIDA,GATELLEGADA,TRIPULACION FROM VUELO";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while (rs.next()){
            Vuelo vueloEncontrado = new Vuelo(rs.getString("CEDULAJURIDICA"),
                                              rs.getString("AEROPUERTOORIGEN"),
                                              rs.getString("PAISORIGEN"),
                                              rs.getString("HORALLEGADA"),
                                              rs.getString("HORASALIDA"),
                                              rs.getString("ESTADO"),
                                              rs.getString("AEROPUERTODESTINO"),
                                              rs.getString("PAISDESTINO"),
                                              rs.getString("TIPOVUELO"),
                                              rs.getString("AVION"),
                                              rs.getString("GATESALIDA"),
                                              rs.getString("GATELLEGADA"),
                                              rs.getString("TRIPULACION"));
            listaVuelos.add(vueloEncontrado);
        }
        return listaVuelos;
    }

    public Vuelo buscarVuelo(String horaLlegada, String horaSalida, String tripulacion) throws Exception {
        ArrayList<Vuelo> listaVuelos = new ArrayList<>();
        sql = "SELECT CEDULAJURIDICA, AEROPUERTOORIGEN, PAISORIGEN,HORALLEGADA,HORASALIDA,ESTADO,AEROPUERTODESTINO,PAISDESTINO,TIPOVUELO,AVION,GATESALIDA,GATELLEGADA,TRIPULACION FROM VUELO WHERE HORALLEGADA = '"+horaLlegada+"' AND HORASALIDA = '"+horaSalida+"' AND TRIPULACION = '"+tripulacion+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if (rs.next()){
            Vuelo vueloEncontrado = new Vuelo(rs.getString("CEDULAJURIDICA"),
                                              rs.getString("AEROPUERTOORIGEN"),
                                              rs.getString("PAISORIGEN"),
                                              rs.getString("HORALLEGADA"),
                                              rs.getString("HORASALIDA"),
                                              rs.getString("ESTADO"),
                                              rs.getString("AEROPUERTODESTINO"),
                                              rs.getString("PAISDESTINO"),
                                              rs.getString("TIPOVUELO"),
                                              rs.getString("AVION"),
                                              rs.getString("GATESALIDA"),
                                              rs.getString("GATELLEGADA"),
                                              rs.getString("TRIPULACION"));
            return vueloEncontrado;
        }
        return null;
    }
}
