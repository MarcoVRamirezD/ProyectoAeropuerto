package cr.ac.ucenfotec.tl.usuario;

import cr.ac.ucenfotec.bl.logic.TiqueteGestor;
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

public class ComprarTiqueteController implements Initializable {

    private TiqueteGestor gestor = new TiqueteGestor();
    ObservableList<Object> datos = FXCollections.observableArrayList();

    @FXML
    private TableView tblTiquetes;
    @FXML
    private TableColumn colUno;
    @FXML
    private TableColumn colDos;
    @FXML
    private TableColumn colTres;
    @FXML
    private TableColumn colCuatro;
    @FXML
    private TableColumn colCinco;
    @FXML
    private TableColumn colSeis;
    @FXML
    private TableColumn colSiete;
    @FXML
    private TableColumn colOcho;
    @FXML
    private TableColumn colNueve;

    public void cargarlistaTiquetes() throws Exception{
        tblTiquetes.getItems().clear();
        gestor.listarTiquetes().forEach(tiquete -> datos.addAll(tiquete));

        colUno.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("paisOrigen"));
        colTres.setCellValueFactory(new PropertyValueFactory<>("aeropuertoOrigen"));
        colCuatro.setCellValueFactory(new PropertyValueFactory<>("paisDestino"));
        colCinco.setCellValueFactory(new PropertyValueFactory<>("aeropuertoDestino"));
        colSeis.setCellValueFactory(new PropertyValueFactory<>("numeroAsiento"));
        colSiete.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colOcho.setCellValueFactory(new PropertyValueFactory<>("numeroVuelo"));
        colNueve.setCellValueFactory(new PropertyValueFactory<>("tipoAsiento"));

        tblTiquetes.setItems(datos);
    }

    public void volver(ActionEvent event) {
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
