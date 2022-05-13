package diaryWork.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import diaryWork.models.Forward;
import diaryWork.services.CategoryFile;
import diaryWork.services.WorkFile;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ForwardController {
    @FXML
    Button add;
    @FXML
    TextField name,people,time,end;
    @FXML
    ComboBox category,important,status;
    @FXML
    DatePicker datePicker,dateEnd;
    private WorkFile workFile;
    private CategoryFile cmd;

    @FXML public void initialize() throws IOException {
        cmd = new CategoryFile("CSV","category.csv");
        for (String each:cmd.getCategory()){
            category.getItems().add(each);
        }
        important.getItems().addAll("3","2","1");
        status.getItems().addAll("Has not started","Is working","Finished work");

    }

    @FXML public void handleAddButton(ActionEvent event) throws IOException {
        workFile = new WorkFile("CSV","work.csv");
        if(workFile.checkItem(name.getText())) {
            Forward pass = new Forward(category.getValue().toString(), name.getText(),"-", time.getText(),end.getText(),important.getValue().toString(),status.getValue().toString(),people.getText(),datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),dateEnd.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            cmd.updateCountCategory(pass);
            workFile.createPass(pass);
            name.clear();
            time.clear();
            people.clear();
            end.clear();
            category.getSelectionModel().clearSelection();
            datePicker.getEditor().clear();
            dateEnd.getEditor().clear();
            important.getSelectionModel().clearSelection();
            status.getSelectionModel().clearSelection();
        }
        else {
            workFile.error("This name is already use");
        }
    }


}


