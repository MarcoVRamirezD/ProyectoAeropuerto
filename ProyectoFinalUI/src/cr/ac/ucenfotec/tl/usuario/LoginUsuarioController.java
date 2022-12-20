package cr.ac.ucenfotec.tl.usuario;

import cr.ac.ucenfotec.bl.entities.usuarioFinal.UsuarioFinal;
import cr.ac.ucenfotec.bl.logic.UsuarioFinalGestor;
import cr.ac.ucenfotec.tl.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginUsuarioController implements Initializable{

    private UsuarioFinalGestor gestor = new UsuarioFinalGestor();
    private static UsuarioFinal usuarioFinalSesion;

    public static UsuarioFinal getUsuarioFinalSesion(){
        return usuarioFinalSesion;
    }

    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtContrasenna;


    public void validarDatos(ActionEvent event){
        String correo = txtCorreo.getText();
        String contrasenna = txtContrasenna.getText();
        UsuarioFinal usuarioFinal;
        boolean error = false;

        error = validarCampos(correo, contrasenna);

        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            usuarioFinal = validarUsuarioFinal(correo, contrasenna);
            if (usuarioFinal != null){
                usuarioFinalSesion = usuarioFinal;
                cambiarEscena(event);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "No se ha encontrado el usuario!");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        }

    }

    private boolean validarCampos(String correo, String contrasenna){
        boolean error = false;
        if (correo.equals("")){
            error = true;
        }
        if (contrasenna.equals("")){
            error = true;
        }
        return error;
    }

    private UsuarioFinal validarUsuarioFinal(String correo, String contrasenna){
        try{
            UsuarioFinal usuarioFinal = gestor.validarUsuarioFinal(correo, contrasenna);
            if (usuarioFinal!=null){
                return usuarioFinal;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void cambiarEscena(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/usuario/PerfilUsuario.fxml"));
            Parent parentScene = loader.load();

            Scene newScene = new Scene(parentScene);
            Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al cambiar de ventana. Intente de nuevo: "+ e.getMessage());
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    public void registrarUsuario(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/usuario/RegistroUsuario.fxml"));
            Parent parentScene = loader.load();

            Scene newScene = new Scene(parentScene);
            Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al cambiar de ventana. Intente de nuevo: "+ e.getMessage());
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    public void volver(ActionEvent event) {
        MainController volver = new MainController();
        volver.volver(event);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
