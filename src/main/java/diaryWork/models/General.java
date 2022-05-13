package diaryWork.models;

public class General {
    private String category,work,name,day,dateBegin,dateFinish,start,end,person,dayOfWeek,important,status;

    public General(String category, String name, String day, String start, String end, String important, String status) {
        this.name = name;
        this.day = day;
        this.start = start;
        this.end = end;
        this.important = important;
        this.status = status;
        this.category = category;
    }

    public String getWork() {
        return "General work";
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

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getImportant() {
        return important;
    }

    public String getStatus() {
        return status;
    }

    public String getCategory() {
        return category;
    }
}
