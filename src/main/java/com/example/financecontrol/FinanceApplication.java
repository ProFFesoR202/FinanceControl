package com.example.financecontrol;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FinanceApplication extends Application {
    //TODO: Навалить стиля
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FinanceApplication.class.getResource("main-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 540);
        stage.setMinHeight(540);
        stage.setMinWidth(960);
        stage.setTitle("Контроль финансов");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e -> {
            try {
                FinanceController.saveData();
            } catch (IOException ex) {
                e.consume();
                System.out.println(ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}