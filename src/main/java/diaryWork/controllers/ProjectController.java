package diaryWork.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import diaryWork.models.Project;
import diaryWork.services.CategoryFile;
import diaryWork.services.WorkFile;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ProjectController {
    @FXML
    Button add;
    @FXML
    TextField name,boss,endTime,start;
    @FXML
    ComboBox category,important,status;
    @FXML
    DatePicker dateStart,dateFinish;
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
        workFile = new WorkFile("CSV","work.csv");
        if(workFile.checkItem(name.getText())) {
            Project project = new Project(category.getValue().toString(),name.getText(),"-",start.getText(),endTime.getText(),important.getValue().toString(),status.getValue().toString(),dateStart.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),dateFinish.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),boss.getText());
            cmd.updateCountCategory(project);
            workFile.createProject(project);
            name.clear();
            boss.clear();
            dateStart.getEditor().clear();
            dateFinish.getEditor().clear();
            start.clear();
            endTime.clear();
            important.getSelectionModel().clearSelection();
            status.getSelectionModel().clearSelection();
        }
        else {
            workFile.error("This name is already use");
        }
    }

}
