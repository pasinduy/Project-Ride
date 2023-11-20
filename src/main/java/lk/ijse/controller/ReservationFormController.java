package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.PassengerDto;
import lk.ijse.dto.Tm.ReservationTm;
import lk.ijse.dto.TrainDto;
import lk.ijse.model.PassengerModel;
import lk.ijse.model.PlaceReservationModel;
import lk.ijse.model.ReservationModel;
import lk.ijse.model.TrainModel;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationFormController {

    public JFXTextField txtId;
    public JFXTextField txtPassengerID;
    public JFXTextField txtTrainID;
    public TableView tblReservation;
    public TableColumn colTicketID;
    public TableColumn colPassengerID;
    public TableColumn <?,?>colTrainID;

    public AnchorPane root;
    public Label lblReservationId;
    public JFXComboBox passengerId;
    public JFXDatePicker lblOrderDate;
    public Label lblSeatsAvailable;
    public Label lblUnitPrice;
    public Label lblType;
    public Label lblNetTotal;
    public JFXComboBox TrainId;
    public TableColumn colTrainId;
    public TableColumn colType;
    public TableColumn colNoOfSeats;
    public TableColumn colUnitPrice;
    public TableColumn <?,?>colTotal;
    public TableColumn colAction;
    public JFXButton btnAddToCart;
    public TableView tblOrderCart;
    public TextField txtQty;
    public Label lblDate;
    public Label passengerName;

    private PassengerModel passengerModel = new PassengerModel();
    private ReservationModel reservationModel = new ReservationModel();
    private TrainModel trainModel = new TrainModel();
    private PlaceReservationModel placeReservationModel = new PlaceReservationModel();
    private ObservableList<ReservationTm> obList = FXCollections.observableArrayList();

    public void btnNewPassengerOnAction(ActionEvent actionEvent) throws IOException {
        Parent anchorPane = FXMLLoader.load(getClass().getResource("/view/passenger_form.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = new Stage();
        stage.setTitle("Passenger Manage");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    private void setRemoveBtnAction(Button btn) {
        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if (type.orElse(no) == yes) {
                int focusedIndex = tblOrderCart.getSelectionModel().getSelectedIndex();

                obList.remove(focusedIndex);
                tblOrderCart.refresh();
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        if(tblOrderCart.getItems()!=null && tblOrderCart.getItems().size()!=0){
            double total = 0;
            for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
                total += (double) colTotal.getCellData(i);
            }
            lblNetTotal.setText(String.valueOf(total));
        }else{
            new Alert(Alert.AlertType.ERROR,"Cart is empty!").show();

        }    }

    public void initialize() {
        setCellValueFactory();
        generateNextOrderId();
        loadPassengerIds();
        loadTrainIds();
        setDate();
    }

    private void setDate() {
        lblDate.setText(LocalDate.now().toString());
    }

    private void loadPassengerIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<PassengerDto> itemDtos = passengerModel.getAllPassengers();

            for (PassengerDto dto : itemDtos) {
                obList.add(dto.getId());
            }
            passengerId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadTrainIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<TrainDto> itemDtos = TrainModel.getAllTrain();

            for (TrainDto dto : itemDtos) {
                obList.add(dto.getTrainId());
            }
            TrainId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateNextOrderId() {
        try {
            String reservationId = ReservationModel.generateNextOrderId();
            lblReservationId.setText(reservationId);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void setCellValueFactory() {
    }

    private void clearFields() {
        txtId.clear();
        txtPassengerID.clear();
        txtTrainID.clear();
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/main_dashboard_form.fxml")));
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        String reservationId = lblReservationId.getText();
        LocalDate date = lblOrderDate.getValue();
        String passengerId = txtPassengerID.getText();

        List<ReservationTm> items = new ArrayList<>();
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            ReservationTm item = obList.get(i);

            items.add(item);
        }
    }

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
        String trainId = (String) TrainId.getValue();
        String type = lblType.getText();
        String qty = txtQty.getText();
        String unitPrice = lblUnitPrice.getText();
        double tot = Double.parseDouble(lblUnitPrice.getText()) * Double.parseDouble(txtQty.getText()) ;
        String total = String.valueOf(tot);
        Button btnRemove = new Button("Remove");

        setRemoveBtnAction(btnRemove);
        btnRemove.setCursor(Cursor.HAND);

        if (!obList.isEmpty()){
            for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
                if (colTrainID.getCellData(i).equals(trainId)) {
                    int col_qty = (int) colNoOfSeats.getCellData(i);
                    qty += col_qty;
                    tot = Double.parseDouble(unitPrice) * Double.parseDouble(qty);

                    obList.get(i).setNoOfSeats(qty);
                    obList.get(i).setTot(String.valueOf(tot));
                    tblOrderCart.refresh();
                    calculateTotal();
                    return;
                }
            }
        }
        var tm = new ReservationTm(trainId, type, qty, unitPrice, total, btnRemove );

        obList.add(tm);

        tblOrderCart.setItems(obList);
        calculateTotal();
        clearFields();
        txtQty.clear();
    }

    public void txtQtyOnAction(ActionEvent actionEvent) {
        btnAddToCartOnAction(actionEvent);
    }

    public void TrainOnAction(ActionEvent actionEvent) {
        String code = (String) TrainId.getValue();

        txtQty.requestFocus();
        try {
            TrainDto dto = trainModel.searchTrain(code);
            lblType.setText(dto.getType());
            lblSeatsAvailable.setText(dto.getNoOfSeats());
            lblUnitPrice.setText(dto.getTicketPrice());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void passengerOnAction(ActionEvent actionEvent) {
        String id = (String) passengerId.getValue();

        try {
            PassengerDto dto = passengerModel.searchPassenger(id);
            passengerName.setText(dto.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
