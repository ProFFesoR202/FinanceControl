package com.example.financecontrol;

import java.text.DateFormat;
import java.util.Date;

public class Expenses {
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
        return DateFormat.getDateInstance().format(date);
    }

    public String getComment() {
        return comment;
    }

    public double getAmount() {
        return amount;
    }

}
