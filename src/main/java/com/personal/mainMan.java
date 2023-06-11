package com.personal;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import com.personal.model.data.pembelian;

public class mainMan extends pesananController {
    
    @FXML
    private TextField tTotal;
    
    public void initialize() {
        
        setStrip();
        tabOnR();
    }

    @Override
    protected void tabOnR() {

        pembelian pembelian = new pembelian();
        pembelian.readDone(tablePembelian);

        int total = 0;
            for (int i = 0;i < tablePembelian.getItems().size();i++) {
                total += Integer.parseInt(tablePembelian.getItems().get(i).get(1));
            }
        tTotal.setText(Integer.toString(total));
    }
}