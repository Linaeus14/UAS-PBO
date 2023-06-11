package com.personal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.personal.model.strip;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static strip akun = new strip(null);

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("auth"), 640, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static strip getAkun() {
        return akun;
    }

    public static void setAkun(String nama, String kode, String status) {
        
        akun.setNama(nama);
        akun.setKode(kode);
        akun.setStatus(status);
    }

    public static void nullAkun() {

        akun.setNama(null);
        akun.setKode(null);
        akun.setStatus(null);
    }

    private static Parent loadFXML(String fxml) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }        
}