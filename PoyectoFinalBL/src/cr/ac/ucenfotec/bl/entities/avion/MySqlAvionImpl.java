package cr.ac.ucenfotec.bl.entities.avion;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlAvionImpl implements IAvionDAO{
    String sql;
    @Override
    public String registrarAvion(Avion avion) throws Exception {
        sql = "INSERT INTO AVION(PLACA, MARCA, MODELO, CAPACIDAD) VALUES('"+avion.getPlaca()+"', '"+avion.getModelo()+"', '"+avion.getMarcaFabricante()+"', "+avion.getCapacidad()+")";
        Conector.getConnector().ejecutarSQL(sql);
        return "El avión con el numero de placa "+avion.getPlaca()+", fue registrado con éxito!";
    }

    @Override
    public String modificarAvion(Avion avion) throws Exception {
        sql = "UPDATE AVION SET PLACA = '"+avion.getPlaca()+"', MARCA = '"+avion.getMarcaFabricante()+"', MODELO = '"+avion.getModelo()+"', CAPACIDAD = "+avion.getCapacidad()+" WHERE PLACA = '"+avion.getPlaca()+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue modificada con éxito!";
    }

    @Override
    public String eliminarAvion(String numeroPlaca) throws Exception {
        sql = "DELETE AVION FROM AVION WHERE PLACA = '"+numeroPlaca+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue eliminada con éxito!";
    }

    @Override
    public ArrayList<Avion> listarAviones() throws Exception {
        ArrayList<Avion> listaAviones = new ArrayList<>();
        sql = "SELECT PLACA, MARCA, MODELO, CAPACIDAD FROM AVION";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while (rs.next()){
            Avion avionEncontrado = new Avion(rs.getString("PLACA"),
                                              rs.getString("MARCA"),
                                              rs.getString("MODELO"),
                                              rs.getInt("CAPACIDAD"));
            listaAviones.add(avionEncontrado);
        }
        return listaAviones;
    }

    @Override
    public Avion buscarAvion(String numeroPlaca) throws Exception {
        sql = "SELECT PLACA, MARCA, MODELO, CAPACIDAD FROM AVION WHERE PLACA = '"+numeroPlaca+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if (rs.next()){
            Avion avionEncontrado = new Avion(rs.getString("PLACA"),
                                              rs.getString("MARCA"),
                                              rs.getString("MODELO"),
                                              rs.getInt("CAPACIDAD"));
            return avionEncontrado;
        }
        return null;
    }
}
