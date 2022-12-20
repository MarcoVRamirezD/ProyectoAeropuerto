package cr.ac.ucenfotec.tl.administrador;

import cr.ac.ucenfotec.bl.entities.vuelo.Vuelo;
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

public class VueloController implements Initializable {

    private String mensaje;
    private VueloGestor gestor = new VueloGestor();
    ObservableList<Object> datos = FXCollections.observableArrayList();

    @FXML
    private TextField txtCedulaJuridica;
    @FXML
    private TextField txtAeropuertoOrigen;
    @FXML
    private TextField txtPaisOrigen;
    @FXML
    private TextField txtHoraLlegada;
    @FXML
    private TextField txtHoraSalida;
    @FXML
    private TextField txtEstado;
    @FXML
    private TextField txtAeropuertoDestino;
    @FXML
    private TextField txtPaisDestino;
    @FXML
    private TextField txtTipoVuelo;
    @FXML
    private TextField txtPlaca;
    @FXML
    private TextField txtGateSalida;
    @FXML
    private TextField txtGateLlegada;
    @FXML
    private TextField txtTripulacion;
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

    public void registrarVuelo()throws Exception{
        String cedulaJuridica = txtCedulaJuridica.getText();
        String aeropuertoOrigen = txtAeropuertoOrigen.getText();
        String paisOrigen = txtPaisOrigen.getText();
        String horaLlegada = txtHoraLlegada.getText();
        String horaSalida = txtHoraSalida.getText();
        String estado = txtEstado.getText();
        String aeropuertoDestino = txtAeropuertoDestino.getText();
        String paisDestino = txtPaisDestino.getText();
        String tipoVuelo = txtTipoVuelo.getText();
        String avion = txtPlaca.getText();
        String gateSalida = txtGateSalida.getText();
        String gateLlegada = txtGateLlegada.getText();
        String tripulacion = txtTripulacion.getText();
        boolean error = false;

        error = validarCampos(cedulaJuridica, aeropuertoOrigen, paisOrigen, horaLlegada, horaSalida, estado, aeropuertoDestino, paisDestino, tipoVuelo, avion, gateSalida, gateLlegada, tripulacion);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else {
            mensaje = gestor.registrarVuelo(cedulaJuridica, aeropuertoOrigen, paisOrigen, horaLlegada, horaSalida, estado, aeropuertoDestino, paisDestino, tipoVuelo, avion, gateSalida, gateLlegada, tripulacion);
            txtCedulaJuridica.clear();
            txtAeropuertoOrigen.clear();
            txtPaisOrigen.clear();
            txtHoraLlegada.clear();
            txtHoraSalida.clear();
            txtEstado.clear();
            txtAeropuertoDestino.clear();
            txtPaisDestino.clear();
            txtTipoVuelo.clear();
            txtPlaca.clear();
            txtGateSalida.clear();
            txtGateLlegada.clear();
            txtTripulacion.clear();
            cargarListaVuelos();
            mostrarMensaje(mensaje);
        }
    }

