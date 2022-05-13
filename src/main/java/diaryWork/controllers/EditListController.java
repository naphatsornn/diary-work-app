package diaryWork.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import diaryWork.models.Item;
import diaryWork.services.WorkFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EditListController {
    private WorkFile item;

    private ArrayList<Item> items;
    private ObservableList<Item> itemObservableList;

    private Item aItem;
    @FXML
    RadioButton mon,tue,wed,thu,fri,sat,sun;
    @FXML
    Label typeLabel,categoryLabel,nameLabel;
    @FXML
    ChoiceBox status,important;
    @FXML
    DatePicker dateBegin,dateFinish,dateWork;
    @FXML
    TextField personField,startField,endField;
    @FXML
    TableView editList;
    public void initialize() throws IOException {
        item = new WorkFile("CSV","work.csv");
        setTable();
        status.getItems().addAll("Has not started","Is working","Finished work");
        important.getItems().addAll("3","2","1");
    }
    private void setTable() throws IOException {

        items = item.getItems();

        itemObservableList = FXCollections.observableList(items);
        editList.setItems(itemObservableList);



        TableColumn col1 = new TableColumn("Type");
        col1.setCellValueFactory(new PropertyValueFactory<>("work"));
        col1.setPrefWidth(156);
        col1.setStyle("-fx-alignment : CENTER");
        editList.getColumns().add(col1);

        TableColumn col2 = new TableColumn("Name");
        col2.setCellValueFactory(new PropertyValueFactory<>("name"));
        col2.setPrefWidth(156);
        col2.setStyle("-fx-alignment : CENTER");
        editList.getColumns().add(col2);


        editList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue==null){
                showSelectedItem(aItem);

            }else if (newValue != oldValue) {
                aItem = (Item) newValue;
                showSelectedItem(aItem);

            }
            else {
                System.out.println("yeah");
            }


        });
    }
    private void showSelectedItem(Item selected) {
        personField.setDisable(false);
        dateWork.setDisable(false);
        mon.setDisable(false);
        tue.setDisable(false);
        wed.setDisable(false);
        thu.setDisable(false);
        fri.setDisable(false);
        sat.setDisable(false);
        sun.setDisable(false);
        dateFinish.setDisable(false);

        if (selected==null){
            //System.out.println(selected.getWork());

        }
        else {
            if (selected.getWork().equals("General work")) {
                typeLabel.setText(selected.getWork());
                categoryLabel.setText(selected.getCategory());
                dateWork.setDisable(false);
                String[] work = selected.getDay().split("/");
                dateWork.setValue(LocalDate.of(Integer.parseInt(work[2]), Integer.parseInt(work[1]), Integer.parseInt(work[0])));
                mon.setDisable(true);
                tue.setDisable(true);
                wed.setDisable(true);
                thu.setDisable(true);
                fri.setDisable(true);
                sat.setDisable(true);
                sun.setDisable(true);
                mon.setSelected(false);
                tue.setSelected(false);
                wed.setSelected(false);
                thu.setSelected(false);
                fri.setSelected(false);
                sat.setSelected(false);
                sun.setSelected(false);
                dateBegin.setDisable(true);
                dateFinish.setDisable(true);
                startField.setText(selected.getStart());
                endField.setText(selected.getEnd());
                status.setValue(selected.getStatus());
                important.setValue(selected.getImportant());
                nameLabel.setText(selected.getName());
                personField.setDisable(true);
                personField.setText("");
                dateBegin.setValue(null);
                dateFinish.setValue(null);
            }
            else if (selected.getWork().equals("Work of week")) {
                typeLabel.setText(selected.getWork());
                categoryLabel.setText(selected.getCategory());
                dateWork.setDisable(true);
                dateWork.setValue(null);
                mon.setDisable(false);
                tue.setDisable(false);
                wed.setDisable(false);
                thu.setDisable(false);
                fri.setDisable(false);
                sat.setDisable(false);
                sun.setDisable(false);
                dateBegin.setDisable(true);
                dateFinish.setDisable(true);
                dateBegin.setValue(null);
                dateFinish.setValue(null);
                mon.setSelected(item.checkChoice(selected.getDayOfWeek(),"mon"));
                tue.setSelected(item.checkChoice(selected.getDayOfWeek(),"tue"));
                wed.setSelected(item.checkChoice(selected.getDayOfWeek(),"wed"));
                thu.setSelected(item.checkChoice(selected.getDayOfWeek(),"thu"));
                fri.setSelected(item.checkChoice(selected.getDayOfWeek(),"fri"));
                sat.setSelected(item.checkChoice(selected.getDayOfWeek(),"sat"));
                sun.setSelected(item.checkChoice(selected.getDayOfWeek(),"sun"));

                startField.setText(selected.getStart());
                endField.setText(selected.getEnd());
                status.setValue(selected.getStatus());
                important.setValue(selected.getImportant());
                nameLabel.setText(selected.getName());
                personField.setDisable(true);
                personField.setText("");
            }
            else if (selected.getWork().equals("Forward work")) {
                typeLabel.setText(selected.getWork());
                categoryLabel.setText(selected.getCategory());
                dateWork.setDisable(true);
                mon.setDisable(true);
                tue.setDisable(true);
                wed.setDisable(true);
                thu.setDisable(true);
                fri.setDisable(true);
                sat.setDisable(true);
                sun.setDisable(true);
                mon.setSelected(false);
                tue.setSelected(false);
                wed.setSelected(false);
                thu.setSelected(false);
                fri.setSelected(false);
                sat.setSelected(false);
                sun.setSelected(false);
                dateWork.setPromptText("");
                personField.setDisable(false);
                dateBegin.setDisable(false);
                String[] begin = selected.getDateBegin().split("/");
                dateBegin.setValue(LocalDate.of(Integer.parseInt(begin[2]), Integer.parseInt(begin[1]), Integer.parseInt(begin[0])));
                String[] finish = selected.getDateBegin().split("/");
                dateFinish.setValue(LocalDate.of(Integer.parseInt(finish[2]), Integer.parseInt(finish[1]), Integer.parseInt(finish[0])));
                startField.setText(selected.getStart());
                endField.setDisable(false);
                endField.setText(selected.getEnd());
                status.setValue(selected.getStatus());
                important.setValue(selected.getImportant());
                nameLabel.setText(selected.getName());
                personField.setText(selected.getPerson());
            }
            else if (selected.getWork().equals("Project work")) {
                typeLabel.setText(selected.getWork());
                categoryLabel.setText(selected.getCategory());
                dateWork.setDisable(true);
                mon.setDisable(true);
                tue.setDisable(true);
                wed.setDisable(true);
                thu.setDisable(true);
                fri.setDisable(true);
                sat.setDisable(true);
                sun.setDisable(true);
                mon.setSelected(false);
                tue.setSelected(false);
                wed.setSelected(false);
                thu.setSelected(false);
                fri.setSelected(false);
                sat.setSelected(false);
                sun.setSelected(false);
                dateWork.setValue(null);
                personField.setText(selected.getPerson());
                personField.setDisable(false);
                String[] begin = selected.getDateBegin().split("/");
                dateBegin.setValue(LocalDate.of(Integer.parseInt(begin[2]), Integer.parseInt(begin[1]), Integer.parseInt(begin[0])));
                dateBegin.setDisable(false);
                String[] finish = selected.getDateBegin().split("/");
                dateFinish.setValue(LocalDate.of(Integer.parseInt(finish[2]), Integer.parseInt(finish[1]), Integer.parseInt(finish[0])));
                startField.setText(selected.getStart());
                endField.setText(selected.getEnd());
                status.setValue(selected.getStatus());
                important.setValue(selected.getImportant());
                nameLabel.setText(selected.getName());
                personField.setText(selected.getPerson());
            }
            else{
                System.out.println("yeah");
            }

        }


    }


    @FXML public void handleUpdateButton(ActionEvent event)throws IOException {
        String dateWeek = "";
        if (mon.isSelected()) {
            dateWeek += "mon ";
        }
        if (tue.isSelected()) {
            dateWeek += "tue ";
        }
        if (wed.isSelected()) {
            dateWeek += "wed ";
        }
        if (thu.isSelected()) {
            dateWeek += "thu ";
        }
        if (fri.isSelected()) {
            dateWeek += "fri ";
        }
        if (sat.isSelected()) {
            dateWeek += "sat ";
        }
        if (sun.isSelected()) {
            dateWeek += "sun ";
        }
        if (item.confirm("Are you confirm to update?")) {
            if (aItem.getWork().equals("General work")) {
                item.edit(aItem.getCategory(), aItem.getWork(), aItem.getName(), dateWork.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), important.getValue().toString(), "-", "-", "-", startField.getText(), endField.getText(), "-", status.getValue().toString());
                setTable();
            } else if (aItem.getWork().equals("Work of week")) {
                item.edit(aItem.getCategory(), aItem.getWork(), aItem.getName(), "-", important.getValue().toString(), "-", "-", "-", startField.getText(), endField.getText(), dateWeek, status.getValue().toString());
                setTable();
            } else if (aItem.getWork().equals("Project work")) {
                item.edit(aItem.getCategory(), aItem.getWork(), aItem.getName(), "-", important.getValue().toString(), personField.getText(), dateBegin.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), dateFinish.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), startField.getText(), endField.getText(), "-", status.getValue().toString());
                setTable();
            } else if (aItem.getWork().equals("Forward work")) {
                item.edit(aItem.getCategory(), aItem.getWork(), aItem.getName(), "-", important.getValue().toString(), personField.getText(), dateBegin.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), dateFinish.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), startField.getText(), endField.getText(), "-", status.getValue().toString());
                setTable();
            }
            editList.refresh();
            dateWork.getEditor().clear();
            dateWork.setPromptText("");
            typeLabel.setText("");
            categoryLabel.setText("");
            nameLabel.setText("");
            important.getSelectionModel().clearSelection();
            dateBegin.getEditor().clear();
            dateBegin.setPromptText("");
            dateFinish.getEditor().clear();
            dateFinish.setPromptText("");
            personField.clear();
            startField.clear();
            endField.clear();
            status.getSelectionModel().clearSelection();
            mon.setSelected(false);
            tue.setSelected(false);
            wed.setSelected(false);
            thu.setSelected(false);
            fri.setSelected(false);
            sat.setSelected(false);
            sun.setSelected(false);
        }
    }
}
