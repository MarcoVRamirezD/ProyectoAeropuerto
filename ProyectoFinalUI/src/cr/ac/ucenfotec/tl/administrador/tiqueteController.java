package cr.ac.ucenfotec.tl.administrador;

import cr.ac.ucenfotec.bl.entities.tiquete.Tiquete;
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

public class tiqueteController implements Initializable{
    String mensaje;
    private TiqueteGestor gestor = new TiqueteGestor();
    ObservableList<Object> datos = FXCollections.observableArrayList();
    @FXML
    private TextField txtFecha;
    @FXML
    private TextField txtPaisOrigen;
    @FXML
    private TextField txtAeropuertoOrigen;
    @FXML
    private TextField txtPaisDestino;
    @FXML
    private TextField txtAeropuertoDestino;
    @FXML
    private TextField txtNumeroAsiento;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtNumeroVuelo;
    @FXML
    private TextField txtTipoAsiento;
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

    public void registrarTiquete(ActionEvent event) throws Exception{
        String fecha = txtFecha.getText();
        String paisOrigen = txtPaisOrigen.getText();
        String aeropuertoOrigen = txtAeropuertoOrigen.getText();
        String paisDestino = txtPaisDestino.getText();
        String aeropuertoDestino = txtAeropuertoDestino.getText();
        String numeroAsiento = txtNumeroAsiento.getText();
        String precio = txtPrecio.getText();
        String numeroVuelo = txtNumeroVuelo.getText();
        String tipoAsiento = txtTipoAsiento.getText();
        boolean error = false;

        error = validarCampos(fecha, paisOrigen, aeropuertoOrigen, paisDestino, aeropuertoDestino, numeroVuelo, tipoAsiento);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            mensaje = gestor.registrarTiquete(fecha,paisOrigen, aeropuertoOrigen, paisDestino, aeropuertoDestino, numeroAsiento, precio, numeroVuelo, tipoAsiento);
            txtFecha.clear();
            txtPaisOrigen.clear();
            txtAeropuertoOrigen.clear();
            txtPaisDestino.clear();
            txtAeropuertoDestino.clear();
            txtNumeroAsiento.clear();
            txtPrecio.clear();
            txtNumeroVuelo.clear();
            txtTipoAsiento.clear();
            cargarlistaTiquetes();
            mostrarMensaje(mensaje);
        }
    }

    public void modificarTiquete() throws Exception{
        String fecha = txtFecha.getText();
        String paisOrigen = txtPaisOrigen.getText();
        String aeropuertoOrigen = txtAeropuertoOrigen.getText();
        String paisDestino = txtPaisDestino.getText();
        String aeropuertoDestino = txtAeropuertoDestino.getText();
        String numeroAsiento = txtNumeroAsiento.getText();
        String precio = txtPrecio.getText();
        String numeroVuelo = txtNumeroVuelo.getText();
        String tipoAsiento = txtTipoAsiento.getText();
        boolean error = false;

        error = validarCampos(fecha, paisOrigen, aeropuertoOrigen, paisDestino, aeropuertoDestino, numeroVuelo, tipoAsiento);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            mensaje = gestor.modificarTiquete(fecha,paisOrigen, aeropuertoOrigen, paisDestino, aeropuertoDestino, numeroAsiento, precio, numeroVuelo, tipoAsiento);
            txtFecha.clear();
            txtPaisOrigen.clear();
            txtAeropuertoOrigen.clear();
            txtPaisDestino.clear();
            txtAeropuertoDestino.clear();
            txtNumeroAsiento.clear();
            txtPrecio.clear();
            txtNumeroVuelo.clear();
            txtTipoAsiento.clear();
            cargarlistaTiquetes();
            mostrarMensaje(mensaje);
        }
    }

    public void eliminarTiquete() throws Exception{
        String numeroAsiento = txtNumeroAsiento.getText();
        String numeroVuelo = txtNumeroVuelo.getText();
        mensaje = gestor.eliminarTiquete(numeroAsiento, numeroVuelo);
        cargarlistaTiquetes();
        mostrarMensaje(mensaje);
    }

    private boolean validarCampos(String fecha, String paisOrigen, String aeropuertoOrigen, String paisDestino, String aeropuertoDestino, String numeroVuelo,
                                  String tipoAsiento){
        boolean error = false;
        if (fecha.equals("")){
            error = true;
        }
        if (paisOrigen.equals("")){
            error = true;
        }
        if (aeropuertoOrigen.equals("")){
            error = true;
        }
        if (paisDestino.equals("")){
            error = true;
        }
        if (aeropuertoDestino.equals("")){
            error = true;
        }
        if (txtNumeroAsiento.getText().equals("")){
            error = true;
        }
        if (txtPrecio.getText().equals("")){
            error = true;
        }
        if (numeroVuelo.equals("")){
            error = true;
        }
        if (tipoAsiento.equals("")){
            error = true;
        }
        return error;
    }

    public void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

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

    public void cargarTiquete() throws Exception{
        Tiquete tiquete = (Tiquete) tblTiquetes.getSelectionModel().getSelectedItem();
        if (tiquete != null){
            txtFecha.setText(""+tiquete.getFecha()+"");
            txtPaisOrigen.setText(""+tiquete.getPaisOrigen()+"");
            txtAeropuertoOrigen.setText(""+tiquete.getAeropuertoOrigen()+"");
            txtPaisDestino.setText(""+tiquete.getPaisOrigen()+"");
            txtAeropuertoDestino.setText(""+tiquete.getAeropuertoDestino()+"");
            txtNumeroAsiento.setText(""+tiquete.getNumeroAsiento()+"");
            txtPrecio.setText(""+tiquete.getPrecio()+"");
            txtNumeroVuelo.setText(""+tiquete.getNumeroVuelo()+"");
            txtTipoAsiento.setText(""+tiquete.getTipoAsiento()+"");
        }
    }
    public void volver(ActionEvent event){
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
