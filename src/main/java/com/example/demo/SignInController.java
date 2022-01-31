package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SignInController {




        @FXML
        private TextField loginField;

        @FXML
        private PasswordField passwordField;

        @FXML
        private Button signInButton;

        @FXML
        private ImageView tableEditorImage;

        public void onSignInButtonClick(){
                loginField.appendText("LOLOLOLOLOLOL");
        }

}
