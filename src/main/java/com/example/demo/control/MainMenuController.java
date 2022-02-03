package com.example.demo.control;
/**
 * Класс контроллер для главного меню,
 * где осуществляется выбор и работа с имеющимися файлами
 */


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import com.example.demo.TableEditorApplication;
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
    private HashMap<String,String> filesOfTableList;
    private String sourceToOpen;
    private Image opener;  /** Имейдж объект, который передаётся параметром на вызов окна-редактора*/

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
        Stage pr = (Stage) exitBtn.getScene().getWindow(); //TODO (TODO SCENE)
        pr.setScene(scene);
    }



    /** Отвечает за открытие предпросмотра выбранного из списка стола по кнопке Load*/   //TODO Если из списка слева ничего не выбрано, то кидает исключение, надо обработать
    public void onLoadTableBtnClick() throws MalformedURLException {
        tablesList.refresh();
        sourceToOpen = tablesList.getSelectionModel().getSelectedItems().toString();
        StringBuilder sb = new StringBuilder(sourceToOpen);              //TODO Аналогично тудухе выше, понять какого черта оно работает и сделать по-человечески
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        sourceToOpen = sb.toString();
        Path imageFile = Paths.get(filesOfTableList.get(sourceToOpen));
        opener = new Image(imageFile.toUri().toURL().toExternalForm());
        tableMapView.setImage(opener);
    }

    /** Открывает окошко редактирования стола, в будущем должен научиться передавать параметром Image объект стола*/ //TODO Как и выше, черт знает как оно заработало
    public void onEditButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TableEditorApplication.class.getResource("editImageMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 464);
        Stage pr = (Stage) editTableBtn.getScene().getWindow();   //TODO (TODO SCENE)
        pr.setScene(scene);
    }
}
