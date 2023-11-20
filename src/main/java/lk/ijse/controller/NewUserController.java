package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.UserDto;
import lk.ijse.model.UserModel;

import java.io.IOException;

public class NewUserController {
    public AnchorPane root;
    public JFXTextField txtUsername;
    public JFXTextField txtPassword;
    public JFXTextField txtEmail;
    private UserModel model = new UserModel();

    public void EnterOnPassword() {
    }

    public void initialize(){
        txtPassword.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Enter key is pressed, perform the login action
                EnterOnPassword();
            }
        });
    }

    public void btnAddUserOnAction(ActionEvent actionEvent) {
        String email = txtEmail.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        var dto = new UserDto(email, username, password);

        try {
            boolean isSaved = model.addUser(dto);

            if (isSaved) {
                this.root.getChildren().clear();
                this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml")));
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Page");
        stage.centerOnScreen();
    }
}
