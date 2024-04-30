package com.example.financecontrol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class FinanceGoal implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int count = 1;
    private int id;
    private String name;
    private double amount;
    private LocalDate deadline;
    private String status;

    public FinanceGoal(String name, double amount, LocalDate deadline) {
        this.name = name;
        this.amount = amount;
        this.deadline = deadline;
        this.status = "Открытая";
        this.id = count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCount(int count) {
        FinanceGoal.count = count;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Сериализует стандартные поля
        out.writeInt(id);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Десериализует стандартные поля
        id = in.readInt();
        FinanceGoal.count = Math.max(FinanceGoal.count, id + 1);
    }
}
