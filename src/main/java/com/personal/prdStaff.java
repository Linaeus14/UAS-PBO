package com.personal;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import com.personal.model.key;
import com.personal.model.data.produk;

public class prdStaff {

    Alert info = new Alert(AlertType.INFORMATION);

    @FXML
    private Button bPrdBack, bPrdTambah;
    @FXML
    private TextField tHarga, tKode, tNama, tStok;
    @FXML
    private ComboBox<String> tProdusen;

    public void initialize() {

        key.numberInput(tHarga);
        key.numberInput(tStok);
        produk produk = new produk();
        clear();
        produk.fillComboBox(tProdusen);
        tProdusen.getSelectionModel().select(0);
        Platform.runLater(()->tKode.requestFocus());
    }
    
    @FXML
    void bPrdTambahClick(Event event) throws IOException {

        if (check()) {
            info.showAndWait();
        } else {   
            produk produk = new produk(
                tKode.getText(), 
                tNama.getText(), 
                tProdusen.getValue(), 
                tHarga.getText(), 
                tStok.getText()
            );

            if (!produk.writeData()) {
                info.setContentText("kode atau nama sudah ada!");
                info.showAndWait();
            } else {
                openMainStaff(event);
            }
        }
    }
    
    @FXML
    void bPrdBackClick(MouseEvent event) throws IOException {
        openMainStaff(event);
    }

    @FXML
    void tKodeEnter(KeyEvent event) {
        key.enterPress(event, tNama);
    }

    @FXML
    void tNamaEnter(KeyEvent event) {
        key.enterPress(event, tHarga);
    }

    @FXML
    void tHargaEnter(KeyEvent event) {

        key.enterPress(event, tStok);
    }

    @FXML
    void tStokEnter(KeyEvent ke) throws IOException {

        if (ke.getCode().equals(KeyCode.ENTER)) {
            bPrdTambahClick(ke);
        }
    }

    private Boolean check() {

        if (key.empty(tKode)) {
            info.setContentText("Mohon isi kode!");
            key.focus(tKode);;
            return true;

        } else if (key.empty(tNama)) {
            info.setContentText("Mohon isi nama barang!");
            key.focus(tNama);;
            return true;

        } else if (key.empty(tHarga)) {
            info.setContentText("Mohon isi harga barang!");
            key.focus(tHarga);;
            return true;

        } else if (key.empty(tStok)) {
            info.setContentText("Mohon isi stok barang!");
            key.focus(tStok);;
            return true;

        } else {
            return false;
        }
    }

    private void clear() {

        tKode.clear();
        tNama.clear();
        tProdusen.getSelectionModel().select(0);
        tHarga.clear();
        tStok.clear();
    }

    public void openMainStaff(Event e) throws IOException {
        App.setRoot("prdnStaff");
    }
}