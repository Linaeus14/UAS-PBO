package com.personal;

import java.io.IOException;

import com.personal.model.strip;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class mainController {

    protected strip akun = new strip();
    
    protected Alert info = new Alert(AlertType.INFORMATION), alert = new Alert(AlertType.CONFIRMATION);

    @FXML
    protected Label stripKode, stripNama, stripStatus;
    @FXML
    protected Button bLogOut;

    @FXML
    void bLogOutClick(Event e) throws IOException {

        App.nullAkun();
        openBefore(e);
    }

    protected boolean checkSelected(TableView<?> table) {

        if (table.getSelectionModel().getSelectedItem() != null) {
            return true;
        } else {
            return false;
        }
    }

    protected void setStrip() {

        stripNama.setText(akun.getNama());
        stripKode.setText(akun.getKode());
        stripStatus.setText(akun.getStatus());
    }

    protected final void openBefore(Event e) throws IOException {

        App.setRoot("auth");
    }
}
