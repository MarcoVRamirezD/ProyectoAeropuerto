package cr.ac.ucenfotec.tl.administrador;

import cr.ac.ucenfotec.bl.entities.pais.Pais;
import cr.ac.ucenfotec.bl.logic.PaisGestor;
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

public class PaisController implements Initializable {

    private PaisGestor gestor = new PaisGestor();
    ObservableList<Object> datos = FXCollections.observableArrayList();
    private String mensaje;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtAbreviatura;
    @FXML
    private TableView tblPaises;
    @FXML
    private TableColumn colUno;
    @FXML
    private TableColumn colDos;

    public void registrarPais(ActionEvent event)throws Exception{
        String nombre = txtNombre.getText();
        String abreviatura = txtAbreviatura.getText();
        boolean error=false;

        error = validarCAmpos(nombre, abreviatura);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            mensaje = gestor.registrarPais(nombre, abreviatura);
            txtNombre.clear();
            txtAbreviatura.clear();
            cargarListaPaises();
            mostrarMensaje(mensaje);
        }
    }

    public void modificarPais()throws Exception{
        String nombre = txtNombre.getText();
        String abreviatura = txtAbreviatura.getText();
        boolean error=false;

        error = validarCAmpos(nombre, abreviatura);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            mensaje = gestor.modificarPais(nombre, abreviatura);
            txtNombre.clear();
            txtAbreviatura.clear();
            cargarListaPaises();
            mostrarMensaje(mensaje);
        }
    }

    public void eliminarPais()throws Exception{
        String abreviatura = txtAbreviatura.getText();
        mensaje = gestor.eliminarPais(abreviatura);
        cargarListaPaises();
        mostrarMensaje(mensaje);
    }

    private boolean validarCAmpos(String nombre, String abreviatura){
        boolean error = false;
        if (nombre.equals("")){
            error = true;
        }
        if (abreviatura.equals("")){
            error = true;
        }
        return error;
    }

    public void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public void cargarListaPaises() throws Exception{
        tblPaises.getItems().clear();
        gestor.listarPaises().forEach(pais -> datos.addAll(pais));

        colUno.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("abreviatura"));

        tblPaises.setItems(datos);
    }

    public void cargarPais(){
        Pais pais = (Pais) tblPaises.getSelectionModel().getSelectedItem();
        if (pais != null){
            txtNombre.setText(""+pais.getNombre()+"");
            txtAbreviatura.setText(""+pais.getAbreviatura()+"");
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
