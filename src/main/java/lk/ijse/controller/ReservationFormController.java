package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.PassengerDto;
import lk.ijse.dto.ReservationDto;
import lk.ijse.model.ReservationModel;

import java.io.IOException;

public class ReservationFormController {

    public JFXTextField txtId;
    public JFXTextField txtPassengerID;
    public JFXTextField txtTrainID;
    public TableView tblReservation;
    public TableColumn colTicketID;
    public TableColumn colPassengerID;
    public TableColumn colTrainID;

    public AnchorPane root;
    public ReservationModel model = new ReservationModel();

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/mainDashboard_form.fxml")));
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();

    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String passengerID = txtPassengerID.getText();
        String trainID = txtTrainID.getText();

        var dto = new ReservationDto(id, passengerID, trainID);

        try {
            boolean isSaved = model.addReservation(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearFields() {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
