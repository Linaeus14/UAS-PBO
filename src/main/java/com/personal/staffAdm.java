package com.personal;

import javafx.event.Event;
import javafx.fxml.FXML;

import java.io.IOException;

import com.personal.model.data.staff;

public class staffAdm extends inputAdm {

    @FXML
    void bTambahClick(Event event) {

        if (check()) {
            info.showAndWait();
        } else {
            staff staff = new staff(
                tUserid.getText(),
                tPass.getText(),
                tNama.getText(), 
                null,
                "staff"
            );

            if (!staff.writeData()) {
                info.setContentText("kode sudah ada!");
                info.showAndWait();
            } else {
                try {
                    openMainAdm(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }    
}
