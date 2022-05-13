package diaryWork.controllers;

import com.github.saacsos.FXRouter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import diaryWork.models.Item;
import diaryWork.services.WorkFile;

import java.io.IOException;
import java.util.ArrayList;

public class ShowController {
    @FXML
    TableView tableList;
    @FXML
    Label categoryName;
    private WorkFile item;
    private ArrayList<Item> items;
    private ObservableList<Item> itemObservableList;

    @FXML
    public void initialize() throws IOException {
        item = new WorkFile("CSV","work.csv");
        items = item.searchCategory((String) FXRouter.getData());

        itemObservableList = FXCollections.observableList(items);
        tableList.setItems(itemObservableList);

        TableColumn col1 = new TableColumn("Type");
        col1.setCellValueFactory(new PropertyValueFactory<>("work"));
        col1.setPrefWidth(80);
        col1.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col1);

        TableColumn col2 = new TableColumn("Name");
        col2.setCellValueFactory(new PropertyValueFactory<>("name"));
        col2.setPrefWidth(80);
        col2.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col2);

        TableColumn col3 = new TableColumn("Importance");
        col3.setCellValueFactory(new PropertyValueFactory<>("important"));
        col3.setPrefWidth(80);
        col3.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col3);

        TableColumn col4 = new TableColumn("Status");
        col4.setCellValueFactory(new PropertyValueFactory<>("status"));
        col4.setPrefWidth(80);
        col4.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col4);

        categoryName.setText((String) FXRouter.getData());
    }

    @FXML
    public void  handleBackButton(ActionEvent actionEvent)throws IOException {
        FXRouter.goTo("category");
    }
}
