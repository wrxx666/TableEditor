package com.example.demo.control;

import com.example.demo.TableEditorApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EditImageMenuController {
    @FXML
    private Button exitMenuBtn;
    @FXML
    void initialize() {
        assert exitMenuBtn != null : "fx:id=\"exitMenuBtn\" was not injected: check your FXML file 'editImageMenu.fxml'.";
    }

    public void onExitMenuBtnClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TableEditorApplication.class.getResource("mainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 876, 451);
        Stage pr = (Stage) exitMenuBtn.getScene().getWindow();
        pr.setScene(scene);
    }
}
