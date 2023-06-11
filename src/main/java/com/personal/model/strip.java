package com.personal.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import com.personal.App;

public class strip {

    private final StringProperty nama = new SimpleStringProperty();
    private final StringProperty kode = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    public strip(String none) {}

    public strip() {

        setNama(App.getAkun().getNama());
        setKode(App.getAkun().getKode());
        setStatus(App.getAkun().getStatus());
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public StringProperty kodeProperty() {
        return kode;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public final String getNama() {
        return namaProperty().get();
    }

    public final String getKode() {
        return kodeProperty().get();
    }

    public final String getStatus() {
        return statusProperty().get();
    }

    public final void setNama(String nama) {
        namaProperty().set(nama);
    }

    public final void setKode(String kode) {
        kodeProperty().set(kode);
    }

    public final void setStatus(String status) {
        statusProperty().set(status);
    }
}