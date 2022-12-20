package cr.ac.ucenfotec.tl.administrador;

import cr.ac.ucenfotec.bl.entities.aeropuerto.Aeropuerto;
import cr.ac.ucenfotec.bl.logic.AeropuertoGestor;
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

public class AeropuertoController implements Initializable {

    private String mensaje;
    private AeropuertoGestor gestor = new AeropuertoGestor();
    ObservableList<Object> datos = FXCollections.observableArrayList();

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCodigoAeropuerto;
    @FXML
    private TextField txtCodigoPais;
    @FXML
    private TextField txtIdentificacionAdmin;
    @FXML
    private TableView tblAeropuertos;
    @FXML
    private TableColumn colUno;
    @FXML
    private TableColumn colDos;
    @FXML
    private TableColumn colTres;
    @FXML
    private TableColumn colCuatro;

    public void modificarAeropuerto() throws Exception{
        String nombre = txtNombre.getText();
        String codigoA = txtCodigoAeropuerto.getText();
        String codigoP = txtCodigoPais.getText();
        String identificacion = txtIdentificacionAdmin.getText();
        boolean error = false;

        error = validarCAmpos(nombre, codigoA, codigoP, identificacion);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            mensaje = gestor.modificarAeropuerto(nombre, codigoA, codigoP, identificacion);
            txtNombre.clear();
            txtCodigoAeropuerto.clear();
            txtCodigoPais.clear();
            txtIdentificacionAdmin.clear();
            mostrarMensaje(mensaje);
            cargarListaAeropuertos();
        }
    }

    public void eliminarAeropuerto() throws Exception{
        String codigoAeropuerto = txtCodigoAeropuerto.getText();
        mensaje = gestor.eliminarAeropuerto(codigoAeropuerto);
        mostrarMensaje(mensaje);
        cargarListaAeropuertos();
    }

    private boolean validarCAmpos(String nombre, String codigoA, String codigoP, String identificacionAdmin){
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
        if (identificacionAdmin.equals("")){
            error = true;
        }
        return error;
    }

    public void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public void cargarListaAeropuertos() throws Exception{
        tblAeropuertos.getItems().clear();
        gestor.listarAeropuertos().forEach(aeropuerto -> datos.addAll(aeropuerto));

        colUno.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("codigoAeropuerto"));
        colTres.setCellValueFactory(new PropertyValueFactory<>("codigoPais"));
        colCuatro.setCellValueFactory(new PropertyValueFactory<>("identificacionAdministrador"));

        tblAeropuertos.setItems(datos);
    }

    public void cargarAeropuerto(){
        Aeropuerto aeropuerto = (Aeropuerto)tblAeropuertos.getSelectionModel().getSelectedItem();
        if (aeropuerto != null){
            txtNombre.setText(""+aeropuerto.getNombre()+"");
            txtCodigoAeropuerto.setText(""+aeropuerto.getCodigoAeropuerto()+"");
            txtCodigoPais.setText(""+aeropuerto.getCodigoPais()+"");
            txtIdentificacionAdmin.setText(""+aeropuerto.getIdentificacionAdministrador()+"");
        }
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
