package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.PassengerDto;
import lk.ijse.dto.Tm.PassengerTm;
import lk.ijse.model.PassengerModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PassengerFormController {
    public AnchorPane root;
    public JFXTextField txtId;
    public JFXTextField txtAge;
    public JFXTextField txtName;
    public JFXTextField txtGender;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAge;
    public TableColumn colGender;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableView<PassengerTm> tblPassenger;

    private PassengerModel model = new PassengerModel();

    public void initialize(){
        setCellValueFactory();
        loadAllPassengers();
    }

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Dashboard");
        stage.show();
    }

    public void btnOnActionAdd(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String age = txtAge.getText();
        String gender = txtGender.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        var dto = new PassengerDto(id, name, age, gender, address, contact);

        try {
            boolean isSaved = model.addPassenger(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnOnActionUpdate(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String age = txtAge.getText();
        String gender = txtGender.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        var dto = new PassengerDto(id, name, age, gender, address, contact);

        try {
            boolean isUpdated = model.updatePassenger(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
                clearFields();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnOnActionClear(ActionEvent actionEvent) {
        clearFields();
    }

    public void btnOnActionDelete(ActionEvent actionEvent) {
        String id = txtId.getText();

        try {
            boolean isDeleted = model.deletePassenger(id);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    private void loadAllPassengers() {
        var model = new PassengerModel();

        ObservableList<PassengerTm> obList = FXCollections.observableArrayList();
        try {
            List<PassengerDto> dtoList = model.getAllPassengers();

            for (PassengerDto dto : dtoList) {
                obList.add(
                        new PassengerTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getAge(),
                                dto.getGender(),
                                dto.getAddress(),
                                dto.getContact()
                        )
                );
            }
            tblPassenger.setItems(obList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }

    private void clearFields() {
        txtId.clear();
        txtName.clear();
        txtAge.clear();
        txtGender.clear();
        txtAddress.clear();
        txtContact.clear();
    }

    public void txtOnActionSearch(ActionEvent actionEvent) {
        String id = txtId.getText();

        try {
            PassengerDto dto = model.searchPassenger(id);
            if (dto != null) {
                txtId.setText(dto.getId());
                txtName.setText(dto.getName());
                txtAge.setText(dto.getAge());
                txtGender.setText(dto.getGender());
                txtAddress.setText(dto.getAddress());
                txtContact.setText(dto.getContact());
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
