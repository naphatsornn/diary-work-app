package diaryWork.models;

public class Week extends General {
    private String category,work,name,day,dateBegin,dateFinish,start,end,person,dayOfWeek,important,status;

    public Week(String category,String name, String day, String start, String end, String important, String status, String dayOfWeek) {
        super(category,name, day, start, end, important, status);
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String getDateBegin() {
        return dateBegin;
    }

    @Override
    public String getDateFinish() {
        return dateFinish;
    }

    @Override
    public String getPerson() {
        return person;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getStart() {
        return super.getStart();
    }

    @Override
    public String getCategory() {
        return super.getCategory();
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
    public String getStatus() {
        return super.getStatus();
    }

    @Override
    public String getEnd() {
        return super.getEnd();
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public String getWork() {
        return "Work of week";
    }
}
