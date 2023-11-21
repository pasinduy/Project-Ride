package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DeliveryFormController {

        @FXML
        private AnchorPane root;

        @FXML
        private Label lblDeliveryID;

        @FXML
        private JFXComboBox<?> cmbPassengerId;

        @FXML
        private JFXComboBox<?> cmbTrainId;

        @FXML
        private TextField txtWeight;

        @FXML
        private TableView<?> tblOrderCart;

        @FXML
        private TableColumn<?, ?> colTrainId;

        @FXML
        private TableColumn<?, ?> colType;

        @FXML
        private TableColumn<?, ?> colUnitPrice;

        @FXML
        private TableColumn<?, ?> colTotal;

        @FXML
        private TableColumn<?, ?> colAction;

        @FXML
        private JFXButton btnAddToCart;

        @FXML
        private Label lblNetTotal;

        @FXML
        private Label lblDate;

        @FXML
        private Label passengerName;

        @FXML
        private DatePicker lblDeliveryDate;

        @FXML
        void TrainOnAction(ActionEvent event) {

        }

        @FXML
        void btnAddToCartOnAction(ActionEvent event) {

        }

        @FXML
        void btnBackOnAction(ActionEvent event) {

        }

        @FXML
        void btnCheckSchedule(ActionEvent event) {

        }

        @FXML
        void btnNewPassengerOnAction(ActionEvent event) throws IOException {
            Parent anchorPane = FXMLLoader.load(getClass().getResource("/view/passenger_add_form.fxml"));
            Scene scene = new Scene(anchorPane);

            Stage stage = new Stage();
            stage.setTitle("Passenger Manage");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

        @FXML
        void btnPlaceOrderOnAction(ActionEvent event) throws IOException {
            Parent anchorPane = FXMLLoader.load(getClass().getResource("/view/schedule_form.fxml"));
            Scene scene = new Scene(anchorPane);

            Stage stage = new Stage();
            stage.setTitle("Passenger Manage");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

        @FXML
        void passengerOnAction(ActionEvent event) {

        }

        @FXML
        void txtWeightOnAction(ActionEvent event) {

        }
    }
