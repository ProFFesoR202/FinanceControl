package com.example.financecontrol;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Validates {
    public static boolean validateInput(TextField... fields) {
        int count = 0;
        for (TextField field : fields) {
            if (field.getText().isEmpty()) {
                count++;
                field.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-border-radius: 5px;");
            }else{
                field.setStyle("");
            }
        }

        if (count > 0) {
            return false;
        }
        return true;
    }

    public static boolean validateInput(ComboBox<?> comboBox, TextField... fields) {
        int count = 0;
        for (TextField field : fields) {
            if (field.getText().isEmpty()) {
                count++;
                field.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-border-radius: 5px;");
            }else{
                field.setStyle("");
            }
        }
        if(comboBox.getValue() == null) {
            count++;
            comboBox.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-border-radius: 5px;");
        }else{
            comboBox.setStyle("");
        }

        if (count > 0) {
            return false;
        }
        return true;
    }

    public static boolean validateInput(DatePicker datePicker, TextField... fields) {
        int count = 0;
        for (TextField field : fields) {
            if (field.getText().isEmpty()) {
                count++;
                field.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-border-radius: 5px;");
            }else{
                field.setStyle("");
            }
        }
        if(datePicker.getValue() == null) {
            count++;
            datePicker.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-border-radius: 5px;");
        }else{
            datePicker.setStyle("");
        }

        if (count > 0) {
            return false;
        }
        return true;
    }
}
