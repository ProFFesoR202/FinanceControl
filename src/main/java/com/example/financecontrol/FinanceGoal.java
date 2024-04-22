package com.example.financecontrol;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class FinanceGoal {
    private static int count = 1;
    private int id;
    private SimpleStringProperty name;
    private SimpleDoubleProperty amount;
    private ObjectProperty<LocalDate> deadline;
    private SimpleStringProperty status;

    public FinanceGoal(SimpleStringProperty name, SimpleDoubleProperty amount, LocalDate deadline) {
        this.name = name;
        this.amount = amount;
        this.deadline = new SimpleObjectProperty<>(deadline);
        this.status = new SimpleStringProperty("Открытая");
        this.id = count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    public LocalDate getDeadline() {
        return deadline.get();
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline.set(deadline);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
