package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController {




        @FXML
        private TextField loginField;

        @FXML
        private PasswordField passwordField;

        @FXML
        private Button signInButton;

        @FXML
        private ImageView tableEditorImage;

        public void onSignInButtonClick() throws IOException {
                loginField.appendText("LOLOLOLOLOLOL");
                FXMLLoader fxmlLoader = new FXMLLoader(TableEditorApplication.class.getResource("mainMenu.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 876, 451);
                Stage pr = (Stage) signInButton.getScene().getWindow();
                pr.setScene(scene);
        }

}
