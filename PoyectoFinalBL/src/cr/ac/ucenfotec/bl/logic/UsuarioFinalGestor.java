package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.usuarioFinal.UsuarioFinal;
import cr.ac.ucenfotec.bl.entities.usuarioFinal.IUsuarioFinalDAO;
import cr.ac.ucenfotec.bl.entities.usuarioFinal.MySqlUsuarioFinal;
import cr.ac.ucenfotec.dl.Conector;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UsuarioFinalGestor {
    private IUsuarioFinalDAO datos;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public UsuarioFinalGestor(){
        datos = new MySqlUsuarioFinal();
    }

    public String registrarUsuarioFinal(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion, String nacionalidad,
                                        String fechaNacimiento, String provincia, String canton, String distrito) throws Exception {

        UsuarioFinal usuarioFinalEncontrado = datos.buscarUsuarioFinal(identificacion);

        if(usuarioFinalEncontrado == null){
            try{
                LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);
                Period calcularEdad = Period.between(fecha, LocalDate.now());
                int edad = calcularEdad.getYears();
                UsuarioFinal usuarioFinal = new UsuarioFinal(nombre, apellidos,identificacion,correo, contrasenna,direccion,nacionalidad,fecha,edad,provincia,canton,distrito);
                return datos.registrarUsuarioFinal(usuarioFinal);
            } catch (Exception e){
                return "Hubo un error al intentar registrar, revise la información solicitada e intente de nuevo!";
            }
        }
        return "El usuario con la identificacion "+identificacion+", ya está registrado!";
    }

    public String modificarUsuarioFinal (String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion, String nacionalidad,
                                         String fechaNacimiento, String provincia, String canton, String distrito) throws Exception{

        try{
            LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);
            Period calcularEdad = Period.between(fecha, LocalDate.now());
            int edad = calcularEdad.getYears();
            UsuarioFinal usuarioFinal = new UsuarioFinal(nombre, apellidos,identificacion,correo, contrasenna,direccion,nacionalidad,fecha,edad,provincia,canton,distrito);
            return datos.modificarUsuarioFinal(usuarioFinal);
        } catch (Exception e){
            return "Hubo un error al intentar actualizar, revise la información e intente de nuevo!";
        }
    }

    public ArrayList<UsuarioFinal> listarUsuariosFinales() throws Exception{
        return datos.listarUsuariosFinales();
    }

    public UsuarioFinal validarUsuarioFinal(String correo, String contrasenna) throws Exception{
        UsuarioFinal usuarioFinal = new UsuarioFinal();
        usuarioFinal.setCorreo(correo);
        usuarioFinal.setContrasenna(contrasenna);
        return datos.validarUsuarioFinal(usuarioFinal);
    }
}
