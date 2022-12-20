package cr.ac.ucenfotec.bl.entities.usuarioFinal;


import java.util.ArrayList;

public interface IUsuarioFinalDAO {

    String registrarUsuarioFinal(UsuarioFinal usuarioFinal) throws Exception;
    String modificarUsuarioFinal(UsuarioFinal usuarioFinal) throws Exception;
    ArrayList<UsuarioFinal> listarUsuariosFinales() throws Exception;
    UsuarioFinal buscarUsuarioFinal(String identificacion) throws  Exception;
    UsuarioFinal validarUsuarioFinal(UsuarioFinal usuarioFinal) throws Exception;
}
