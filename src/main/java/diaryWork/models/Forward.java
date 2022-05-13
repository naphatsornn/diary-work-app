package diaryWork.models;

public class Forward extends General {
    private String category,work,name,day,dateBegin,dateFinish,start,end,person,dayOfWeek,important,status;

    public Forward(String category, String name, String day, String start, String end, String important, String status, String person, String dateBegin, String dateFinish) {
        super(category,name, day, start, end, important, status);
        this.person = person;
        this.dateBegin = dateBegin;
        this.dateFinish = dateFinish;
    }

    @Override
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public String getWork() {
        return "Forward work";
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDay() {
        return super.getDay();
    }

    @Override
    public String getStart() {
        return super.getStart();
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

    public String getPerson() {
        return person;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public String getDateFinish() {
        return dateFinish;
    }
}
