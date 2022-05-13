package diaryWork.controllers;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class WorkController {
    @FXML
    ImageView photo;

    @FXML
    public void  handleTaskButton(ActionEvent actionEvent)throws IOException {
        FXRouter.goTo("addTask");
    }
    @FXML
    public void  handleListButton(ActionEvent actionEvent)throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/list.fxml"));
        stage.setScene(new Scene(loader.load(),1024,800));

        stage.showAndWait();
    }
    @FXML
    public void  handleBackButton(ActionEvent actionEvent)throws IOException {
        FXRouter.goTo("home");
    }



}
