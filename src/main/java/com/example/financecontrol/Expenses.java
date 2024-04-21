package com.example.financecontrol;

import java.text.DateFormat;
import java.util.Date;

public class Expenses {
    private String category;
    private Date date;
    private String comment;
    private double amount;

    public Expenses (String category, Date date, String comment, double amount) {
        this.category = category;
        this.date = date;
        this.comment = comment;
        this.amount = amount;
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