    public void modificarVuelo() throws Exception{
        String cedulaJuridica = txtCedulaJuridica.getText();
        String aeropuertoOrigen = txtAeropuertoOrigen.getText();
        String paisOrigen = txtPaisOrigen.getText();
        String horaLlegada = txtHoraLlegada.getText();
        String horaSalida = txtHoraSalida.getText();
        String estado = txtEstado.getText();
        String aeropuertoDestino = txtAeropuertoDestino.getText();
        String paisDestino = txtPaisDestino.getText();
        String tipoVuelo = txtTipoVuelo.getText();
        String avion = txtPlaca.getText();
        String gateSalida = txtGateSalida.getText();
        String gateLlegada = txtGateLlegada.getText();
        String tripulacion = txtTripulacion.getText();
        boolean error = false;

        error = validarCampos(cedulaJuridica, aeropuertoOrigen, paisOrigen, horaLlegada, horaSalida, estado, aeropuertoDestino, paisDestino, tipoVuelo, avion, gateSalida, gateLlegada, tripulacion);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }else {
            mensaje = gestor.modificarVuelo(cedulaJuridica, aeropuertoOrigen, paisOrigen, horaLlegada, horaSalida, estado, aeropuertoDestino, paisDestino, tipoVuelo, avion, gateSalida, gateLlegada, tripulacion);
            txtCedulaJuridica.clear();
            txtAeropuertoOrigen.clear();
            txtPaisOrigen.clear();
            txtHoraLlegada.clear();
            txtHoraSalida.clear();
            txtEstado.clear();
            txtAeropuertoDestino.clear();
            txtPaisDestino.clear();
            txtTipoVuelo.clear();
            txtPlaca.clear();
            txtGateSalida.clear();
            txtGateLlegada.clear();
            txtTripulacion.clear();
            cargarListaVuelos();
            mostrarMensaje(mensaje);
        }
    }

    public void eliminarVuelo() throws Exception{
        String horaLlegada = txtHoraLlegada.getText();
        String horaSalida = txtHoraSalida.getText();
        String tripulacion = txtTripulacion.getText();
        mensaje = gestor.eliminarVuelo(horaLlegada,horaSalida,tripulacion);
        cargarListaVuelos();
        mostrarMensaje(mensaje);
    }

    private boolean validarCampos(String cedulaJuridica, String aeropuertoOrigen, String paisOrigen, String horaLlegada, String horaSalida, String estado,
                                  String aeropuertoDestino, String paisDestino, String tipoVuelo, String avion, String gateSalida, String gateLlegada,
                                  String tripulacion){
        boolean error = false;
        if (cedulaJuridica.equals("")){
            error = true;
        }
        if (aeropuertoOrigen.equals("")){
            error = true;
        }
        if (paisOrigen.equals("")){
            error = true;
        }
        if (horaLlegada.equals("")){
            error = true;
        }
        if (horaSalida.equals("")){
            error = true;
        }
        if (estado.equals("")){
            error = true;
        }
        if (aeropuertoDestino.equals("")){
            error = true;
        }
        if (paisDestino.equals("")){
            error = true;
        }
        if (tipoVuelo.equals("")){
            error = true;
        }
        if (avion.equals("")){
            error = true;
        }
        if (gateSalida.equals("")){
            error = true;
        }
        if (gateLlegada.equals("")){
            error = true;
        }
        if (tripulacion.equals("")){
            error = true;
        }
        return error;
    }

    public void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

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

    public void cargarVuelo() throws Exception{
        Vuelo vuelo = (Vuelo) tblVuelos.getSelectionModel().getSelectedItem();

        if (vuelo != null){
            txtCedulaJuridica.setText(""+vuelo.getLineaAerea()+"");
            txtAeropuertoOrigen.setText(""+vuelo.getAeropuertoOrigen()+"");
            txtPaisOrigen.setText(""+vuelo.getPaisOrigen()+"");
            txtHoraLlegada.setText(""+vuelo.getHoraLlegada()+"");
            txtHoraSalida.setText(""+vuelo.getHoraSalida()+"");
            txtEstado.setText(""+vuelo.getEstado()+"");
            txtAeropuertoDestino.setText(""+vuelo.getAeropuertoDestino()+"");
            txtPaisDestino.setText(""+vuelo.getPaisDestino()+"");
            txtTipoVuelo.setText(""+vuelo.getTipoVuelo()+"");
            txtPlaca.setText(""+vuelo.getAvion()+"");
            txtGateSalida.setText(""+vuelo.getGateSalida()+"");
            txtGateLlegada.setText(""+vuelo.getGateLlegada()+"");
            txtTripulacion.setText(""+vuelo.getTripulacion()+"");
        }
    }

    public void tiquetes(ActionEvent event){

        try{
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/administrador/Tiquete.fxml"));
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
