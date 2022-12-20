package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.administrador.IAdministradorDAO;
import cr.ac.ucenfotec.bl.entities.administrador.MySqlAdministradorImpl;
import cr.ac.ucenfotec.bl.entities.administrador.Administrador;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AdministradorGestor {
    private IAdministradorDAO datos;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public AdministradorGestor(){
        datos = new MySqlAdministradorImpl();
    }

    public String registrarAdministrador(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion, String nacionalidad,
                                         String fechaNacimiento, String genero) throws Exception{
        Administrador administradorEncontrado = datos.buscarAdministrador(identificacion);
        if(administradorEncontrado == null){
            try{
                LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);
                Period calcularEdad = Period.between(fecha, LocalDate.now());
                int edad = calcularEdad.getYears();
                Administrador administrador = new Administrador(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad, fecha, edad, genero);
                return datos.registrarAdministrador(administrador);
            } catch (Exception e){
                return "Hubo un error al intentar registrar, revise la información solicitada e intente de nuevo!";
            }
        }
        return "El Administrador con la identificación "+ identificacion +", ya está registrado!";
    }

    public String modificarAdministrador(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion, String nacionalidad,
                                         String fechaNacimiento, String genero) throws Exception{
        try{
            LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);
            Period calcularEdad = Period.between(fecha, LocalDate.now());
            int edad = calcularEdad.getYears();
            Administrador administrador = new Administrador(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad, fecha, edad, genero);
            return datos.modificarAdministrador(administrador);
        } catch (Exception e){
            return "Hubo un error al intentar actualizar, revise la información e intente de nuevo!";
        }
    }

    public Administrador validarAdministrador(String correo, String contrasenna) throws Exception{
        Administrador administrador = new Administrador();
        administrador.setCorreo(correo);
        administrador.setContrasenna(contrasenna);
        return datos.validarAdministrador(administrador);
    }
}
