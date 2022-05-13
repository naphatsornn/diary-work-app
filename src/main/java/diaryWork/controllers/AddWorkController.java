package diaryWork.controllers;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;


public class AddWorkController {
    @FXML ChoiceBox selectType;
    @FXML
    Button add;

    @FXML public void initialize(){
        selectType.getItems().addAll("General work","Work of week","Forward work","Project work");
    }

    @FXML public void handleAddButton(ActionEvent event)throws IOException{
        if (selectType.getValue().toString().equals("General work")){
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/general.fxml"));
            stage.setScene(new Scene(loader.load(),300,500));

            stage.showAndWait();
        }
        else if(selectType.getValue().toString().equals("Work of week")){
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/week.fxml"));
            stage.setScene(new Scene(loader.load(),300,500));

            stage.showAndWait();
        }
        else if(selectType.getValue().toString().equals("Forward work")){
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/forward.fxml"));
            stage.setScene(new Scene(loader.load(),300,500));

            stage.showAndWait();
        }
        else if(selectType.getValue().toString().equals("Project work")){
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/project.fxml"));
            stage.setScene(new Scene(loader.load(),300,500));

            stage.showAndWait();
        }

    }
    @FXML
    public void handleBackButton(ActionEvent actionEvent){
        try {
            FXRouter.goTo("work");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
    @FXML
    public void  handleListButton(ActionEvent actionEvent)throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/list.fxml"));
        stage.setScene(new Scene(loader.load(),1024,800));

        stage.showAndWait();
    }


}
