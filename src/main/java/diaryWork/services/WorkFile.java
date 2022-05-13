package diaryWork.services;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import diaryWork.models.*;

import java.io.*;
import java.util.ArrayList;


public class WorkFile {
    private String fileDirectoryName;
    private String fileName;
    private ArrayList<Item> items;

    public WorkFile(String fileDirectoryName, String fileName) {
        this.fileDirectoryName = fileDirectoryName;
        this.fileName = fileName;
    }

    public boolean checkItem(String name) throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";

        while ((line = reader.readLine()) != null){
            String[] data = line.split(",");
            if (data[2].equals(name)){
                return false;
            }
        }
        return true;
    }


    public boolean checkChoice(String dayOfWeek,String day){
        String[] data = dayOfWeek.split(" ");
        for (int i=0;i<data.length;i++){
            if (data[i].equals(day)){
                return true;
            }
        }
        return false;
    }


    public void createNormal(General normal) throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line ="";
        items = new ArrayList<>();

        while ((line = reader.readLine()) != null){
            String[] data = line.split(",");
            Item anItem= new Item(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11]);
            items.add(anItem);
        }
        reader.close();
        fileReader.close();

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String addItem = normal.getCategory()+","+normal.getWork()+","+normal.getName()+","+normal.getDay()+",-,-,"+normal.getStart()+","+normal.getEnd()+",-,-,"+normal.getImportant()+","+normal.getStatus();
        writer.append(addItem);
        writer.newLine();


        for(Item anItem : items){
           addItem = anItem.getCategory()+ ","+ anItem.getWork() + "," + anItem.getName() + "," + anItem.getDay() + "," + anItem.getDateBegin() + "," + anItem.getDateFinish() + "," + anItem.getStart() + "," + anItem.getEnd()+","+anItem.getPerson()+","+anItem.getDayOfWeek()+","+anItem.getImportant()+","+anItem.getStatus();
            writer.append(addItem);
            writer.newLine();
        }
        writer.close();
        fileWriter.close();
    }

    public void createPass(Forward pass) throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line ="";
        items = new ArrayList<>();

        while ((line = reader.readLine()) != null){
            String[] data = line.split(",");
            Item anItem= new Item(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11]);
            items.add(anItem);
        }
        reader.close();

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        General normal = pass;
        String addItem = normal.getCategory()+","+normal.getWork()+","+normal.getName()+",-,"+normal.getDateBegin()+","+normal.getDateFinish()+","+normal.getStart()+","+normal.getEnd()+","+normal.getPerson()+",-,"+normal.getImportant()+","+normal.getStatus();
        writer.append(addItem);
        writer.newLine();

        for(Item anItem : items){
            addItem = anItem.getCategory()+ ","+ anItem.getWork() + "," + anItem.getName() + "," + anItem.getDay() + "," + anItem.getDateBegin() + "," + anItem.getDateFinish() + "," + anItem.getStart() + "," + anItem.getEnd()+","+anItem.getPerson()+","+anItem.getDayOfWeek()+","+anItem.getImportant()+","+anItem.getStatus();
            writer.append(addItem);
            writer.newLine();
        }

        writer.close();

    }
    public void createWeek(Week week) throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line ="";
        items = new ArrayList<>();

        while ((line = reader.readLine()) != null){
            String[] data = line.split(",");
            Item anItem= new Item(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11]);
            items.add(anItem);
        }
        reader.close();

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        General normal = week;
        String addItem = normal.getCategory()+","+normal.getWork()+","+normal.getName()+",-,-,-,"+normal.getStart()+","+normal.getEnd()+",-,"+normal.getDayOfWeek()+","+normal.getImportant()+","+normal.getStatus();
        writer.append(addItem);
        writer.newLine();

        for(Item anItem : items){
            addItem = anItem.getCategory()+ ","+ anItem.getWork() + "," + anItem.getName() + "," + anItem.getDay() + "," + anItem.getDateBegin() + "," + anItem.getDateFinish() + "," + anItem.getStart() + "," + anItem.getEnd()+","+anItem.getPerson()+","+anItem.getDayOfWeek()+","+anItem.getImportant()+","+anItem.getStatus();
            writer.append(addItem);
            writer.newLine();
        }

        writer.close();
    }
    public void createProject(Project project) throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line ="";
        items = new ArrayList<>();

        while ((line = reader.readLine()) != null){
            String[] data = line.split(",");
            Item anItem= new Item(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11]);
            items.add(anItem);
        }
        reader.close();

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        General normal = project;
        String addItem = normal.getCategory()+","+normal.getWork()+","+project.getName()+",-,"+normal.getDateBegin()+","+normal.getDateFinish()+","+normal.getStart()+","+normal.getEnd()+","+normal.getPerson()+",-,"+normal.getImportant()+","+normal.getStatus();
        writer.append(addItem);
        writer.newLine();

        for(Item anItem : items){
            addItem = anItem.getCategory()+ ","+ anItem.getWork() + "," + anItem.getName() + "," + anItem.getDay() + "," + anItem.getDateBegin() + "," + anItem.getDateFinish() + "," + anItem.getStart() + "," + anItem.getEnd()+","+anItem.getPerson()+","+anItem.getDayOfWeek()+","+anItem.getImportant()+","+anItem.getStatus();
            writer.append(addItem);
            writer.newLine();
        }

        writer.close();

    }
    public void readData() throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null){
            String[] data = line.split(",");
            Item anItem= new Item(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11]);
            items.add(anItem);
        }
        reader.close();
    }

    public ArrayList<Item> getItems() throws IOException {
        items = new ArrayList<>();
        readData();
        return items;
    }

    public String[] category() throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        line = reader.readLine();
        String[] data = line.split(",");
        reader.close();
        return data;
    }



    public void edit(String category, String work, String name,String day, String important, String person, String dateBegin, String dateFinish, String start, String end, String dayOfWeek,String status) throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        items = new ArrayList<>();

        while ((line=reader.readLine())!=null){
            String[] data= line.split(",");
            Item item=new Item(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11]);
            items.add(item);
        }
        reader.close();

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Item anItem : items){
            if (anItem.getCategory().equals(category) && anItem.getName().equals(name) && anItem.getWork().equals(work)){
                String update = category+ ","+ work + "," + name + "," + day+ "," + dateBegin+ "," + dateFinish + "," + start +","+ end +","+ person+","+dayOfWeek+","+important+","+status;
                bufferedWriter.append(update);
                bufferedWriter.newLine();
            }
            else {
                String other = anItem.getCategory()+ ","+ anItem.getWork() + "," + anItem.getName() + "," + anItem.getDay() + "," + anItem.getDateBegin() + "," + anItem.getDateFinish() + "," + anItem.getStart() + "," + anItem.getEnd()+","+anItem.getPerson()+","+anItem.getDayOfWeek()+","+anItem.getImportant()+","+anItem.getStatus();
                bufferedWriter.append(other);
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.close();
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

    public ArrayList<Item> searchStatus(String status) throws IOException{
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        items = new ArrayList<>();

        while ((line = reader.readLine())!=null){
            String[] data = line.split(",");
            if (data[11].equals(status)){
                Item item = new Item(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11]);
                items.add(item);
            }
        }
        reader.close();
        return items;
    }
    public ArrayList<Item> searchDate(String date)throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        items = new ArrayList<>();

        while ((line = reader.readLine())!=null){
            String[] data = line.split(",");
            if (data[3].equals(date) || data[4].equals(date)){
                Item item = new Item(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11]);
                items.add(item);
            }
        }
        reader.close();
        return items;
    }

    public ArrayList<Item> searchCategory(String category) throws IOException{
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        items = new ArrayList<>();

        while ((line = reader.readLine())!=null){
            String[] data = line.split(",");
            if (data[0].equals(category)){
                Item item = new Item(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11]);
                items.add(item);
            }
        }
        reader.close();
        return items;
    }
}
