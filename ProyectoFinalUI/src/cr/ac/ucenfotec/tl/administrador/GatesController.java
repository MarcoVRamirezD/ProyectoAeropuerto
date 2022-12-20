package cr.ac.ucenfotec.tl.administrador;

import cr.ac.ucenfotec.bl.entities.gate.Gate;
import cr.ac.ucenfotec.bl.logic.GateGestor;
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

public class GatesController implements Initializable {

    private GateGestor gestor = new GateGestor();
    ObservableList<Object> datos = FXCollections.observableArrayList();
    private String mensaje;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtUbicacion;
    @FXML
    private TableView tblGates;
    @FXML
    private TableColumn colUno;
    @FXML
    private TableColumn colDos;
    @FXML
    private TableColumn colTres;

    public void registrarGate(ActionEvent event)throws Exception{
        String nombre = txtNombre.getText();
        String codigo = txtCodigo.getText();
        String ubicacion = txtUbicacion.getText();
        boolean error=false;

        error=validarCAmpos(nombre, codigo, ubicacion);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();

        } else {
            mensaje = gestor.registrarGate(nombre, codigo, ubicacion);
            txtNombre.clear();
            txtCodigo.clear();
            txtUbicacion.clear();
            cargarListaGates();
            mostrarMensaje(mensaje);
        }
    }

    public void modificarGate()throws Exception{
        String nombre = txtNombre.getText();
        String codigo = txtCodigo.getText();
        String ubicacion = txtUbicacion.getText();
        boolean error=false;

        error=validarCAmpos(nombre, codigo, ubicacion);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();

        } else {
            mensaje = gestor.modificarGate(nombre, codigo, ubicacion);
            txtNombre.clear();
            txtCodigo.clear();
            txtUbicacion.clear();
            cargarListaGates();
            mostrarMensaje(mensaje);
        }
    }

    public void eliminarGate()throws Exception{
        String codigo = txtCodigo.getText();
        mensaje = gestor.eliminarGate(codigo);
        cargarListaGates();
        mostrarMensaje(mensaje);
    }

    private boolean validarCAmpos(String nombre, String codigo, String ubicacion){
        boolean error = false;
        if (nombre.equals("")){
            error = true;
        }
        if (codigo.equals("")){
            error = true;
        }
        if (ubicacion.equals("")){
            error = true;
        }
        return error;
    }

    public void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public void cargarListaGates() throws Exception{
        tblGates.getItems().clear();
        gestor.listarGates().forEach(gate -> datos.addAll(gate));

        colUno.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colTres.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));

        tblGates.setItems(datos);
    }

    public void cargarGate(){
        Gate gate = (Gate) tblGates.getSelectionModel().getSelectedItem();
        if (gate != null){
            txtNombre.setText(""+gate.getNombre()+"");
            txtCodigo.setText(""+gate.getCodigo()+"");
            txtUbicacion.setText(""+gate.getUbicacion()+"");
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
