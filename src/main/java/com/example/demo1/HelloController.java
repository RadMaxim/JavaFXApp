package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    private static int countId;
    public ArrayList<Persons> personsArrayList = new ArrayList<>();


    @FXML
    private TextField parentText;
    @FXML
    private TextField childText;
    @FXML
    private Label result;
    @FXML
    private MenuBar menuBar;
    @FXML
    protected void onHelloButtonClick() {
//        ArrayList<Persons>personsArrayList = new ArrayList<>();
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("column_2");
        String parentName = parentText.getText();
        String childName = childText.getText();
        Persons persons = new Persons(parentName,childName);
        personsArrayList.add(persons);

        System.out.println(parentName);
        System.out.println(childName);

        Child child = new Child(childName, new Person(parentName));
        result.setText(child.work());
        System.out.println(countId);
        countId=0;
        for (Persons per:personsArrayList) {
            int count = 0;

            Row row = xssfSheet.createRow(countId);
            Cell cell = row.createCell(count++);
            cell.setCellValue(String.valueOf(countId));
            Cell cell1 = row.createCell(count++);
            cell1.setCellValue(per.getParentText());
            Cell cell2 = row.createCell(count++);
            cell2.setCellValue(per.getChildText());
            System.out.println(per);
            countId++;
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("parent1.xlsx"));
            try {
                xssfWorkbook.write(fileOutputStream);
                xssfWorkbook.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(personsArrayList);

    }
}