package diaryWork.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import diaryWork.models.Week;
import diaryWork.services.CategoryFile;
import diaryWork.services.WorkFile;

import java.io.IOException;

public class WeekController {
    @FXML
    Button add;
    @FXML
    TextField name,start,end;
    @FXML
    ComboBox category,important,status;
    @FXML
    RadioButton mon,tue,wed,thu,fri,sat,sun;
    private WorkFile workFile;
    private CategoryFile cmd;

    @FXML public void initialize()throws IOException {
        cmd = new CategoryFile("CSV","category.csv");
        for (String each:cmd.getCategory()){
            category.getItems().add(each);
        }
        important.getItems().addAll("3","2","1");
        status.getItems().addAll("Has not started","Is working","Finished work");

    }

    @FXML public void handleAddButton(ActionEvent event) throws IOException {
        workFile = new WorkFile("CSV", "work.csv");
        String dateWeek = "";
        if (mon.isSelected()){
            dateWeek += "mon ";
        }
        if (tue.isSelected()){
            dateWeek += "tue ";
        }
        if (wed.isSelected()){
            dateWeek += "wed ";
        }
        if (thu.isSelected()){
            dateWeek += "thu ";
        }
        if (fri.isSelected()){
            dateWeek += "fri ";
        }
        if (sat.isSelected()){
            dateWeek += "sat ";
        }
        if (sun.isSelected()){
            dateWeek += "sun ";
        }
        if (workFile.checkItem((name.getText()))) {
            Week week = new Week(category.getValue().toString(),name.getText(),"-",start.getText(),end.getText(),important.getValue().toString(),status.getValue().toString(),dateWeek);
            cmd.updateCountCategory(week);
            workFile.createWeek(week);
            category.getSelectionModel().clearSelection();
            name.clear();
            start.clear();
            end.clear();
            mon.setSelected(false);
            tue.setSelected(false);
            wed.setSelected(false);
            thu.setSelected(false);
            fri.setSelected(false);
            sat.setSelected(false);
            sun.setSelected(false);
            important.getSelectionModel().clearSelection();
            status.getSelectionModel().clearSelection();
        }
        else {
            workFile.error("This name is already use");
        }
    }


}
