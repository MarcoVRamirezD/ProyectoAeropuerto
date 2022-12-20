package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.miembroTripulacion.MiembroTripulacion;
import cr.ac.ucenfotec.bl.entities.miembroTripulacion.IMiembroTripulacionDAO;
import cr.ac.ucenfotec.bl.entities.miembroTripulacion.MySqlMiembroTripulacionImpl;

import java.util.ArrayList;

public class MiembroTripulacionGestor {
    private IMiembroTripulacionDAO datos;
    public MiembroTripulacionGestor(){
        datos = new MySqlMiembroTripulacionImpl();
    }
    public String registrarMiembroTripulacion(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion,
                                              String nacionalidad, String genero, String annosExperiencia, String fechaGraduacion, String numeroLicencia,
                                              String puesto, String telefono) throws Exception{
        MiembroTripulacion miembroTripulacionEncontrado = datos.buscarMiembroTripulacion(numeroLicencia);
        if(miembroTripulacionEncontrado == null){
            try{
                int experiencia = Integer.parseInt(annosExperiencia);
                MiembroTripulacion miembroTripulacion = new MiembroTripulacion(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad,
                        genero, experiencia, fechaGraduacion, numeroLicencia, puesto, telefono);
                return datos.registrarMiembroTripulacion(miembroTripulacion);
            } catch (Exception e){
                return "Hubo un error al intentar registrar, revise la información solicitada e intente de nuevo!";
            }
        }
        return "El tripulante con la licencia "+ numeroLicencia +", ya está registrado!";
    }

    public String modificarMiembroTripulacion(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion,
                                              String nacionalidad, String genero, String annosExperiencia, String fechaGraduacion, String numeroLicencia,
                                              String puesto, String telefono){
        try{
            int experiencia = Integer.parseInt(annosExperiencia);
            MiembroTripulacion miembroTripulacion = new MiembroTripulacion(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad,
                    genero, experiencia, fechaGraduacion, numeroLicencia, puesto, telefono);
            return datos.modificarMiembroTripulacion(miembroTripulacion);
        } catch (Exception e){
            return "Hubo un error al intentar actualizar, revise la información e intente de nuevo!";
        }

    }

    public MiembroTripulacion validarTripulante(String correo, String contrasenna) throws Exception{
        MiembroTripulacion miembroTripulacion = new MiembroTripulacion();
        miembroTripulacion.setCorreo(correo);
        miembroTripulacion.setContrasenna(contrasenna);
        return datos.validarMiembroTripulacion(miembroTripulacion);
    }
}
