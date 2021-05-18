package data;

/**
 * Calendar for all person in business
 */
public class Calendar {
    public final int totalPersonalDays = 2; //Total personal days that employees and managers can take it
    public final int totalVacationDays = 30;//Total vacations days that employees and managers can take it
    public final int minDaysVacation = 3;//Min vacations days that employees and managers can take it
    public int hiredHours;// hours agreed in contract
    public int hoursWorked;// hours worked
    public int personalDay;// count how many personal days
    public int vacationDay;// count how many vacations days
    public String reasonPersonalDay; // save the reason for the absence from work
    public boolean takeDaysP;// check if it has taken days
    public boolean takeVacation;//check if it has taken days

    public Calendar(int hiredHours, int hoursWorked, int personalDay,
                    int vacationDay, String reasonPersonalDay, boolean takeDaysP,
                    boolean takeVacation) {
        this.hiredHours = hiredHours;
        this.hoursWorked = hoursWorked;
        this.personalDay = personalDay;
        this.vacationDay = vacationDay;
        this.reasonPersonalDay = reasonPersonalDay;
        this.takeDaysP = takeDaysP;
        this.takeVacation = takeVacation;
    }

    public boolean getTakeDaysP() {
        return takeDaysP;
    }

    public void setTakeDaysP(boolean takeDaysP) {
        this.takeDaysP = takeDaysP;
    }

    public boolean getTakeVacation() {
        return takeVacation;
    }

    public void setTakeVacation(boolean takeVacation) {
        this.takeVacation = takeVacation;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getReasonPersonalDay() {
        return reasonPersonalDay;
    }

    public void setReasonPersonalDay(String reasonPersonalDay) {
        this.reasonPersonalDay = reasonPersonalDay;
    }

    public int getTotalPersonalDays() {
        return totalPersonalDays;
    }

    public int getTotalVacationDays() {
        return totalVacationDays;
    }

    public int getMinDaysVacation() {
        return minDaysVacation;
    }

    public int getHiredHours() {
        return hiredHours;
    }

    public void setHiredHours(int hiredHours) {
        this.hiredHours = hiredHours;
    }

    public int getPersonalDay() {
        return personalDay;
    }

    public void setPersonalDay(int personalDay) {
        this.personalDay = personalDay;
    }

    public int getVacationDay() {
        return vacationDay;
    }

    public void setVacationDay(int vacationDay) {
        this.vacationDay = vacationDay;
    }

    public void takePersonalDay(){
        personalDay = personalDay + 1;
    }

    public void takeVacation(int number){
        vacationDay = vacationDay + number;
    }

    public void addHours(int numberH){
        hoursWorked = hoursWorked + numberH;
    }

    @Override
    public String toString() {
        return " Hired Hours = " + hiredHours + "\n" +
                " Worked Hours = " + hoursWorked + "\n" +
                " Has personal day = " + personalDay + "\n" +
                " Has Vacations = " + vacationDay + "\n" +
                "------";
    }
}
