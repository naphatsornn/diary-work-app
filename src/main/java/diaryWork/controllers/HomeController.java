package diaryWork.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.github.saacsos.FXRouter;

import java.io.IOException;

public class HomeController {
    @FXML Button admin,task,guide,category;


    @FXML
    public void  handleWorkButton(ActionEvent actionEvent)throws IOException{
        FXRouter.goTo("work");
    }

    @FXML
    public void handleAdminButton(ActionEvent actionEvent) throws IOException{
        FXRouter.goTo("name");
    }
    @FXML
    public void handleGuideButton(ActionEvent actionEvent) throws IOException{
        FXRouter.goTo("guide");
    }
    @FXML
    public void handleCategoryButton() throws IOException{
        FXRouter.goTo("category");
    }
}
