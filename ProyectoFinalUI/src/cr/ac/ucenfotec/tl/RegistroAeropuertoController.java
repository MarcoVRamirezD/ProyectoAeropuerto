package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.AeropuertoGestor;
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

public class RegistroAeropuertoController implements Initializable{

    private AeropuertoGestor gestor = new AeropuertoGestor();
    private String mensaje;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCodigoAeropuerto;
    @FXML
    private TextField txtCodigoPais;
    @FXML
    private TextField txtIdentificacionAdmin;

    public void registrarAeropuerto(ActionEvent event) throws Exception{
        String nombre = txtNombre.getText();
        String codigoA = txtCodigoAeropuerto.getText();
        String codigoP = txtCodigoPais.getText();
        String identificacionAdmin = txtIdentificacionAdmin.getText();
        boolean error = false;

        error = validarCAmpos(nombre, codigoA,codigoP);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            mensaje = gestor.registrarAeropuerto(nombre,codigoA,codigoP,identificacionAdmin);
            txtNombre.clear();
            txtCodigoAeropuerto.clear();
            txtCodigoPais.clear();
            txtIdentificacionAdmin.clear();
            mostrarMensaje(mensaje);
        }
    }

    private boolean validarCAmpos(String nombre, String codigoA, String codigoP){
        boolean error = false;
        if (nombre.equals("")){
            error = true;
        }
        if (codigoA.equals("")){
            error = true;
        }
        if (codigoP.equals("")){
            error = true;
        }
        return error;
    }

    public void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }


    public void volver(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/LoginAdministrador.fxml"));
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
