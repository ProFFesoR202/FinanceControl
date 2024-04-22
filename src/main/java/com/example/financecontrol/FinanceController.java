package com.example.financecontrol;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.DoubleStringConverter;

import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;

public class FinanceController {

    @FXML
    private VBox incomesVBox;

    @FXML
    private VBox expensesVBox;

    @FXML
    private VBox goalsVBox;

    @FXML
    public void initialize() {
        TableView<Incomes> incomesTable = createIncomesTableView();

        Button addIncomesButton = new Button("Создать");
        addIncomesButton.setOnAction(e -> ButtonsController.showAddIncomeDialog(incomesTable.getItems()));
        Button removeIncomesButton = new Button("Удалить");
        removeIncomesButton.setOnAction(e -> ButtonsController.showRemoveIncomeDialog(incomesTable.getItems()));
        HBox incomesHBox = new HBox(5);
        incomesHBox.setStyle("-fx-alignment: TOP-RIGHT; -fx-padding: 0 0 5 0;");
        incomesHBox.getChildren().addAll(addIncomesButton, removeIncomesButton);

        incomesVBox.getChildren().addAll(incomesHBox, incomesTable);
        incomesVBox.setPadding(new Insets(0, 5, 0, 5));

        TableView<Expenses> expensesTable = createExpensesTableView();

        Button addExpensesButton = new Button("Создать");
        addExpensesButton.setOnAction(e -> ButtonsController.showAddExpenseDialog(expensesTable.getItems()));
        Button removeExpensesButton = new Button("Удалить");
        removeExpensesButton.setOnAction(e -> ButtonsController.showRemoveExpenseDialog(expensesTable.getItems()));
        HBox expensesHBox = new HBox(5);
        expensesHBox.setStyle("-fx-alignment: TOP-RIGHT; -fx-padding: 0 0 5 0;");
        expensesHBox.getChildren().addAll(addExpensesButton, removeExpensesButton);

        expensesVBox.getChildren().addAll(expensesHBox, expensesTable);
        expensesVBox.setPadding(new Insets(0, 5, 0, 5));

        TableView<FinanceGoal> goalsTable = createGoalsTableView();

        Button addGoalsButton = new Button("Создать");
        addGoalsButton.setOnAction(e -> ButtonsController.showAddGoalDialog(goalsTable.getItems()));
        Button removeGoalsButton = new Button("Удалить");
        removeGoalsButton.setOnAction(e -> ButtonsController.showRemoveGoalDialog(goalsTable.getItems()));
        HBox goalsHBox = new HBox(5);
        goalsHBox.setStyle("-fx-alignment: TOP-RIGHT; -fx-padding: 0 0 5 0;");
        goalsHBox.getChildren().addAll(addGoalsButton, removeGoalsButton);

        goalsVBox.getChildren().addAll(goalsHBox, goalsTable);
        goalsVBox.setPadding(new Insets(0, 5, 0, 5));
    }

    private TableView<Incomes> createIncomesTableView() {
        TableView<Incomes> table = new TableView<>();
        ObservableList<Incomes> incomes = FXCollections.observableArrayList(
                new Incomes("Зарплата", new Date(), "Аванс", 40000.0),
                new Incomes("Зарплата", new Date(), "Зарплата", 50000.0),
                new Incomes("Другое", new Date(), "Mr. Kondratev", 15000.0)
        );

        TableColumn<Incomes, Number> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setStyle("-fx-alignment: CENTER;");
        id.setMaxWidth(50);
        id.setMinWidth(50);

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

        table.getColumns().addAll(id, category, date, comment, amount);
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

        TableColumn<Expenses, Number> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setStyle("-fx-alignment: CENTER;");
        id.setMaxWidth(50);
        id.setMinWidth(50);

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

        table.getColumns().addAll(id, category, date, comment, amount);
        table.setItems(expenses);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return table;
    }

    private TableView<FinanceGoal> createGoalsTableView() {
        TableView<FinanceGoal> table = new TableView<>();
        ObservableList<FinanceGoal> goals = FXCollections.observableArrayList(
                new FinanceGoal(new SimpleStringProperty("Макбук"), new SimpleDoubleProperty(120000.0), LocalDate.of(2024, 6, 1)),
                new FinanceGoal(new SimpleStringProperty("Обновление компьютера"), new SimpleDoubleProperty(100000.0), LocalDate.of(2024, 7, 1))
        );
        table.setEditable(true);

        TableColumn<FinanceGoal, Number> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setStyle("-fx-alignment: CENTER;");
        id.setMaxWidth(50);
        id.setMinWidth(50);

        TableColumn<FinanceGoal, String> name = new TableColumn<>("Название");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(
                (TableColumn.CellEditEvent<FinanceGoal, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
                }
        );

        TableColumn<FinanceGoal, Double> amount = new TableColumn<>("Сумма");
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        amount.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        amount.setOnEditCommit(
                (TableColumn.CellEditEvent<FinanceGoal, Double> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setAmount(t.getNewValue());
                }
        );
        amount.setStyle("-fx-alignment: CENTER;");

        TableColumn<FinanceGoal, LocalDate> deadline = new TableColumn<>("Дедлайн");
        deadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        deadline.setCellFactory(col -> new DatePickerCell());
        deadline.setStyle("-fx-alignment: CENTER;");

        TableColumn<FinanceGoal, String> status = new TableColumn<>("Статус");
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        status.setCellFactory(TextFieldTableCell.forTableColumn());
        status.setOnEditCommit(
                (TableColumn.CellEditEvent<FinanceGoal, String> t) -> {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setStatus(t.getNewValue());
                }
        );
        status.setStyle("-fx-alignment: CENTER;");

        table.getColumns().addAll(id, name, amount, deadline, status);
        table.setItems(goals);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        return table;
    }

}

