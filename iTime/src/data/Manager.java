//DATA AND CONFIG MANAGER

package data;

public class Manager extends Person{
    protected String area;
    protected String level;

    public Manager(String name, String surname, String address, String docId, int numberPhone, Calendar calendar, String area, String level) {
        super(name, surname, address, docId, numberPhone, calendar);
        this.area = area;
        this.level = level;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Area: " + area + "\n" +
                " Level: " + level + "\n" +
                calendar;
    }
}
