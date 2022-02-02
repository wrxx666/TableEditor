package com.example.demo.control;

import com.example.demo.TableEditorApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


/** Контроллер для логина, много чего нужно доделывать
 *
 *  Надо замутить базу и отдельный
 *  админский модуль для создания пользователей
 */
public class SignInController {




        @FXML
        private TextField loginField;

        @FXML
        private PasswordField passwordField; //TODO прикрутить базу с паролелогинами

        @FXML
        private Button signInButton;

        public void onSignInButtonClick() throws IOException {
                loginField.appendText("LOLOLOLOLOLOL");
                FXMLLoader fxmlLoader = new FXMLLoader(TableEditorApplication.class.getResource("mainMenu.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 876, 451);
                Stage pr = (Stage) signInButton.getScene().getWindow();
                pr.setScene(scene);
        }

}
