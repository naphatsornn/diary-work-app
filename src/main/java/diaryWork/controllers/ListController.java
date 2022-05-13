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
import diaryWork.models.Item;
import diaryWork.services.WorkFile;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ListController {
    @FXML
    TableView tableList;
    private Item aItem;
    private WorkFile item;
    private ArrayList<Item> items;
    private ObservableList<Item> itemObservableList;

    @FXML
    ComboBox status;
    @FXML
    DatePicker date;
    @FXML
    Label dateWork,week,boss,begin,start,end,finish;
    public void initialize() throws IOException {
        item = new WorkFile("CSV","work.csv");
        items = item.getItems();

        itemObservableList = FXCollections.observableList(items);
        tableList.setItems(itemObservableList);

        TableColumn col = new TableColumn("Category");
        col.setCellValueFactory(new PropertyValueFactory<>("category"));
        col.setPrefWidth(94);
        col.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col);

        TableColumn col1 = new TableColumn("Type");
        col1.setCellValueFactory(new PropertyValueFactory<>("work"));
        col1.setPrefWidth(110);
        col1.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col1);

        TableColumn col2 = new TableColumn("Name");
        col2.setCellValueFactory(new PropertyValueFactory<>("name"));
        col2.setPrefWidth(140);
        col2.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col2);



        TableColumn col3 = new TableColumn("Importance");
        col3.setCellValueFactory(new PropertyValueFactory<>("important"));
        col3.setPrefWidth(120);
        col3.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col3);

        TableColumn col4 = new TableColumn("Status");
        col4.setCellValueFactory(new PropertyValueFactory<>("status"));
        col4.setPrefWidth(130);
        col4.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col4);
        tableList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != oldValue)
            {
                aItem = (Item) newValue;
                showSelectedItem((Item) newValue);

            }
            else if (newValue != oldValue) {
                aItem = (Item) newValue;
                showSelectedItem(aItem);

            }
            else {
                System.out.println("yeah");
            }


        });

        col3.setSortType(TableColumn.SortType.DESCENDING);
        tableList.getSortOrder().add(col3);
        status.getItems().addAll("Has not started","Is working","Finished work");
    }
    private void showSelectedItem(Item selected) {
        dateWork.setText(selected.getDay());
        week.setText(selected.getDayOfWeek());
        boss.setText(selected.getPerson());
        begin.setText(selected.getDateBegin());
        start.setText(selected.getStart());
        end.setText(selected.getEnd());
        finish.setText(selected.getDateFinish());
    }

    @FXML
    public void handleChecksButton  (ActionEvent actionEvent) throws IOException{
        items = item.searchStatus(status.getValue().toString());
        itemObservableList = FXCollections.observableList(items);
        tableList.setItems(itemObservableList);

    }
    @FXML
    public  void handleCheckButton (ActionEvent actionEvent) throws  IOException{
        items = item.searchDate(date.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        itemObservableList = FXCollections.observableList(items);
        tableList.setItems(itemObservableList);

    }

    @FXML
    public void  handleBackButton(ActionEvent actionEvent)throws IOException {
        FXRouter.goTo("home");
    }

    @FXML
    public void  handleEditorButton(ActionEvent actionEvent)throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/editList.fxml"));
        stage.setScene(new Scene(loader.load(),800,600));
        stage.showAndWait();
        refresh();
    }
    @FXML
    public void handleRefreshButton (ActionEvent actionEvent) throws  IOException{
        refresh();
    }

    private void refresh()throws IOException{
        tableList.getColumns().remove(0,5);
        items = item.getItems();

        itemObservableList = FXCollections.observableList(items);
        tableList.setItems(itemObservableList);
        TableColumn col = new TableColumn("Category");
        col.setCellValueFactory(new PropertyValueFactory<>("category"));
        col.setPrefWidth(94);
        col.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col);

        TableColumn col1 = new TableColumn("Type");
        col1.setCellValueFactory(new PropertyValueFactory<>("work"));
        col1.setPrefWidth(110);
        col1.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col1);

        TableColumn col2 = new TableColumn("Name");
        col2.setCellValueFactory(new PropertyValueFactory<>("name"));
        col2.setPrefWidth(140);
        col2.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col2);



        TableColumn col3 = new TableColumn("Importance");
        col3.setCellValueFactory(new PropertyValueFactory<>("important"));
        col3.setPrefWidth(120);
        col3.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col3);

        TableColumn col4 = new TableColumn("Status");
        col4.setCellValueFactory(new PropertyValueFactory<>("status"));
        col4.setPrefWidth(130);
        col4.setStyle("-fx-alignment : CENTER");
        tableList.getColumns().add(col4);
        tableList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != oldValue)
            {
                aItem = (Item) newValue;
                showSelectedItem((Item) newValue);

            }


        });

        col3.setSortType(TableColumn.SortType.DESCENDING);
        tableList.getSortOrder().add(col3);
    }

}
