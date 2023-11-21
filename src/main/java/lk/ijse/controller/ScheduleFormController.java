package lk.ijse.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ScheduleFormController {
    public AnchorPane root;
    public JFXTextField txtStartStation;
    public JFXTextField txtId;
    public JFXTextField txtEndStation;
    public TableView tblPassenger;
    public TableColumn colEndingStation;
    public TableColumn colID;
    public TableColumn colTrainId;
    public TableColumn colStartStation;
    public TableColumn colDate;
    public TableColumn colStartTime;
    public TableColumn colEndTime;
    public ComboBox ComboTrainId;
    public JFXDatePicker txtDate;
    public JFXTimePicker txtStartTime;
    public JFXTimePicker txtEndTime;

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/main_dashboard_form.fxml")));
    }

    public void txtOnActionSearch(ActionEvent actionEvent) {
    }

    public void tblScheduleOnMouseClicked(MouseEvent mouseEvent) {
    }

    public void btnOnActionAdd(ActionEvent actionEvent) {
    }

    public void btnOnActionUpdate(ActionEvent actionEvent) {
    }

    public void btnOnActionClear(ActionEvent actionEvent) {
    }

    public void btnOnActionDelete(ActionEvent actionEvent) {
    }

    public void btnOnActionReport(ActionEvent actionEvent) {
    }
}
