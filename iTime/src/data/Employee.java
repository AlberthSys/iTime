//DATA EMPLOYEE

package data;

public class Employee extends Person{
    protected String user;
    protected String password;
    protected String departmen;

    public Employee(String name, String surname, String address, String docId,
                    int numberPhone, Calendar calendar, String user, String password,
                    String departmen) {
        super(name, surname, address, docId, numberPhone, calendar);
        this.user = user;
        this.password = password;
        this.departmen = departmen;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartmen() {
        return departmen;
    }

    public void setDepartmen(String departmen) {
        this.departmen = departmen;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Departament = " + departmen + "\n" +
                calendar;
    }
}
