package MainProject;

public class Subject {
    private final String code;
    private final String title;
    private final String section;
    private final int units;
    private final String days;
    private final String time;
    private final String room;

    public Subject(String code, String title, String section, int units,
                   String days, String time, String room) {
        this.code = code;
        this.title = title;
        this.section = section;
        this.units = units;
        this.days = days;
        this.time = time;
        this.room = room;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public String getSection() { return section; }
    public int getUnits() { return units; }
    public String getDays() { return days; }
    public String getTime() { return time; }
    public String getRoom() { return room; }
}
