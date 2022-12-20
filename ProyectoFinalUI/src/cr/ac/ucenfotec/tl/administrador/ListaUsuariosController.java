package cr.ac.ucenfotec.tl.administrador;

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

public class ListaUsuariosController implements Initializable {

    UsuarioFinalGestor gestor = new UsuarioFinalGestor();
    ObservableList<Object> datos = FXCollections.observableArrayList();
    @FXML
    private TableView tblUsuariosFinales;
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

    public void cargarListaUsuariosFinales() throws Exception{
        tblUsuariosFinales.getItems().clear();
        gestor.listarUsuariosFinales().forEach(usuarioFinal -> datos.addAll(usuarioFinal));

        colUno.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colTres.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        colCuatro.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colCinco.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colSeis.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        colSiete.setCellValueFactory(new PropertyValueFactory<>("edad"));

        tblUsuariosFinales.setItems(datos);
    }

    public void volver(ActionEvent event) {
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
