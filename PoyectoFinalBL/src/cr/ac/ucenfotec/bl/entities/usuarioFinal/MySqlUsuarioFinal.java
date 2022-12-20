package cr.ac.ucenfotec.bl.entities.usuarioFinal;

import cr.ac.ucenfotec.dl.Conector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

public class MySqlUsuarioFinal implements IUsuarioFinalDAO{
    String sql;
    @Override
    public String registrarUsuarioFinal(UsuarioFinal usuarioFinal) throws Exception{
        sql = "INSERT INTO USUARIOFINAL(NOMBRE, APELLIDOS, IDENTIFICACION, CORREO, CONTRASENNA, DIRECCION, NACIONALIDAD, FECHANACIMIENTO, EDAD, PROVINCIA, CANTON, DISTRITO)\n" +
                "VALUES('"+usuarioFinal.getNombre()+"', '"+usuarioFinal.getApellidos()+"', '"+usuarioFinal.getIdentificacion()+"', '"+usuarioFinal.getCorreo()+
                "', '" +usuarioFinal.getContrasenna()+ "', '"+usuarioFinal.getDireccion()+"', '"+usuarioFinal.getNacionalidad()+"', '"+usuarioFinal.getFechaNacimiento()+
                "', "+usuarioFinal.getEdad()+", '"+usuarioFinal.getProvincia()+"', '"+usuarioFinal.getCanton()+"', '"+usuarioFinal.getDistrito()+"')";

            Conector.getConnector().ejecutarSQL(sql);
            return "El usuario con la identificación "+ usuarioFinal.getIdentificacion()+ ", fue registrado con éxito!";

    }

    @Override
    public String modificarUsuarioFinal(UsuarioFinal usuarioFinal) throws Exception {
        sql = "UPDATE USUARIOFINAL SET NOMBRE = '"+usuarioFinal.getNombre()+"', APELLIDOS = '"+usuarioFinal.getApellidos()+"', IDENTIFICACION = '"+usuarioFinal.getIdentificacion()+
                "', CORREO = '"+usuarioFinal.getCorreo()+"', CONTRASENNA = '"+usuarioFinal.getContrasenna()+"', DIRECCION = '"+usuarioFinal.getDireccion()+
                "', NACIONALIDAD = '"+usuarioFinal.getNacionalidad()+"', FECHANACIMIENTO = '"+usuarioFinal.getFechaNacimiento()+"', EDAD = "+usuarioFinal.getEdad()+
                ", PROVINCIA = '"+usuarioFinal.getProvincia()+"', CANTON = '"+usuarioFinal.getCanton()+"', DISTRITO = '"+usuarioFinal.getDistrito()+
                "' WHERE IDENTIFICACION = '"+usuarioFinal.getIdentificacion()+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue modificada con éxito!\n" +
                "Vuelva a iniciar sesión!";
    }

    @Override
    public ArrayList<UsuarioFinal> listarUsuariosFinales() throws Exception {
        ArrayList<UsuarioFinal> listaUsuariosFinales = new ArrayList<>();
        sql = "SELECT NOMBRE, APELLIDOS, IDENTIFICACION, CORREO, DIRECCION, NACIONALIDAD, FECHANACIMIENTO, EDAD, PROVINCIA, CANTON, DISTRITO\n" +
                "FROM USUARIOFINAL";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        while (rs.next()){
            UsuarioFinal registroUsuarioFinal = new UsuarioFinal(rs.getString("NOMBRE"),
                                                                 rs.getString("APELLIDOS"),
                                                                 rs.getString("IDENTIFICACION"),
                                                                 rs.getString("CORREO"),
                                                                 rs.getString("DIRECCION"),
                                                                 rs.getString("NACIONALIDAD"),
                                                                 rs.getDate("FECHANACIMIENTO", Calendar.getInstance()).toLocalDate(),
                                                                 rs.getInt("EDAD"),
                                                                 rs.getString("PROVINCIA"),
                                                                 rs.getString("CANTON"),
                                                                 rs.getString("DISTRITO"));
            listaUsuariosFinales.add(registroUsuarioFinal);
        }
        return listaUsuariosFinales;
    }

    @Override
    public UsuarioFinal buscarUsuarioFinal(String identificacion) throws Exception {
        sql = "SELECT NOMBRE, APELLIDOS, IDENTIFICACION, CORREO, DIRECCION, NACIONALIDAD, FECHANACIMIENTO, EDAD, PROVINCIA, CANTON, DISTRITO\n" +
                "FROM USUARIOFINAL\n" +
                "WHERE IDENTIFICACION = '"+identificacion+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if (rs.next()){
            UsuarioFinal usuarioFinalEncontrado = new UsuarioFinal(rs.getString("NOMBRE"),
                                                                   rs.getString("APELLIDOS"),
                                                                   rs.getString("IDENTIFICACION"),
                                                                   rs.getString("CORREO"),
                                                                   rs.getString("DIRECCION"),
                                                                   rs.getString("NACIONALIDAD"),
                                                                   rs.getDate("FECHANACIMIENTO", Calendar.getInstance()).toLocalDate(),
                                                                   rs.getInt("EDAD"),
                                                                   rs.getString("PROVINCIA"),
                                                                   rs.getString("CANTON"),
                                                                   rs.getString("DISTRITO"));
            return usuarioFinalEncontrado;
        }
        return null;
    }

    @Override
    public UsuarioFinal validarUsuarioFinal(UsuarioFinal usuarioFinal) throws Exception {
        sql = "SELECT NOMBRE, APELLIDOS, IDENTIFICACION, CORREO, CONTRASENNA, DIRECCION, NACIONALIDAD, FECHANACIMIENTO, EDAD, PROVINCIA, CANTON, DISTRITO\n" +
                "FROM USUARIOFINAL\n" +
                "WHERE CORREO LIKE '"+usuarioFinal.getCorreo()+"' AND CONTRASENNA LIKE '"+usuarioFinal.getContrasenna()+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if (rs.next()){
            UsuarioFinal usuarioFinalEncontrado = new UsuarioFinal(rs.getString("NOMBRE"),
                                                                    rs.getString("APELLIDOS"),
                                                                    rs.getString("IDENTIFICACION"),
                                                                    rs.getString("CORREO"),
                                                                    rs.getString("CONTRASENNA"),
                                                                    rs.getString("DIRECCION"),
                                                                    rs.getString("NACIONALIDAD"),
                                                                    rs.getDate("FECHANACIMIENTO", Calendar.getInstance()).toLocalDate(),
                                                                    rs.getInt("EDAD"),
                                                                    rs.getString("PROVINCIA"),
                                                                    rs.getString("CANTON"),
                                                                    rs.getString("DISTRITO"));
            return usuarioFinalEncontrado;
        }
        return null;
    }
}
