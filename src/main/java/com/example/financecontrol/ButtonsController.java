package com.example.financecontrol;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class ButtonsController {

    //TODO Сделать обязательные поля через проверку на пустоту, обводить поля красным цветом
    public static void showAddIncomeDialog(ObservableList<Incomes> incomes) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Создать доход");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(Stage.getWindows().get(0));
        dialogStage.setWidth(320);
        dialogStage.setHeight(280);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        TextField categoryField = new TextField();
        TextField commentField = new TextField();
        TextField amountField = new TextField();

        Button doneButton = new Button("Готово");
        doneButton.setOnAction(e -> {
            try{
                String category = categoryField.getText();
                Date date = new Date();
                String comment = commentField.getText();
                double amount = Double.parseDouble(amountField.getText());

                incomes.add(new Incomes(category, date, comment, amount));
                dialogStage.close();
            } catch (NumberFormatException ex) {
                amountField.setText("Введите корректное число");
            }
        });

        vbox.getChildren().addAll(
                new Label("Категория:"), categoryField,
                new Label("Комментарий:"), commentField,
                new Label("Сумма:"), amountField,
                doneButton
        );

        Scene scene = new Scene(vbox);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

    public static void showRemoveIncomeDialog(ObservableList<Incomes> incomes) {
        if(incomes.isEmpty()) {
            return;
        }
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Удалить доход");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(Stage.getWindows().get(0));
        dialogStage.setWidth(320);
        dialogStage.setHeight(280);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        TextField id = new TextField();

        Button doneButton = new Button("Готово");
        doneButton.setOnAction(e -> {
            try{
                int index = Integer.parseInt(id.getText());
                if(index < 1) {
                    throw new Exception("Индекс вне диапазона");
                }
                incomes.stream().filter(income -> income.getId() == index).findAny().ifPresent(incomes::remove);
                dialogStage.close();
            } catch (Exception ex) {
                id.setText("Введите корректное число");
            }
        });

        vbox.getChildren().addAll(
                new Label("ID:"), id,
                doneButton
        );
        Scene scene = new Scene(vbox);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }
    
    public static void showAddExpenseDialog(ObservableList<Expenses> expenses) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Создать расход");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(Stage.getWindows().get(0));
        dialogStage.setWidth(320);
        dialogStage.setHeight(280);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        TextField categoryField = new TextField();
        TextField commentField = new TextField();
        TextField amountField = new TextField();

        Button doneButton = new Button("Готово");
        doneButton.setOnAction(e -> {
            try{
                String category = categoryField.getText();
                Date date = new Date();
                String comment = commentField.getText();
                double amount = Double.parseDouble(amountField.getText());

                expenses.add(new Expenses(category, date, comment, amount));
                dialogStage.close();
            } catch (NumberFormatException ex) {
                amountField.setText("Введите корректное число");
            }
        });

        vbox.getChildren().addAll(
                new Label("Категория:"), categoryField,
                new Label("Комментарий:"), commentField,
                new Label("Сумма:"), amountField,
                doneButton
        );

        Scene scene = new Scene(vbox);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }
    
    public static void showRemoveExpenseDialog(ObservableList<Expenses> expenses) {
        if(expenses.isEmpty()) {
            return;
        }
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Удалить расход");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(Stage.getWindows().get(0));
        dialogStage.setWidth(320);
        dialogStage.setHeight(280);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        TextField id = new TextField();

        Button doneButton = new Button("Готово");
        doneButton.setOnAction(e -> {
            try{
                int index = Integer.parseInt(id.getText());
                if(index < 1) {
                    throw new Exception("Индекс вне диапазона");
                }
                expenses.stream().filter(income -> income.getId() == index).findAny().ifPresent(expenses::remove);
                dialogStage.close();
            } catch (Exception ex) {
                id.setText("Введите корректное число");
            }
        });

        vbox.getChildren().addAll(
                new Label("ID:"), id,
                doneButton
        );
        Scene scene = new Scene(vbox);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

    public static void showAddGoalDialog(ObservableList<FinanceGoal> goals) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Создать расход");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(Stage.getWindows().get(0));
        dialogStage.setWidth(320);
        dialogStage.setHeight(280);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        DatePicker dateField = new DatePicker();
        TextField nameField = new TextField();
        TextField amountField = new TextField();

        Button doneButton = new Button("Готово");
        doneButton.setOnAction(e -> {
            try {
                LocalDate date = dateField.getValue();
                SimpleStringProperty name = new SimpleStringProperty(nameField.getText());
                SimpleDoubleProperty amount = new SimpleDoubleProperty(Double.parseDouble(amountField.getText()));

                goals.add(new FinanceGoal(name, amount, date));
                dialogStage.close();
            } catch (NumberFormatException ex) {
                amountField.setText("Введите корректное число");
            }
        });

        vbox.getChildren().addAll(
                new Label("Имя цели:"), nameField,
                new Label("Сумма:"), amountField,
                new Label("Крайняя дата:"), dateField,
                doneButton
        );

        Scene scene = new Scene(vbox);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

    public static void showRemoveGoalDialog(ObservableList<FinanceGoal> goals) {
        if(goals.isEmpty()) {
            return;
        }
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Удалить расход");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(Stage.getWindows().get(0));
        dialogStage.setWidth(320);
        dialogStage.setHeight(280);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        TextField id = new TextField();

        Button doneButton = new Button("Готово");
        doneButton.setOnAction(e -> {
            try{
                int index = Integer.parseInt(id.getText());
                if(index < 1) {
                    throw new Exception("Индекс вне диапазона");
                }
                goals.stream().filter(income -> income.getId() == index).findAny().ifPresent(goals::remove);
                dialogStage.close();
            } catch (Exception ex) {
                id.setText("Введите корректное число");
            }
        });

        vbox.getChildren().addAll(
                new Label("ID:"), id,
                doneButton
        );
        Scene scene = new Scene(vbox);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }
}
