package data;

/**
 * Person class. employee and manager inherit from it. Implement general attributes
 */
public abstract class Person implements Worked{
    protected String name;
    protected String surname;
    protected String address;
    protected String docId;
    protected int numberPhone;
    protected Calendar calendar;

    public Person(String name, String surname, String address, String docId, int numberPhone, Calendar calendar) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.docId = docId;
        this.numberPhone = numberPhone;
        this.calendar = calendar;
    }

    public boolean worked(){
        if (this.calendar.hoursWorked > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public String toString() {
        return " Name: " + name + ", " + surname  + "\n" +
                " DocId: " + docId + "\n" +
                " Number Phone: " + numberPhone  + "\n";
    }
}
