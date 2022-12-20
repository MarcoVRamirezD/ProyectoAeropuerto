package cr.ac.ucenfotec.bl.entities.administrador;

import cr.ac.ucenfotec.bl.logic.AdministradorGestor;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

public class MySqlAdministradorImpl implements IAdministradorDAO{

    private String sql;

    @Override
    public String registrarAdministrador(Administrador administrador) throws Exception {
        sql = "INSERT INTO ADMINISTRADOR(NOMBRE, APELLIDOS, IDENTIFICACION, CORREO, CONTRASENNA, DIRECCION, NACIONALIDAD, FECHANACIMIENTO, EDAD, GENERO) \n" +
                "VALUES ('"+administrador.getNombre()+"', '"+administrador.getApellidos()+"', '"+administrador.getIdentificacion()+"', " +
                "'"+administrador.getCorreo()+"', '"+administrador.getContrasenna()+"', '"+administrador.getDireccion()+
                "', '"+administrador.getNacionalidad()+"', " + "'"+administrador.getFechaNacimiento()+"', "+administrador.getEdad()+", '"+administrador.getGenero()+"')";

        Conector.getConnector().ejecutarSQL(sql);

        return "El administrador con la identificación " + administrador.getIdentificacion() + ", fue registrado con éxito!";
    }

    @Override
    public String modificarAdministrador(Administrador administrador) throws Exception {
        sql = "UPDATE ADMINISTRADOR SET NOMBRE = '"+administrador.getNombre()+"', APELLIDOS = '"+administrador.getApellidos()+"', IDENTIFICACION = '"+administrador.getIdentificacion()+"'," +
                " CORREO = '"+administrador.getCorreo()+"', CONTRASENNA = '"+administrador.getContrasenna()+"', DIRECCION = '"+administrador.getDireccion()+"', " +
                "NACIONALIDAD = '"+administrador.getNacionalidad()+"', FECHANACIMIENTO = '"+administrador.getFechaNacimiento()+"', EDAD = "+administrador.getEdad()+", " +
                "GENERO = '"+administrador.getGenero()+"' " +
                "WHERE IDENTIFICACION = '"+administrador.getIdentificacion()+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue modificada con éxito!\n" +
                "Vuelva a iniciar sesión!";
    }

    @Override
    public ArrayList<Administrador> listarAdministradores() throws Exception {
        ArrayList<Administrador> listaAdministradores = new ArrayList<>();

        sql = "SELECT NOMBRE, APELLIDOS, IDENTIFICACION, CORREO, CONTRASENNA, DIRECCION, NACIONALIDAD, " +
                "FECHANACIMIENTO, EDAD, GENERO FROM ADMINISTRADOR";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

        while(rs.next()){
            Administrador registroAdmin = new Administrador(rs.getString("NOMBRE"),
                                                            rs.getString("APELLIDOS"),
                                                            rs.getString("IDENTIFICACION"),
                                                            rs.getString("CORREO"),
                                                            rs.getString("CONTRASENNA"),
                                                            rs.getString("DIRECCION"),
                                                            rs.getString("NACIONALIDAD"),
                                                            rs.getDate("FECHANACIMIENTO", Calendar.getInstance()).toLocalDate(),
                                                            rs.getInt("EDAD"),
                                                            rs.getString("GENERO"));
            listaAdministradores.add(registroAdmin);
        }

        return listaAdministradores;
    }

    public Administrador buscarAdministrador(String identificacion) throws Exception{
        sql = "SELECT NOMBRE, APELLIDOS, IDENTIFICACION, CORREO, CONTRASENNA, DIRECCION, NACIONALIDAD, FECHANACIMIENTO, EDAD, GENERO \n" +
                "FROM ADMINISTRADOR\n" +
                "WHERE IDENTIFICACION = '"+identificacion+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if(rs.next()){
            Administrador administradorEncontrado = new Administrador(rs.getString("NOMBRE"),
                                                                      rs.getString("APELLIDOS"),
                                                                      rs.getString("IDENTIFICACION"),
                                                                      rs.getString("CORREO"),
                                                                      rs.getString("CONTRASENNA"),
                                                                      rs.getString("DIRECCION"),
                                                                      rs.getString("NACIONALIDAD"),
                                                                      rs.getDate("FECHANACIMIENTO", Calendar.getInstance()).toLocalDate(),
                                                                      rs.getInt("EDAD"),
                                                                      rs.getString("GENERO"));
            return administradorEncontrado;
        }
        return null;
    }

    @Override
    public Administrador validarAdministrador(Administrador administrador) throws Exception {
        sql = "SELECT NOMBRE, APELLIDOS, IDENTIFICACION, CORREO, CONTRASENNA, DIRECCION, NACIONALIDAD, FECHANACIMIENTO, EDAD, GENERO FROM ADMINISTRADOR WHERE CORREO LIKE '"+administrador.getCorreo()+"' AND CONTRASENNA LIKE '"+administrador.getContrasenna()+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if(rs.next()){
            Administrador administradorEncontrado = new Administrador(rs.getString("NOMBRE"),
                                                                      rs.getString("APELLIDOS"),
                                                                      rs.getString("IDENTIFICACION"),
                                                                      rs.getString("CORREO"),
                                                                      rs.getString("CONTRASENNA"),
                                                                      rs.getString("DIRECCION"),
                                                                      rs.getString("NACIONALIDAD"),
                                                                      rs.getDate("FECHANACIMIENTO", Calendar.getInstance()).toLocalDate(),
                                                                      rs.getInt("EDAD"),
                                                                      rs.getString("GENERO"));
            return administradorEncontrado;
        }
        return null;
    }
}
