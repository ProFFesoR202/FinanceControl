package com.example.financecontrol;

import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.Currency;
import java.util.Date;

public class FinanceController {

    @FXML
    private VBox incomesVBox;

    @FXML
    private VBox expensesVBox;

    @FXML
    public void initialize() {
        TableView<Incomes> incomesTable = createIncomesTableView();
        incomesVBox.getChildren().add(incomesTable);
        incomesVBox.setPadding(new Insets(0, 5, 0, 5));
        TableView<Expenses> expensesTable = createExpensesTableView();
        expensesVBox.getChildren().add(expensesTable);
        expensesVBox.setPadding(new Insets(0, 5, 0, 5));
    }

    private TableView<Incomes> createIncomesTableView() {
        TableView<Incomes> table = new TableView<>();
        ObservableList<Incomes> incomes = FXCollections.observableArrayList(
                new Incomes("Зарплата", new Date(), "Аванс", 40000.0),
                new Incomes("Зарплата", new Date(), "Зарплата", 50000.0),
                new Incomes("Другое", new Date(), "Mr. Kondratev", 15000.0)
        );

        TableColumn<Incomes, String> category = new TableColumn<>("Категория");
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        category.setStyle("-fx-alignment: CENTER;");

        TableColumn<Incomes, String> date = new TableColumn<>("Дата");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        date.setStyle("-fx-alignment: CENTER;");

        TableColumn<Incomes, String> comment = new TableColumn<>("Комментарий");
        comment.setCellValueFactory(new PropertyValueFactory<>("comment"));

        TableColumn<Incomes, Currency> amount = new TableColumn<>("Сумма");
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        amount.setStyle("-fx-alignment: CENTER;");

        table.getColumns().addAll(category, date, comment, amount);
        table.setItems(incomes);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return table;
    }

    private TableView<Expenses> createExpensesTableView() {
        TableView<Expenses> table = new TableView<>();
        ObservableList<Expenses> expenses = FXCollections.observableArrayList(
                new Expenses("Кредит", new Date(), "Призыва нет", 7000.0),
                new Expenses("Кредит", new Date(), "SkillBox", 4500.0),
                new Expenses("Кредит", new Date(), "Призыва нет", 5500.0),
                new Expenses("Подписки", new Date(), "Яндекс, Faceit, Warmup Servers", 2000.0)
        );

        TableColumn<Expenses, String> category = new TableColumn<>("Категория");
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        category.setStyle("-fx-alignment: CENTER;");

        TableColumn<Expenses, String> date = new TableColumn<>("Дата");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        date.setStyle("-fx-alignment: CENTER;");

        TableColumn<Expenses, String> comment = new TableColumn<>("Комментарий");
        comment.setCellValueFactory(new PropertyValueFactory<>("comment"));

        TableColumn<Expenses, Currency> amount = new TableColumn<>("Сумма");
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        amount.setStyle("-fx-alignment: CENTER;");

        table.getColumns().addAll(category, date, comment, amount);
        table.setItems(expenses);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return table;
    }
}

