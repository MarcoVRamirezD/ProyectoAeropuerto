package cr.ac.ucenfotec;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/Main.fxml"));
        primaryStage.setTitle("Sistema de aeropuerto");
        primaryStage.setScene(new Scene(root, 1280, 700));
        primaryStage.show();
    }
}