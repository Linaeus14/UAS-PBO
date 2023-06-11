package com.personal;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import com.personal.model.key;
import com.personal.model.data.manager;
import com.personal.model.data.staff;

public class mainAdm extends mainController {

    @FXML
    private Button bHapusMan, bHapusStaff, bTambahMan, bTambahStaff, bUbahMan, bUbahStaff;
    @FXML
    private TextField keywordMan, keywordStaff, tNamaMan, tNamaStaff, tPassMan, tPassStaff, tUseridMan, tUseridStaff;
    @FXML
    private Label stripKode, stripNama, stripStatus;
    @FXML
    private Tab tabAdmin;
    @FXML
    private TableView<ObservableList<String>> tableMan, tableStaff;
    @FXML
    private ComboBox<String> typeMan, typeStaff;

    public void initialize() {

        alert.setTitle("Hapus");
        alert.setContentText("Yakin ingin hapus?");
        info.setTitle("Informasi");
        info.setContentText("Mohon pilih terlebih dahulu!");

        typeStaff.getItems().removeAll(typeStaff.getItems());
        typeStaff.getItems().addAll("Nama", "Userid");
        typeStaff.getSelectionModel().select("nama");

        typeMan.getItems().removeAll(typeMan.getItems());
        typeMan.getItems().addAll("Nama", "Userid");
        typeMan.getSelectionModel().select("Nama");

        setStrip();
        tabOnStaff();
        tabOnManager();
    }

    @FXML
    void tableStaffSelect(MouseEvent event) {

        ObservableList<String> selectedList = tableStaff.getSelectionModel().getSelectedItem();
        tUseridStaff.setText(selectedList.get(0));
        tPassStaff.setText(selectedList.get(1));
        tNamaStaff.setText(selectedList.get(2));
    }

    @FXML
    void bTambahStaffClick(MouseEvent event) throws IOException {
        openStaff(event);
    }

    @FXML
    void bUbahStaffClick(MouseEvent event) {

        if (checkSelected(tableStaff)) {

            staff staff = new staff(
                    tUseridStaff.getText(),
                    tPassStaff.getText(),
                    tNamaStaff.getText(),
                    null,
                    "staff");

            staff.updateData();
            clearStaff();
            staff.readData(tableStaff);
        } else {
            info.show();
        }
    }

    @FXML
    void bHapusStaffClick(MouseEvent event) {

        if (checkSelected(tableStaff)) {
            ObservableList<String> selectedList = tableStaff.getSelectionModel().getSelectedItem();
            staff staff = new staff(selectedList.get(0));

            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    staff.deleteData();
                    clearStaff();
                    staff.readData(tableStaff);
                }
            });
        } else {
            info.showAndWait();
        }
    }

    @FXML
    void keywordStaffChanged(KeyEvent event) {

        staff staff = new staff();
        staff.searchData(tableStaff, keywordStaff, typeStaff.getValue());
    }

    @FXML
    void tableManSelect(MouseEvent event) {

        ObservableList<String> selectedList = tableMan.getSelectionModel().getSelectedItem();
        tUseridMan.setText(selectedList.get(0));
        tPassMan.setText(selectedList.get(1));
        tNamaMan.setText(selectedList.get(2));
    }

    @FXML
    void bTambahManClick(MouseEvent event) throws IOException {
        openMan(event);
    }

    @FXML
    void bUbahManClick(MouseEvent event) {

        if (checkSelected(tableMan)) {
            manager manager = new manager(
                    tUseridMan.getText(),
                    tPassMan.getText(),
                    tNamaMan.getText(),
                    null,
                    "manager");

            manager.updateData();
            clearMan();
            manager.readData(tableMan);
        } else {
            info.show();
        }
    }

    @FXML
    void bHapusManClick(MouseEvent event) {

        if (checkSelected(tableMan)) {
            ObservableList<String> selectedList = tableMan.getSelectionModel().getSelectedItem();
            manager manager = new manager(selectedList.get(0));

            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    manager.deleteData();
                    clearMan();
                    manager.readData(tableMan);
                }
            });
        } else {
            info.showAndWait();
        }
    }

    @FXML
    void keywordManChanged(KeyEvent event) {

        manager manager = new manager();
        manager.searchData(tableMan, keywordMan, typeMan.getValue());
    }

    @FXML
    void tabChange(Event event) {

        if (tabAdmin.isSelected()) {
            tabOnStaff();
        } else {
            tabOnManager();
        }
    }

    private void tabOnStaff() {

        staff staff = new staff();
        staff.readData(tableStaff);
        key.focus(keywordStaff);
    }

    private void tabOnManager() {

        manager manager = new manager();
        manager.readData(tableMan);
        key.focus(keywordMan);
    }

    private void clearStaff() {

        tUseridStaff.clear();
        tNamaStaff.clear();
        tPassStaff.clear();
    }

    private void clearMan() {

        tUseridMan.clear();
        tNamaMan.clear();
        tPassMan.clear();
    }

    private final void openStaff(Event e) throws IOException {
        App.setRoot("staffAdm");
    }

    private final void openMan(Event e) throws IOException {
        App.setRoot("managerAdm");
    }
}