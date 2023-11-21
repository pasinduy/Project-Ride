package lk.ijse.controller;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainDashboardControllerForm {
    public Label lblTime;
    public Label lblDate;
    public AnchorPane root;

    public void initialize() {
        lblTime.setText(new SimpleDateFormat("hh:mm:ss a").format(new Time(System.currentTimeMillis())));
        lblDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
    }
}
