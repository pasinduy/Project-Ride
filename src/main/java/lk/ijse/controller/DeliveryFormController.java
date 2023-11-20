package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DeliveryFormController {
    public AnchorPane root;

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/main_dashboard_form.fxml")));
    }
}
