package com.example.financecontrol;

import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class StyleSettings {

    public static void bindProgressBarSize(Scene scene, ProgressBar progressBar) {
        progressBar.prefWidthProperty().bind(scene.widthProperty().multiply(0.35));  // Занимает 50% ширины сцены
        progressBar.prefHeightProperty().bind(scene.heightProperty().multiply(0.06)); // Высота равна 5% высоты сцены
    }

    public static void styleProgressBar(ProgressBar progressBar) {
        progressBar.setStyle("-fx-accent: green; -fx-border-color: darkblue; -fx-border-radius: 5px; -fx-border-width: 2px; -fx-border-style: solid;"); // Основной цвет ProgressBar
        // Дополнительное настройка стиля для красного цвета при определённых условиях
        progressBar.progressProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.doubleValue() < 0.3) {
                progressBar.setStyle("-fx-color: red; -fx-border-color: darkblue; -fx-border-radius: 5px; -fx-border-width: 2px; -fx-border-style: solid;");  // Если прогресс менее 30%, цвет красный
            } else {
                progressBar.setStyle("-fx-accent: green; -fx-border-color: darkblue; -fx-border-radius: 5px; -fx-border-width: 2px; -fx-border-style: solid;"); // Иначе тёмно-синий
            }
        });
    }

    public static void bindCurrencyFontSize(Label label) {
        Scene scene = label.getScene();
        if (scene == null) {
            label.sceneProperty().addListener((obs, oldScene, newScene) -> {
                if (newScene != null) {
                    label.styleProperty().bind(Bindings.concat(
                            "-fx-font-size: ",
                            newScene.widthProperty().add(newScene.heightProperty()).divide(70).asString(),
                            ";", "-fx-border-color: darkblue; -fx-border-radius: 5px; -fx-border-width: 2px;"
                    ));
                }
            });
        } else {
            label.styleProperty().bind(Bindings.concat(
                    "-fx-font-size: ",
                    scene.widthProperty().add(scene.heightProperty()).divide(70).asString(),
                    ";", "-fx-border-color: darkblue; -fx-border-radius: 5px; -fx-border-width: 2px;"
            ));
        }
    }

    public static void bindLabelFontSize(Label label) {
        Scene scene = label.getScene();
        if (scene == null) {
            label.sceneProperty().addListener((obs, oldScene, newScene) -> {
                if (newScene != null) {
                    label.styleProperty().bind(Bindings.concat(
                            "-fx-font-size: ",
                            newScene.widthProperty().add(newScene.heightProperty()).divide(58).asString(),
                            ";", "-fx-font-weight: bold;"
                    ));
                }
            });
        } else {
            label.styleProperty().bind(Bindings.concat(
                    "-fx-font-size: ",
                    scene.widthProperty().add(scene.heightProperty()).divide(58).asString(),
                    ";", "-fx-font-weight: bold;"
            ));
        }
    }
}
