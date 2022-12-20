package cr.ac.ucenfotec.tl.tripulante;

import cr.ac.ucenfotec.bl.logic.VueloGestor;
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

public class ListaVuelosTripulanteController implements Initializable {

    private VueloGestor gestor = new VueloGestor();
    ObservableList<Object> datos = FXCollections.observableArrayList();
    @FXML
    private TableView tblVuelos;
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
    @FXML
    private TableColumn colDiez;
    @FXML
    private TableColumn colOnce;
    @FXML
    private TableColumn colDoce;
    @FXML
    private TableColumn colTrece;


    public void cargarListaVuelos() throws Exception{
        tblVuelos.getItems().clear();
        gestor.listarVuelos().forEach(vuelo -> datos.addAll(vuelo));

        colUno.setCellValueFactory(new PropertyValueFactory<>("lineaAerea"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("aeropuertoOrigen"));
        colTres.setCellValueFactory(new PropertyValueFactory<>("paisOrigen"));
        colCuatro.setCellValueFactory(new PropertyValueFactory<>("horaLlegada"));
        colCinco.setCellValueFactory(new PropertyValueFactory<>("horaSalida"));
        colSeis.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colSiete.setCellValueFactory(new PropertyValueFactory<>("aeropuertoDestino"));
        colOcho.setCellValueFactory(new PropertyValueFactory<>("paisDestino"));
        colNueve.setCellValueFactory(new PropertyValueFactory<>("tipoVuelo"));
        colDiez.setCellValueFactory(new PropertyValueFactory<>("avion"));
        colOnce.setCellValueFactory(new PropertyValueFactory<>("gateSalida"));
        colDoce.setCellValueFactory(new PropertyValueFactory<>("gateLlegada"));
        colTrece.setCellValueFactory(new PropertyValueFactory<>("tripulacion"));

        tblVuelos.setItems(datos);
    }
    public void volver(ActionEvent event) {
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
