package com.example.financecontrol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Expenses implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int count = 1;
    private int id;
    private String category;
    private Date date;
    private String comment;
    private double amount;

    public Expenses (String category, Date date, String comment, double amount) {
        this.category = category;
        this.date = date;
        this.comment = comment;
        this.amount = amount;
        this.id = count++;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy", Locale.forLanguageTag("ru"));
        return formatter.format(date);
    }

    public LocalDate getOriginalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.forLanguageTag("ru"));
        return LocalDate.parse(getDate(), formatter);
    }

    public String getComment() {
        return comment;
    }

    public double getAmount() {
        return amount;
    }

    public void setCount(int count) {
        Expenses.count = count;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Сериализует стандартные поля
        out.writeInt(id);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Десериализует стандартные поля
        id = in.readInt();
        Expenses.count = Math.max(Expenses.count, id + 1);
    }
}
