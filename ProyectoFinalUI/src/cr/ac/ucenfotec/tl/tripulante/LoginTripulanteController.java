package cr.ac.ucenfotec.tl.tripulante;

import cr.ac.ucenfotec.bl.entities.miembroTripulacion.MiembroTripulacion;
import cr.ac.ucenfotec.bl.logic.MiembroTripulacionGestor;
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

public class LoginTripulanteController implements Initializable {

    private MiembroTripulacionGestor gestor = new MiembroTripulacionGestor();
    private static MiembroTripulacion miembroTripulacionSesion;

    public static MiembroTripulacion getMiembroTripulacionSesion(){
        return miembroTripulacionSesion;
    }

    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtContrasenna;
    public void validarDatos(ActionEvent event){
        String correo = txtCorreo.getText();
        String contrasenna = txtContrasenna.getText();
        MiembroTripulacion miembroTripulacion;
        boolean error = false;

        error = validarCampos(correo, contrasenna);

        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            miembroTripulacion = validarMiembroTripulacion(correo, contrasenna);
            if (miembroTripulacion != null){
                miembroTripulacionSesion = miembroTripulacion;
                cambiarEscena(event);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No se ha encontrado el tripulante!");
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

    private MiembroTripulacion validarMiembroTripulacion(String correo, String contrasenna){
        try{
            MiembroTripulacion miembroTripulacion = gestor.validarTripulante(correo, contrasenna);
            if (miembroTripulacion != null){
                return miembroTripulacion;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void cambiarEscena(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/tripulante/PerfilTripulante.fxml"));
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

    public void registrarTripulante(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/tripulante/RegistroTripulante.fxml"));
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
