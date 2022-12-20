package cr.ac.ucenfotec.tl.administrador;

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

public class MenuAdministradorController implements Initializable {

    public void gestionAeropuertos(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/Aeropuerto.fxml"));
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

    public void gestionAviones(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/Avion.fxml"));
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

    public void gestionGates(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/Gates.fxml"));
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
    public void gestionLineasAereas(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/LineaAerea.fxml"));
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
    public void verUsuarios(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/ListaUsuarios.fxml"));
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
    public void modificarPerfil(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/ModificarAdministrador.fxml"));
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

    public void gestionPaises(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/Pais.fxml"));
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

    public void gestionVuelos(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/Vuelo.fxml"));
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
    public void salir(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/Main.fxml"));
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
