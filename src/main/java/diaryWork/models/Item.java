package diaryWork.models;


public class Item {
    private String category,work,name,day,dateBegin,dateFinish,start,end,person,dayOfWeek,important,status;

    public Item(String category, String work, String name, String day, String dateBegin, String dateFinish, String start, String end, String person, String dayOfWeek, String important, String status) {
        this.category = category;
        this.work = work;
        this.name = name;
        this.day = day;
        this.dateBegin = dateBegin;
        this.dateFinish = dateFinish;
        this.start = start;
        this.end = end;
        this.person = person;
        this.dayOfWeek = dayOfWeek;
        this.important = important;
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public String getWork() {
        return work;
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getPerson() {
        return person;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getImportant() {
        return important;
    }

    public String getStatus() {
        return status;
    }
}
