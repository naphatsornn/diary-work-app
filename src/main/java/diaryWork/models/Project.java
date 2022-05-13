package diaryWork.models;

public class Project extends General {
    private String category,work,name,day,dateBegin,dateFinish,start,end,person,dayOfWeek,important,status;

    public Project(String category,String name, String day, String start, String end, String important, String status, String dateBegin, String dateFinish, String person) {
        super(category,name, day, start, end, important, status);
        this.dateBegin = dateBegin;
        this.dateFinish = dateFinish;
        this.person = person;
    }

    @Override
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public String getEnd() {
        return super.getEnd();
    }

    @Override
    public String getStatus() {
        return super.getStatus();
    }

    @Override
    public String getDay() {
        return super.getDay();
    }

    @Override
    public String getImportant() {
        return super.getImportant();
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }

    @Override
    public String getStart() {
        return super.getStart();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public String getPerson() {
        return person;
    }

    @Override
    public String getWork() {
        return "Project work";
    }
}
