package diaryWork.controllers;

import com.github.saacsos.FXRouter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import diaryWork.models.Category;
import diaryWork.services.CategoryFile;

import java.io.IOException;
import java.util.ArrayList;

public class CategoryController {
    @FXML
    ComboBox category;
    @FXML
    TableView tableList;
    @FXML
    Button show ,add ,back;
    @FXML
    Label numNormal ,numPass ,numWeek ,numProject ;

    private CategoryFile cmd;
    private ArrayList<Category> categoryArrayList;
    private ObservableList<Category> categoryObservableList;
    private Category aCategory;
    @FXML
    public void initialize()throws IOException{
        cmd = new CategoryFile("CSV","category.csv");
        categoryArrayList = cmd.getCategoryData();

        categoryObservableList = FXCollections.observableList(categoryArrayList);
        tableList.setItems(categoryObservableList);

        TableColumn col = new TableColumn("Category");
        col.setCellValueFactory(new PropertyValueFactory<>("category"));
        col.setPrefWidth(100);
        col.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col);

        TableColumn col1 = new TableColumn("All");
        col1.setCellValueFactory(new PropertyValueFactory<>("all"));
        col1.setPrefWidth(50);
        col1.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col1);
        for (String each:cmd.getCategory()){
            category.getItems().add(each);
        }

        tableList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != oldValue)
            {
                showSelectedItem((Category) newValue);
                aCategory = (Category) newValue;
            }

        });
    }
    private void showSelectedItem(Category selected) {
        numNormal.setText(selected.getNormal());
        numPass.setText(selected.getPass());
        numWeek.setText(selected.getWeek());
        numProject.setText(selected.getProject());
    }
    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        FXRouter.goTo("home");
    }
    @FXML
    public void  handleAddButton(ActionEvent actionEvent)throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addCategory.fxml"));
        stage.setScene(new Scene(loader.load(),400,100));

        stage.showAndWait();
        refresh();
    }
    @FXML
    public void  handleShowButton(ActionEvent actionEvent)throws IOException {
        FXRouter.goTo("show",category.getValue().toString());
    }
    public void refresh() throws IOException {
        tableList.getColumns().remove(0,2);
        cmd = new CategoryFile("CSV","category.csv");
        categoryArrayList = cmd.getCategoryData();

        categoryObservableList = FXCollections.observableList(categoryArrayList);
        tableList.setItems(categoryObservableList);

        TableColumn col = new TableColumn("Category");
        col.setCellValueFactory(new PropertyValueFactory<>("category"));
        col.setPrefWidth(100);
        col.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col);

        TableColumn col1 = new TableColumn("All");
        col1.setCellValueFactory(new PropertyValueFactory<>("all"));
        col1.setPrefWidth(50);
        col1.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col1);
        category.getItems().clear();
        for (String each:cmd.getCategory()){
            category.getItems().add(each);
        }
    }
}

