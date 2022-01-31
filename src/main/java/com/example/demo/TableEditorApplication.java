package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

/** Контроллер для окна редактирования столов */
//TODO вместо текстового редактора сделать графический и добавить возможность свободного таскания предметов в модуле админа
public class TableEditorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TableEditorApplication.class.getResource("signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 250);

        stage.setTitle("TableEditor");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}