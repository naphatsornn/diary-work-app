package diaryWork;

import javafx.application.Application;
import javafx.stage.Stage;
import com.github.saacsos.FXRouter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXRouter.bind(this, primaryStage, "6210451683", 400.0, 600.0);

        configRoute();

        FXRouter.goTo("home");
    }
    private static void configRoute() {
        FXRouter.when("home", "fxml/home.fxml");
        FXRouter.when("name", "fxml/name.fxml");
        FXRouter.when("addTask", "fxml/addWork.fxml");
        FXRouter.when("normal", "fxml/general.fxml");
        FXRouter.when("guide", "fxml/guide.fxml");
        FXRouter.when("work", "fxml/work.fxml");
        FXRouter.when("category", "fxml/category.fxml");
        FXRouter.when("edit", "fxml/editList.fxml");
        FXRouter.when("list", "fxml/list.fxml");
        FXRouter.when("addCategory", "fxml/addCategory.fxml");
        FXRouter.when("show", "fxml/show.fxml");


    }


    public static void main(String[] args) {
        launch(args);
    }
}
