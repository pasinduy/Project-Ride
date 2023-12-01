package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.AttendanceDto;
import lk.ijse.dto.Tm.AttendanceTm;
import lk.ijse.model.AttendanceModel;

import java.io.IOException;
import java.util.List;

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
    private TableView<AttendanceTm> tblAttendance;

    @FXML
    private TableColumn<?, ?> colAttendanceId;
    @FXML
    public TableColumn colEmployeeID;

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
        clearFields();
    }

    private void clearFields() {
        txtAttendanceID.setText("");
        txtEmployeeID.setText("");
        txtDate.setText("");
        txtMonth.setText("");
        txtStatus.setText("");
    }

    private void setCellValueFactory() {
        colAttendanceId.setCellValueFactory(new PropertyValueFactory<>("attendanceId"));
        colEmployeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    private void loadAllAttendance() {
        String attId = txtAttendanceID.getText();

        ObservableList<AttendanceTm> observableList = FXCollections.observableArrayList();
        try{
            List<AttendanceDto> dtoList = new AttendanceModel().getAllAttendance();

            for (AttendanceDto dto : dtoList) {
                observableList.add(
                        new AttendanceTm(
                                dto.getAttendanceId(),
                                dto.getEmpId(),
                                dto.getMonth(),
                                dto.getDate(),
                                dto.getStatus()
                        )
                );
            }
            tblAttendance.setItems(observableList);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnOnActionClear(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnOnActionAdd(ActionEvent event) {
        String attId = txtAttendanceID.getText();
        String id = txtEmployeeID.getText();
        String month = txtMonth.getText();
        String date = txtDate.getText();
        String status = txtStatus.getText();

        var dto = new AttendanceDto(attId, id, month, date, status);

        var model = new AttendanceModel();

        try {
            boolean isSaved = model.addAttendance(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Attendance saved!").show();
                clearFields();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnOnActionDelete(ActionEvent event) {
        String attId = txtAttendanceID.getText();

        var model = new AttendanceModel();

        try {
            boolean isDeleted = model.deleteAttendance(attId);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Train deleted!").show();
                clearFields();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnOnActionUpdate(ActionEvent event) {
        String attId = txtAttendanceID.getText();
        String id = txtEmployeeID.getText();
        String month = txtMonth.getText();
        String date = txtDate.getText();
        String status = txtStatus.getText();

        var dto = new AttendanceDto(attId, id, month, date, status);

        var model = new AttendanceModel();

        try {
            boolean isUpdated = model.updateAttendance(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Attendance updated!").show();
                clearFields();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void tblPassengerOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtOnActionSearch(ActionEvent event) {
        String attId = txtAttendanceID.getText();

        var model = new AttendanceModel();

        try {
            AttendanceDto attendance = model.searchAttendance(attId);
            if (attendance != null) {
                txtEmployeeID.setText(attendance.getEmpId());
                txtMonth.setText(attendance.getMonth());
                txtDate.setText(attendance.getDate());
                txtStatus.setText(attendance.getStatus());
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}

