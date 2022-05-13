package diaryWork.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import diaryWork.models.Category;
import diaryWork.services.CategoryFile;

import java.io.IOException;

public class AddCategoryController {
    @FXML
    TextField addCategory;
    @FXML
    Button addButton;
    private CategoryFile cmd;
    @FXML
    public void handleAddButtonOnAction(ActionEvent event) throws IOException {
        cmd = new CategoryFile("CSV", "category.csv");
        if(cmd.checkCategory(addCategory.getText())){
            cmd.error("category name already use");
        }else if (!cmd.checkCategory(addCategory.getText())){
            if (cmd.confirm("Do you want to add Category?")){
                Category category = new Category(addCategory.getText(), "0", "0", "0", "0", "0");
                cmd.addCategory(category);
                addCategory.clear();
            }

        }

    }
}


