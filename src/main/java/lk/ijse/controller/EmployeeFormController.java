package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class EmployeeFormController {
    public AnchorPane root;

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/main_dashboard_form.fxml")));
    }

    public void txtOnActionSearch(ActionEvent actionEvent) {
    }

    public void tblPassengerOnMouseClicked(MouseEvent mouseEvent) {
    }

    public void btnOnActionAdd(ActionEvent actionEvent) {
    }

    public void btnOnActionUpdate(ActionEvent actionEvent) {
    }

    public void btnOnActionClear(ActionEvent actionEvent) {
    }

    public void btnOnActionDelete(ActionEvent actionEvent) {
    }
}
