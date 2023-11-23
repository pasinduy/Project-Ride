package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AttendanceFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtEmployeeID;

    @FXML
    private JFXTextField txtMonth;

    @FXML
    private JFXTextField txtAttendanceID;

    @FXML
    private JFXTextField txtDate;

    @FXML
    private JFXTextField txtStatus;

    @FXML
    private TableView<?> tblPassenger;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colAttendanceID;

    @FXML
    private TableColumn<?, ?> colMonth;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    void btnOnActionBack(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/main_dashboard_form.fxml")));
    }

    public void initialize() {
        setCellValueFactory();
        loadAllAttendance();
        loadTrainId();
    }

    private void setCellValueFactory() {
        colID.setCellValueFactory(new PropertyValueFactory<>("trainId"));
        colAttendanceID.setCellValueFactory(new PropertyValueFactory<>("attendanceId"));

    }

    private void loadAllAttendance() {

    }

    private void loadTrainId() {
    }

    @FXML
    void btnOnActionClear(ActionEvent event) {

    }

    @FXML
    void btnOnActionAdd(ActionEvent event) {

    }

    @FXML
    void btnOnActionDelete(ActionEvent event) {

    }

    @FXML
    void btnOnActionUpdate(ActionEvent event) {

    }

    @FXML
    void tblPassengerOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtOnActionSearch(ActionEvent event) {

    }

}

