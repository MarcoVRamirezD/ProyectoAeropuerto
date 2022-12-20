package cr.ac.ucenfotec.tl.administrador;

import cr.ac.ucenfotec.bl.entities.administrador.Administrador;
import cr.ac.ucenfotec.bl.logic.AdministradorGestor;
import cr.ac.ucenfotec.tl.MainController;
import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginAdministradorController implements Initializable {

    private AdministradorGestor gestor = new AdministradorGestor();
    private static Administrador administradorSesion;

    public static Administrador getAdministradorSesion(){
        return administradorSesion;
    }

    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtContrasenna;
    public void validarDatos(ActionEvent event){
        String correo = txtCorreo.getText();
        String contrasenna = txtContrasenna.getText();
        Administrador administrador;
        boolean error = false;

        error = validarCampos(correo, contrasenna);

        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            administrador = validarAdministrador(correo, contrasenna);
            if (administrador != null){
                administradorSesion = administrador;
                cambiarEscena(event);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No se ha encontrado el administrador!");
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

    private Administrador validarAdministrador(String correo, String contrasenna){
        try{
            Administrador administrador = gestor.validarAdministrador(correo,contrasenna);
            if (administrador != null){
                return administrador;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void cambiarEscena(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/MenuAdministrador.fxml"));
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

    public void registrarAeropuerto(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/RegistroAeropuerto.fxml"));
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

    public void registrarAdministrador(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/RegistroAdministrador.fxml"));
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
