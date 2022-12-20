package cr.ac.ucenfotec.bl.entities.gate;

import cr.ac.ucenfotec.bl.entities.administrador.Administrador;
import cr.ac.ucenfotec.dl.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlGateImpl implements IGateDAO{

    private String sql;

    @Override
    public String registrarGate(Gate gate) throws Exception {
        sql = "INSERT INTO GATE(NOMBRE, CODIGO, UBICACION)\n" +
                "VALUES('"+gate.getNombre()+"',"+gate.getCodigo()+", '"+gate.getUbicacion()+"')";
        Conector.getConnector().ejecutarSQL(sql);

        return "El gate con el código "+ gate.getCodigo() +", fue registrado con éxito!";
    }

    @Override
    public String modificarGate(Gate gate) throws Exception {
        sql = "UPDATE GATE SET NOMBRE = '"+gate.getNombre()+"', CODIGO = '"+gate.getCodigo()+"', UBICACION = '"+gate.getUbicacion()+"' WHERE CODIGO = '"+gate.getCodigo()+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue modificada con éxito!";
    }

    @Override
    public String eliminarGate(String codigo) throws Exception {
        sql = "DELETE GATE FROM GATE WHERE CODIGO = '"+codigo+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue eliminada con éxito!";
    }


    @Override
    public ArrayList<Gate> listarGates() throws Exception {
        ArrayList<Gate> listaGates = new ArrayList<>();
        sql = "SELECT NOMBRE, CODIGO, UBICACION FROM GATE";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while (rs.next()){
            Gate registroGate = new Gate(rs.getString("NOMBRE"),
                                         rs.getString("CODIGO"),
                                         rs.getString("UBICACION"));
            listaGates.add(registroGate);
        }
        return listaGates;
    }

    @Override
    public Gate buscarGate(String codigo) throws Exception {
        sql = "SELECT NOMBRE, CODIGO, UBICACION\n" +
                "FROM GATE WHERE CODIGO = "+codigo+"";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        if (rs.next()){
            Gate gateEncontrado = new Gate(rs.getString("NOMBRE"),
                                            rs.getString("CODIGO"),
                                            rs.getString("UBICACION"));
            return gateEncontrado;
        }
        return null;
    }
}
