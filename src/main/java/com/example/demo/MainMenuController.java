package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.FocusModel;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import static javafx.scene.input.KeyCode.R;


public class MainMenuController {
    @FXML
    private ResourceBundle resources;

    private HashMap<String,String> filesOfTableList;
    private String sourceToOpen;
    private Image opener;

    @FXML
    private URL location;

    @FXML
    private Button deleteTableBtn;

    @FXML
    private Button editTableBtn;

    @FXML
    private ListView tablesList;

    @FXML
    private Button exitBtn;

    @FXML
    private Button loadTableBtn;

    @FXML
    private ImageView tableMapView;

    @FXML
    void initialize() {
        assert deleteTableBtn != null : "fx:id=\"deleteTableBtn\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert editTableBtn != null : "fx:id=\"dwnldTableBtn\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert loadTableBtn != null : "fx:id=\"loadTableBtn\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert tableMapView != null : "fx:id=\"tableMapView\" was not injected: check your FXML file 'mainMenu.fxml'.";
        ObservableList<String> tables = FXCollections.observableArrayList("First Floor", "Second Floor", "Summer terrace", "Roof");
        tablesList.setItems(tables);
        filesOfTableList = new HashMap<>();
        filesOfTableList.put("First Floor", "./src/main/resources/com/example/demo/firstFloor.png");
        filesOfTableList.put("Second Floor", "./src/main/resources/com/example/demo/tableEditor.png");
        filesOfTableList.put("Summer terrace", "./src/main/resources/com/example/demo/tableEditor.png");
        filesOfTableList.put("Roof", "./src/main/resources/com/example/demo/tableEditor.png");

    }

    public void onExitBtnClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TableEditorApplication.class.getResource("signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 250);
        Stage pr = (Stage) exitBtn.getScene().getWindow();
        pr.setScene(scene);
    }
    public void onLoadTableBtnClick() throws MalformedURLException {
        tablesList.refresh();
        sourceToOpen = tablesList.getSelectionModel().getSelectedItems().toString();
        StringBuilder sb = new StringBuilder(sourceToOpen);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        sourceToOpen = sb.toString();
        Path imageFile = Paths.get(filesOfTableList.get(sourceToOpen));
        opener = new Image(imageFile.toUri().toURL().toExternalForm());
        tableMapView.setImage(opener);
    }

    public void onEditButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TableEditorApplication.class.getResource("editMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 876, 451);
        Stage pr = (Stage) editTableBtn.getScene().getWindow();
        pr.setScene(scene);
    }
}
