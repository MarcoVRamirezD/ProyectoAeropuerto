package cr.ac.ucenfotec.tl.administrador;

import cr.ac.ucenfotec.bl.entities.lineaAerea.LineaAerea;
import cr.ac.ucenfotec.bl.logic.LineaAereaGestor;
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

public class LineaAereaController implements Initializable {

    private String mensaje;
    private LineaAereaGestor gestor = new LineaAereaGestor();
    ObservableList<Object> datos = FXCollections.observableArrayList();
    @FXML
    private TextField txtNombreComercial;
    @FXML
    private TextField txtCedulaJuridica;
    @FXML
    private TextField txtEmpresaDuenna;
    @FXML
    private TextField txtCodigoPais;
    @FXML
    private TableView tblLineasAereas;
    @FXML
    private TableColumn colUno;
    @FXML
    private TableColumn colDos;
    @FXML
    private TableColumn colTres;
    @FXML
    private TableColumn colCuatro;

    public void registrarLineaAerea(ActionEvent event) throws Exception{
        String nombreComercial = txtNombreComercial.getText();
        String cedulaJuridica = txtCedulaJuridica.getText();
        String empresaDuenna = txtEmpresaDuenna.getText();
        String codigoPais = txtCodigoPais.getText();
        boolean error = false;

        error = validarCAmpos(nombreComercial, cedulaJuridica, empresaDuenna, codigoPais);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            mensaje = gestor.registrarLineaAerea(nombreComercial, cedulaJuridica, empresaDuenna, codigoPais);
            txtNombreComercial.clear();
            txtCedulaJuridica.clear();
            txtEmpresaDuenna.clear();
            txtCodigoPais.clear();
            cargarListaLineasAereas();
            mostrarMensaje(mensaje);
        }
    }

    public void modificarLineasAereas() throws Exception {
        String nombreComercial = txtNombreComercial.getText();
        String cedulaJuridica = txtCedulaJuridica.getText();
        String empresaDuenna = txtEmpresaDuenna.getText();
        String codigoPais = txtCodigoPais.getText();
        boolean error = false;

        error = validarCAmpos(nombreComercial, cedulaJuridica, empresaDuenna, codigoPais);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            mensaje = gestor.modificarLineaAerea(nombreComercial, cedulaJuridica, empresaDuenna, codigoPais);
            txtNombreComercial.clear();
            txtCedulaJuridica.clear();
            txtEmpresaDuenna.clear();
            txtCodigoPais.clear();
            cargarListaLineasAereas();
            mostrarMensaje(mensaje);
        }
    }

    public void eliminarLineaAerea()throws Exception{
        String cedulaJuridica = txtCedulaJuridica.getText();
        mensaje = gestor.elminarLineaAerea(cedulaJuridica);
        cargarListaLineasAereas();
        mostrarMensaje(mensaje);
    }

    private boolean validarCAmpos(String nombreComercial, String cedulaJuridica, String empresaDuenna, String codigoPais){
        boolean error = false;
        if (nombreComercial.equals("")){
            error = true;
        }
        if (cedulaJuridica.equals("")){
            error = true;
        }
        if (empresaDuenna.equals("")){
            error = true;
        }
        if (codigoPais.equals("")){
            error = true;
        }
        return error;
    }

    public void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public void cargarListaLineasAereas() throws Exception{
        tblLineasAereas.getItems().clear();
        gestor.listarLineasAereas().forEach(lineaAerea -> datos.addAll(lineaAerea));

        colUno.setCellValueFactory(new PropertyValueFactory<>("nombreComercial"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("cedulaJuridica"));
        colTres.setCellValueFactory(new PropertyValueFactory<>("nombreEmpresaDuenna"));
        colCuatro.setCellValueFactory(new PropertyValueFactory<>("codigoPais"));

        tblLineasAereas.setItems(datos);
    }

    public void cargarLineaAerea(){
        LineaAerea lineaAerea = (LineaAerea) tblLineasAereas.getSelectionModel().getSelectedItem();

        if (lineaAerea != null){
            txtNombreComercial.setText(""+lineaAerea.getNombreComercial()+"");
            txtCedulaJuridica.setText(""+lineaAerea.getCedulaJuridica()+"");
            txtEmpresaDuenna.setText(""+lineaAerea.getNombreEmpresaDuenna()+"");
            txtCodigoPais.setText(""+lineaAerea.getCodigoPais()+"");
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
