package diaryWork.models;

public class Category {
    private String all,normal,week,pass,project,category;

    public Category(String category,String all, String normal, String week, String pass, String project) {
        this.all = all;
        this.category = category;
        this.normal = normal;
        this.week = week;
        this.pass = pass;
        this.project = project;
    }

    public String getAll() {
        return all;
    }

    public String getNormal() {
        return normal;
    }

    public String getWeek() {
        return week;
    }

    public String getPass() {
        return pass;
    }

    public String getProject() {
        return project;
    }

    public String getCategory() {
        return category;
    }
}
