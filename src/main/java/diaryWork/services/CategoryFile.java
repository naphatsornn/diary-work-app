package diaryWork.services;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import diaryWork.models.Category;
import diaryWork.models.Item;
import diaryWork.models.General;

import java.io.*;
import java.util.ArrayList;

public class CategoryFile {
    private String fileDirectoryName,fileName;
    private ArrayList<Category> categoryArrayList;
    private ArrayList<Category> categories;
    private ArrayList<Item> items;

    public CategoryFile(String fileDirectoryName, String fileName){
        this.fileDirectoryName = fileDirectoryName;
        this.fileName = fileName;
        checkFileIsExisted();
    }
    private void checkFileIsExisted() {
        File file = new File(fileDirectoryName);
        if (!file.exists()) {
            file.mkdirs();
        }

        String filePath = fileDirectoryName + File.separator + fileName;
        file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Cannot create " + filePath);
            }
        }
    }

    public ArrayList<Category> getCategoryData() {
        try{
            categoryArrayList = new ArrayList<>();
            readCategoryData();
        }
        catch (FileNotFoundException e) {
            System.err.println(this.fileName + " not found");
        }
        catch (IOException e) {
            System.err.println("IOException from reading " + this.fileName);
        }
        return categoryArrayList;
    }

    public void readCategoryData()throws IOException{
        String path = fileDirectoryName + File.separator + fileName;
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while((line = reader.readLine()) != null){
            String[] data = line.split(",");
            categoryArrayList.add(new Category(data[0], data[1], data[2], data[3], data[4], data[5]));
        }
        reader.close();
    }

    public ArrayList<String> getCategory() throws IOException{
        String path = fileDirectoryName + File.separator + fileName;
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        ArrayList<String> categories = new ArrayList<>();
        while((line = reader.readLine()) != null){
            String[] data = line.split(",");
            categories.add(data[0]);
        }
        reader.close();
        return categories;
    }

    public boolean checkCategory(String category) throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";

        while ((line = reader.readLine()) != null){
            String[] data = line.split(",");
            if (data[0].equals(category)){
                return true;
            }
        }
        return false;
    }
    public void addCategory(Category category) throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line ="";
        categoryArrayList = new ArrayList<>();

        while ((line = reader.readLine()) != null){
            String[] data = line.split(",");
            Category aCategory= new Category(data[0],data[1],data[2],data[3],data[4],data[5]);
            categoryArrayList.add(aCategory);
        }
        reader.close();

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String addCategory = category.getCategory()+","+category.getAll()+","+category.getNormal()+","+category.getWeek()+","+category.getPass()+","+category.getProject();
        writer.append(addCategory);
        writer.newLine();

        for(Category aCategory : categoryArrayList){
            addCategory = aCategory.getCategory()+","+aCategory.getAll()+","+aCategory.getNormal()+","+aCategory.getWeek()+","+aCategory.getPass()+","+aCategory.getProject();
            writer.append(addCategory);
            writer.newLine();
        }
        writer.close();
    }

    public void updateCountCategory(General task){
        String path = fileDirectoryName+File.separator+fileName;
        File file = new File(path);
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        categories = new ArrayList<>();
        try {
            fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line="";

            Category cate;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if(task.getCategory().equals(data[0])) {

                    if (task.getWork().equals("General work")) {
                        cate = new Category(data[0], String.valueOf(Integer.parseInt(data[1]) + 1), String.valueOf(Integer.parseInt(data[2]) + 1), data[3], data[4], data[5]);
                        categories.add(cate);
                    }
                    else if (task.getWork().equals("Work of week")) {
                        cate = new Category(data[0], String.valueOf(Integer.parseInt(data[1]) + 1), data[2], String.valueOf(Integer.parseInt(data[3]) + 1), data[4], data[5]);
                        categories.add(cate);
                    }
                    else if (task.getWork().equals("Forward work")) {
                        cate = new Category(data[0], String.valueOf(Integer.parseInt(data[1]) + 1), data[2], data[3],String.valueOf(Integer.parseInt(data[4]) + 1), data[5]);
                        categories.add(cate);
                    }
                    else if (task.getWork().equals("Project work")) {
                        cate = new Category(data[0], String.valueOf(Integer.parseInt(data[1]) + 1), data[2], data[3], data[4], String.valueOf(Integer.parseInt(data[5]) + 1));
                        categories.add(cate);
                    }

                }
                else{
                    categories.add(new Category(data[0],data[1],data[2],data[3],data[4],data[5]));
                }
            }
            reader.close();

            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (Category c : categories) {
                line = c.getCategory() + "," + c.getAll() + "," + c.getNormal() + "," + c.getWeek() + "," + c.getPass() + "," + c.getProject();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void error(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR,"ERROR!", ButtonType.OK);
        alert.setContentText(text);
        alert.showAndWait();
        if (alert.getResult()==ButtonType.OK){
            alert.close();
        }
    }
    public boolean confirm(String text){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"CONFIRMATION!", ButtonType.YES,ButtonType.NO);
        alert.setContentText(text);
        alert.showAndWait();
        if (alert.getResult()==ButtonType.YES){
            alert.close();
            return true;
        }else{
            alert.close();
            return false;
        }
    }
}