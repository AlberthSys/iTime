package data;

/**
 * Calendar for all person in business
 */
public class Calendar {
    public final int totalPersonalDays = 2;
    public final int totalVacationDays = 30;
    public final int minDaysVacation = 3;
    public int hiredHours;
    public int hoursWorked;
    public int personalDay;
    public int vacationDay;
    public String reasonPersonalDay;
    public boolean takeDaysP;
    public boolean takeVacation;

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
