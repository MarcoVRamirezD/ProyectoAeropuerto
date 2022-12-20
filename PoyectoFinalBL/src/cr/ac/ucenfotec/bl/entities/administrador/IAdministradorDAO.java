package cr.ac.ucenfotec.bl.entities.administrador;

import java.util.ArrayList;

public interface IAdministradorDAO {
    String registrarAdministrador(Administrador administrador) throws Exception;
    String modificarAdministrador(Administrador administrador) throws Exception;
    ArrayList<Administrador> listarAdministradores() throws Exception;
    Administrador buscarAdministrador(String identificacion) throws Exception;
    Administrador validarAdministrador(Administrador administrador) throws Exception;
}
