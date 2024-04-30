package com.example.financecontrol;

import javafx.scene.control.TableCell;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerCell extends TableCell<FinanceGoal, LocalDate> {
    private DatePicker datePicker;

    public DatePickerCell() {
        datePicker = new DatePicker();
        datePicker.setConverter(new StringConverter<LocalDate>() {
            String pattern = "dd MMM yyyy г.";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            {
                datePicker.setPromptText(pattern.toLowerCase());
            }

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });

        datePicker.editableProperty().bind(editableProperty());
        datePicker.setOnShowing(e -> commitEdit(datePicker.getValue()));
        datePicker.valueProperty().addListener((obs, oldVal, newVal) -> commitEdit(newVal));
    }

    @Override
    protected void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setGraphic(datePicker);
            if (item != null) {
                datePicker.setValue(item);
            }
        }
    }
}

