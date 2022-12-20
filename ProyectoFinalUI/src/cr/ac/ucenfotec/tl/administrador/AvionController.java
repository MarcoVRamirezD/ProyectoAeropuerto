package cr.ac.ucenfotec.tl.administrador;

import cr.ac.ucenfotec.bl.entities.avion.Avion;
import cr.ac.ucenfotec.bl.logic.AvionGestor;
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

public class AvionController implements Initializable {

    private String mensaje;
    private AvionGestor gestor = new AvionGestor();
    ObservableList<Object> datos = FXCollections.observableArrayList();

    @FXML
    private TextField txtNumeroPlaca;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtCapacidad;
    @FXML
    private TableView tblAviones;
    @FXML
    private TableColumn colUno;
    @FXML
    private TableColumn colDos;
    @FXML
    private TableColumn colTres;
    @FXML
    private TableColumn colCuatro;

    public void registrarAvion(ActionEvent event) throws Exception{
        String placa = txtNumeroPlaca.getText();
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        String capacidad = txtCapacidad.getText();
        boolean error = false;

        error = validarCAmpos(placa, marca, modelo, capacidad);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            mensaje = gestor.registrarAvion(placa, marca, modelo, capacidad);
            txtNumeroPlaca.clear();
            txtMarca.clear();
            txtModelo.clear();
            txtCapacidad.clear();
            cargarlistaAviones();
            mostrarMensaje(mensaje);
        }
    }

    public void modificarAvion() throws Exception{
        String placa = txtNumeroPlaca.getText();
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        String capacidad = txtCapacidad.getText();
        boolean error = false;

        error = validarCAmpos(placa, marca, modelo, capacidad);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            mensaje = gestor.modificarAvion(placa, marca, modelo, capacidad);
            txtNumeroPlaca.clear();
            txtMarca.clear();
            txtModelo.clear();
            txtCapacidad.clear();
            cargarlistaAviones();
            mostrarMensaje(mensaje);
        }
    }

    public void eliminarAvion()throws Exception{
        String placa = txtNumeroPlaca.getText();
        mensaje = gestor.eliminarAvion(placa);
        cargarlistaAviones();
        mostrarMensaje(mensaje);
    }
    private boolean validarCAmpos(String placa, String marca, String modelo, String capacidad){
        boolean error = false;
        if (placa.equals("")){
            error = true;
        }
        if (marca.equals("")){
            error = true;
        }
        if (modelo.equals("")){
            error = true;
        }
        if (capacidad.equals("")){
            error = true;
        }
        return error;
    }

    public void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public void cargarlistaAviones() throws Exception{
        tblAviones.getItems().clear();
        gestor.listarAviones().forEach(avion -> datos.addAll(avion));

        colUno.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("marcaFabricante"));
        colTres.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colCuatro.setCellValueFactory(new PropertyValueFactory<>("capacidad"));

        tblAviones.setItems(datos);
    }

    public void cargarAvion(){
        Avion avion = (Avion) tblAviones.getSelectionModel().getSelectedItem();
        if (avion != null){
            txtNumeroPlaca.setText(""+avion.getPlaca()+"");
            txtMarca.setText(""+avion.getMarcaFabricante()+"");
            txtModelo.setText(""+avion.getModelo()+"");
            txtCapacidad.setText(""+avion.getCapacidad()+"");
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
