package cr.ac.ucenfotec.bl.entities.miembroTripulacion;

import cr.ac.ucenfotec.dl.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlMiembroTripulacionImpl implements IMiembroTripulacionDAO {
    String sql;
    @Override
    public String registrarMiembroTripulacion(MiembroTripulacion miembroTripulacion) throws Exception {
        sql = "INSERT INTO TRIPULANTE (NOMBRE, APELLIDOS, IDENTIFICACION, CORREO, CONTRASENNA, DIRECCION, NACIONALIDAD, GENERO, ANNOSEXPERIENCIA, " +
                "FECHAGRADUACION, NUMEROLICENCIA, PUESTO, TELEFONO)" +
                "VALUES ('"+miembroTripulacion.getNombre()+"', '"+miembroTripulacion.getApellidos()+"', '"+miembroTripulacion.getIdentificacion()+"', " +
                "'"+miembroTripulacion.getCorreo()+"', '"+miembroTripulacion.getContrasenna()+"', '"+miembroTripulacion.getDireccion()+"', " +
                "'"+miembroTripulacion.getNacionalidad()+"', '"+miembroTripulacion.getGenero()+"', "+miembroTripulacion.getAnnosExperiencia()+", " +
                "'"+miembroTripulacion.getFechaGraduacion()+"', '"+miembroTripulacion.getNumeroLicencia()+"', '"+miembroTripulacion.getPuesto()+"', " +
                "'"+miembroTripulacion.getTelefono()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El miembro de la tripulacion con la licencia "+miembroTripulacion.getNumeroLicencia()+", fue registrado con éxito!";
    }

    @Override
    public String modificarMiembroTripulacion(MiembroTripulacion miembroTripulacion) throws Exception {
        sql = "UPDATE TRIPULANTE SET NOMBRE = '"+miembroTripulacion.getNombre()+"', APELLIDOS = '"+miembroTripulacion.getApellidos()+"', " +
                "IDENTIFICACION = '"+miembroTripulacion.getIdentificacion()+"', CORREO = '"+miembroTripulacion.getCorreo()+"', " +
                "CONTRASENNA = '"+miembroTripulacion.getContrasenna()+"', DIRECCION = '"+miembroTripulacion.getDireccion()+"', " +
                "NACIONALIDAD = '"+miembroTripulacion.getNacionalidad()+"', GENERO = '"+miembroTripulacion.getGenero()+"', " +
                "ANNOSEXPERIENCIA = "+miembroTripulacion.getAnnosExperiencia()+", FECHAGRADUACION = '"+miembroTripulacion.getFechaGraduacion()+"', " +
                "NUMEROLICENCIA = '"+miembroTripulacion.getNumeroLicencia()+"', PUESTO = '"+miembroTripulacion.getPuesto()+"', " +
                "TELEFONO = '"+miembroTripulacion.getTelefono()+"' WHERE NUMEROLICENCIA = '"+miembroTripulacion.getNumeroLicencia()+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return "La información fue modificada con éxito!\n" +
                "Vuelva a iniciar sesión!";
    }

    @Override
    public ArrayList<MiembroTripulacion> listarMiembrosTripulacion() throws Exception {
        return null;
    }

    @Override
    public MiembroTripulacion buscarMiembroTripulacion(String numeroLicencia) throws Exception {
        sql = "SELECT NOMBRE, APELLIDOS, IDENTIFICACION, CORREO, CONTRASENNA, DIRECCION, NACIONALIDAD, GENERO, ANNOSEXPERIENCIA, FECHAGRADUACION, " +
                "NUMEROLICENCIA, PUESTO, TELEFONO FROM TRIPULANTE WHERE NUMEROLICENCIA = '"+numeroLicencia+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if(rs.next()){
            MiembroTripulacion miembroTripulacionEncontrado = new MiembroTripulacion(rs.getString("NOMBRE"),
                                                                                     rs.getString("APELLIDOS"),
                                                                                     rs.getString("IDENTIFICACION"),
                                                                                     rs.getString("CORREO"),
                                                                                     rs.getString("CONTRASENNA"),
                                                                                     rs.getString("DIRECCION"),
                                                                                     rs.getString("NACIONALIDAD"),
                                                                                     rs.getString("GENERO"),
                                                                                     rs.getInt("ANNOSEXPERIENCIA"),
                                                                                     rs.getString("FECHAGRADUACION"),
                                                                                     rs.getString("NUMEROLICENCIA"),
                                                                                     rs.getString("PUESTO"),
                                                                                     rs.getString("TELEFONO"));
            return miembroTripulacionEncontrado;
        }
        return null;
    }

    @Override
    public MiembroTripulacion validarMiembroTripulacion(MiembroTripulacion miembroTripulacion) throws Exception {
        sql = "SELECT NOMBRE, APELLIDOS, IDENTIFICACION, CORREO, CONTRASENNA, DIRECCION, NACIONALIDAD, GENERO, ANNOSEXPERIENCIA, FECHAGRADUACION, " +
                "NUMEROLICENCIA, PUESTO, TELEFONO FROM TRIPULANTE " +
                "WHERE CORREO LIKE '"+miembroTripulacion.getCorreo()+"' AND CONTRASENNA LIKE '"+miembroTripulacion.getContrasenna()+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
        if(rs.next()){
            MiembroTripulacion miembroTripulacionEncontrado = new MiembroTripulacion(rs.getString("NOMBRE"),
                                                                                     rs.getString("APELLIDOS"),
                                                                                     rs.getString("IDENTIFICACION"),
                                                                                     rs.getString("CORREO"),
                                                                                     rs.getString("CONTRASENNA"),
                                                                                     rs.getString("DIRECCION"),
                                                                                     rs.getString("NACIONALIDAD"),
                                                                                     rs.getString("GENERO"),
                                                                                     rs.getInt("ANNOSEXPERIENCIA"),
                                                                                     rs.getString("FECHAGRADUACION"),
                                                                                     rs.getString("NUMEROLICENCIA"),
                                                                                     rs.getString("PUESTO"),
                                                                                     rs.getString("TELEFONO"));
            return miembroTripulacionEncontrado;
        }
        return null;
    }
}
