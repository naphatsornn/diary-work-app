package diaryWork.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import diaryWork.models.General;
import diaryWork.services.CategoryFile;
import diaryWork.services.WorkFile;

import java.io.IOException;
import java.time.format.DateTimeFormatter;


public class GeneralController {
    @FXML
    Button add;
    @FXML
    TextField name,start,end;
    @FXML
    ComboBox category,important,status;
    @FXML
    DatePicker datePicker;
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
        if (workFile.checkItem(name.getText())){

            General normal = new General(category.getValue().toString(),name.getText(),datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),start.getText(),end.getText(),important.getValue().toString(),status.getValue().toString());
            cmd.updateCountCategory(normal);
            workFile.createNormal(normal);
            name.clear();;
            start.clear();
            end.clear();
            datePicker.getEditor().clear();
            category.getSelectionModel().clearSelection();
            important.getSelectionModel().clearSelection();
            status.getSelectionModel().clearSelection();
        }
        else {
            workFile.error("This name is already use");
        }
    }




}
