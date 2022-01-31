package com.example.demo;
/**
 * Класс контроллер для главного меню,
 * где осуществляется выбор и работа с имеющимися файлами
 */


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;




public class MainMenuController {
    @FXML
    private ResourceBundle resources; //TODO Выяснить какого черта эта штука здесь делает

    private HashMap<String,String> filesOfTableList;
    private String sourceToOpen;
    private Image opener;  /** Имейдж объект, который передаётся параметром на вызов окна-редактора*/

    @FXML
    private URL location; //TODO И эта штука зачем

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
    void initialize() {  //TODO Зачем ассерты тоже надо узнать
        assert deleteTableBtn != null : "fx:id=\"deleteTableBtn\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert editTableBtn != null : "fx:id=\"dwnldTableBtn\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert loadTableBtn != null : "fx:id=\"loadTableBtn\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert tableMapView != null : "fx:id=\"tableMapView\" was not injected: check your FXML file 'mainMenu.fxml'.";

        /** Временный список объектов для главного меню */
        ObservableList<String> tables = FXCollections.observableArrayList("First Floor", "Second Floor", "Summer terrace", "Roof");
        tablesList.setItems(tables);

        /** Инциализация мапы для работы "название" - путь к файлу*/        //TODO Переделать мапу в СуКеЛе и добавить функцию вставки/удаления данных из меню
        filesOfTableList = new HashMap<>();
        filesOfTableList.put("First Floor", "./src/main/resources/com/example/demo/firstFloor.png");
        filesOfTableList.put("Second Floor", "./src/main/resources/com/example/demo/tableEditor.png");
        filesOfTableList.put("Summer terrace", "./src/main/resources/com/example/demo/tableEditor.png");
        filesOfTableList.put("Roof", "./src/main/resources/com/example/demo/tableEditor.png");

    }

    /** Выводит в окошко логина*/   //TODO Понять почему оно заработало и сделать по-человечески вместо костыльной шляпы
    public void onExitBtnClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TableEditorApplication.class.getResource("signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 250);
        Stage pr = (Stage) exitBtn.getScene().getWindow();
        pr.setScene(scene);
    }
    /** Отвечает за открытие предпросмотра выбранного из списка стола по кнопке Load*/
    public void onLoadTableBtnClick() throws MalformedURLException {
        tablesList.refresh();
        sourceToOpen = tablesList.getSelectionModel().getSelectedItems().toString();
        StringBuilder sb = new StringBuilder(sourceToOpen);              //TODO Аналогично тудухе выше, понять какого черта оно работает и сделать по-человечески
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        sourceToOpen = sb.toString();
        Path imageFile = Paths.get(filesOfTableList.get(sourceToOpen));
        opener = new Image(imageFile.toUri().toURL().toExternalForm());
        tableMapView.setImage(opener);
    }

    /** Открывает окошко редактирования стола, в будущем должен научиться передавать параметром Image объект стола*/
    public void onEditButtonClick() throws IOException {   //TODO Как и выше, черт знает как оно заработало
        FXMLLoader fxmlLoader = new FXMLLoader(TableEditorApplication.class.getResource("editMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 876, 451);
        Stage pr = (Stage) editTableBtn.getScene().getWindow();
        pr.setScene(scene);
    }
}
