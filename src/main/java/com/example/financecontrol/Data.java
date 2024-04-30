package com.example.financecontrol;

import java.io.*;
import java.util.List;

public class Data {
    public static void saveDataToFile(List<?> objectData, String fileName) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(objectData);
        }
    }

    public static List<?> loadDataFromFile(String fileName) throws IOException, ClassNotFoundException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<?>) in.readObject();
        }
    }
}
