package cr.ac.ucenfotec.tl.tripulante;

import cr.ac.ucenfotec.bl.entities.miembroTripulacion.MiembroTripulacion;
import cr.ac.ucenfotec.bl.logic.MiembroTripulacionGestor;
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

public class ModificarTripulanteController implements Initializable {

    private MiembroTripulacion miembroTripulacionSesion = LoginTripulanteController.getMiembroTripulacionSesion();
    MiembroTripulacionGestor gestor = new MiembroTripulacionGestor();
    private String mensaje;

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtIdentificacion;
    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtContrasenna;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtNacionalidad;
    @FXML
    private TextField txtGenero;
    @FXML
    private TextField txtAnnosExperiencia;
    @FXML
    private TextField txtFechaGraduacion;
    @FXML
    private TextField txtNumeroLicencia;
    @FXML
    private TextField txtPuesto;
    @FXML
    private TextField txtTelefono;

    public void mostrar(){
        txtNombre.setText(""+miembroTripulacionSesion.getNombre()+"");
        txtApellidos.setText(""+miembroTripulacionSesion.getApellidos()+"");
        txtIdentificacion.setText(""+miembroTripulacionSesion.getIdentificacion()+"");
        txtCorreo.setText(""+miembroTripulacionSesion.getCorreo()+"");
        txtContrasenna.setText(""+miembroTripulacionSesion.getContrasenna()+"");
        txtDireccion.setText(""+miembroTripulacionSesion.getDireccion()+"");
        txtNacionalidad.setText(""+miembroTripulacionSesion.getNacionalidad()+"");
        txtGenero.setText(""+miembroTripulacionSesion.getGenero()+"");
        txtAnnosExperiencia.setText(""+miembroTripulacionSesion.getAnnosExperiencia()+"");
        txtFechaGraduacion.setText(""+miembroTripulacionSesion.getFechaGraduacion()+"");
        txtNumeroLicencia.setText(""+miembroTripulacionSesion.getNumeroLicencia()+"");
        txtPuesto.setText(""+miembroTripulacionSesion.getPuesto()+"");
        txtTelefono.setText(""+miembroTripulacionSesion.getTelefono()+"");
    }

    public void modificarTripulante(ActionEvent event) throws Exception{
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String identificacion = txtIdentificacion.getText();
        String correo = txtCorreo.getText();
        String contrasenna = txtContrasenna.getText();
        String direccion = txtDireccion.getText();
        String nacionalidad = txtNacionalidad.getText();
        String genero = txtGenero.getText();
        String annosExperiencia = txtAnnosExperiencia.getText();
        String fechaGraduacion = txtFechaGraduacion.getText();
        String numeroLicencia = txtNumeroLicencia.getText();
        String puesto = txtPuesto.getText();
        String telefono = txtTelefono.getText();
        boolean error = false;

        error = validarCampos(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad, genero, annosExperiencia,
                              fechaGraduacion, numeroLicencia, puesto, telefono);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {

            mensaje = gestor.modificarMiembroTripulacion(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad,
                                                         genero, annosExperiencia, fechaGraduacion, numeroLicencia, puesto, telefono);
            txtNombre.clear();
            txtApellidos.clear();
            txtIdentificacion.clear();
            txtCorreo.clear();
            txtContrasenna.clear();
            txtDireccion.clear();
            txtNacionalidad.clear();
            txtGenero.clear();
            txtAnnosExperiencia.clear();
            txtFechaGraduacion.clear();
            txtNumeroLicencia.clear();
            txtPuesto.clear();
            txtTelefono.clear();
            mostrarMensaje(mensaje);
            MainController volver = new MainController();
            volver.volver(event);
        }
    }

    private boolean validarCampos(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion,
                                  String nacionalidad, String genero, String annosExperiencia, String fechaGraduacion, String numeroLicencia,
                                  String puesto, String telefono){
        boolean error = false;
        if (nombre.equals("")){
            error = true;
        }
        if (apellidos.equals("")){
            error = true;
        }
        if (identificacion.equals("")){
            error = true;
        }
        if (correo.equals("")){
            error = true;
        }
        if (contrasenna.equals("")){
            error = true;
        }
        if (direccion.equals("")){
            error = true;
        }
        if (nacionalidad.equals("")){
            error = true;
        }
        if (genero.equals("")){
            error = true;
        }
        if (annosExperiencia.equals("")){
            error = true;
        }
        if (fechaGraduacion.equals("")){
            error = true;
        }
        if (numeroLicencia.equals("")){
            error = true;
        }
        if (puesto.equals("")){
            error = true;
        }
        if (telefono.equals("")){
            error = true;
        }
        return error;
    }

    public void mostrarMensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
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
