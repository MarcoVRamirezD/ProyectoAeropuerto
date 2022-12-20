package cr.ac.ucenfotec.tl.usuario;

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

public class RegistroUsuarioController implements Initializable {

    private UsuarioFinalGestor gestor = new UsuarioFinalGestor();
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
    private TextField txtFechaNacimiento;
    @FXML
    private TextField txtProvincia;
    @FXML
    private TextField txtCanton;
    @FXML
    private TextField txtDistrito;


    public void registrarUsuarioFinal(ActionEvent event) throws Exception{
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String identificacion = txtIdentificacion.getText();
        String correo = txtCorreo.getText();
        String contrasenna = txtContrasenna.getText();
        String direccion = txtDireccion.getText();
        String nacionalidad = txtNacionalidad.getText();
        String fechaNacimiento = txtFechaNacimiento.getText();
        String provincia = txtProvincia.getText();
        String canton = txtCanton.getText();
        String distrito = txtDistrito.getText();
        boolean error = false;

        error = validarCampos(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad, fechaNacimiento, provincia, canton, distrito);
        if (error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            mensaje = gestor.registrarUsuarioFinal(nombre, apellidos, identificacion, correo, contrasenna, direccion, nacionalidad, fechaNacimiento, provincia, canton, distrito);
            txtNombre.clear();
            txtApellidos.clear();
            txtIdentificacion.clear();
            txtCorreo.clear();
            txtContrasenna.clear();
            txtDireccion.clear();
            txtNacionalidad.clear();
            txtFechaNacimiento.clear();
            txtProvincia.clear();
            txtCanton.clear();
            txtDistrito.clear();
            mostrarMensaje(mensaje);
        }

    }

    private boolean validarCampos(String nombre, String apellidos, String identificacion, String correo, String contrasenna, String direccion,
                                  String nacionalidad, String fechaNacimiento, String provincia, String canton, String distrito){
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
        if (fechaNacimiento.equals("")){
            error = true;
        }
        if (provincia.equals("")){
            error = true;
        }
        if (canton.equals("")){
            error = true;
        }
        if (distrito.equals("")){
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
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../ui/usuario/LoginUsuario.fxml"));
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
