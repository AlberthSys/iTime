package main;
import data.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class implements all logic the program.
 */
public class Management {
    ArrayList<Person> myList = new ArrayList();

    /**
     * Execute the menu and start methods that user select
     */
    public void execute() {
        boolean run = false;
        FileUtils f = new FileUtils();
        myList = f.loadStats();
        do {
            switch (showMenu()) {
                case "0":
                    hoursRealized();
                    break;
                case "1":
                    addHours();
                    break;
                case "2":
                    addEmployee();
                    break;
                case "3":
                    takePersonalDay();
                    break;
                case "4":
                    takeVacation();
                    break;
                case "5":
                    viewAllEmployees();
                    break;
                case "6":
                    lookHoursWorkedALlEmployees();
                    break;
                case "7":
                    seeFreeDays();
                    break;
                case "8":
                    seeVacation();
                    break;
                case "9":
                    removeEmployee();
                    break;
                case "10":
                    configDataPerson();
                    break;
                case "E":
                    run = true;
                    break;
                default:
                    System.out.println("Insert 0 - 10");
                    break;
            }
        } while (!run);
        f.saveStats(myList);
        System.out.println("Finish process");
    }

    /**
     * @return the principal menu
     */
    private static String showMenu(){
        Scanner gg = new Scanner(System.in);
        String inputOption = "";
        System.out.println("-----------* iTime *------------");
        System.out.println("0.- Look hours worked");
        System.out.println("1.- Record of working hours");
        System.out.println("2.- Add Employee");
        System.out.println("3.- Take Personal Day");
        System.out.println("4.- Take Vacations");
        System.out.println("5.- View Data About All Employees");
        System.out.println("6.- Look hours worked all employees");
        System.out.println("7.- See free days");
        System.out.println("8.- See Vacations");
        System.out.println("9.- Remove employee");
        System.out.println("10.- Change Data");
        System.out.println("E.- Exit");
        System.out.print("Choose an Option: ");
        inputOption = gg.next().toUpperCase();
        return inputOption;
    }

    /**
     * Show hours worked
     */
    private void hoursRealized(){//CALL 0
        System.out.println("HOURS REALIZED");
        Scanner hh = new Scanner(System.in);
        System.out.println("1.- Employee");
        System.out.println("2.- Manager");
        String inputOption = hh.nextLine();
        if (inputOption.equals("1")) {
            System.out.print("Your User: ");
            String userPD = hh.next();
            System.out.print("Your Password: ");
            String passPD = hh.next();
            boolean searched = false;
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i) instanceof Employee) {
                    if (((Employee) myList.get(i)).getUser().equals(userPD) &&
                            ((Employee) myList.get(i)).getPassword().equals(passPD)) {
                        if (myList.get(i).worked()) {
                            System.out.println("Hours worked: " + myList.get(i).getCalendar()
                                    .hoursWorked);
                            searched = true;
                        } else {
                            System.out.println("Not realized yet.");
                            searched = true;
                        }
                    }
                }
            }
            if (!searched) {
                System.out.println("Not found");
            }
        }
        else if (inputOption.equals("2")){
            System.out.print("Doc ID: ");
            String inputID = hh.next();
            boolean searchedM = false;
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i) instanceof Manager) {
                    if (((Manager)myList.get(i)).getDocId().equals(inputID)) {
                        if (myList.get(i).worked()) {
                            System.out.println("Hours worked: " + myList.get(i).getCalendar()
                                    .hoursWorked);
                            searchedM = true;
                        } else {
                            System.out.println("Not realized yet.");
                            searchedM = true;
                        }
                    }
                }
            }
            if (!searchedM) {
                System.out.println("Not found");
            }
        }
        else{
            System.out.println("Select 1 or 2");
        }
    }

    /**
     * Add hours for employees and management
     */
    private void addHours(){ // CALL 1
        boolean searched = false;
        Scanner hh = new Scanner(System.in);
        System.out.println("ADD HOURS");
        System.out.println("1.- Employee");
        System.out.println("2.- Manager");
        String inputOption = hh.nextLine();
        if (inputOption.equals("1")) {
            System.out.print("Your User: ");
            String userPD = hh.next();
            System.out.print("Your Password: ");
            String passPD = hh.next();
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i) instanceof Employee) {
                    if (((Employee) myList.get(i)).getUser().equals(userPD) &&
                            ((Employee) myList.get(i)).getPassword().equals(passPD)) {
                        System.out.println("Many hours worked?: ");
                        int hours = 0;
                        try {
                            hours = hh.nextInt();
                            if (myList.get(i).getCalendar().hoursWorked + hours <=
                                    myList.get(i).getCalendar().hiredHours) {
                                myList.get(i).getCalendar().addHours(hours);
                                System.out.println("Registred hours");
                                searched = true;
                            }
                            else {
                                System.out.println("You cannot register more hours " +
                                        "than contracted");
                            }
                        }catch (Exception e){
                            System.out.println("Not save. Try again: " + e);
                            searched = true;
                        }
                    }
                }
            }
            if (!searched) {
                System.out.println("Not found");
            }
        }
        else if (inputOption.equals("2")){
            System.out.print("Doc ID: ");
            String inputID = hh.next();
            boolean searchedM = false;
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i) instanceof Manager) {
                    if ((myList.get(i)).getDocId().equals(inputID)) {
                        System.out.print("Many hours worked?: ");
                        int hours = 0;
                        try {
                            hours = hh.nextInt();
                            if (myList.get(i).getCalendar().hoursWorked + hours <=
                                    myList.get(i).getCalendar().hiredHours) {
                                myList.get(i).getCalendar().addHours(hours);
                                System.out.println("Registred hours");
                                searchedM = true;
                            }
                            else {
                                System.out.println("Cant registre more hours");
                                searchedM = true;
                            }
                        }catch (InputMismatchException e){
                            searchedM = true;
                            System.out.println("Not save. Try again: " + "Can't convert");
                        }
                        catch (NumberFormatException n){
                            searchedM = true;
                            System.out.println("Not save. Try again: " + n.getMessage());
                        }
                        catch (Exception e){
                            searchedM = true;
                            System.out.println("Not save. Try again: " + e.getMessage());
                        }
                    }
                }
            }
            if (!searchedM) {
                System.out.println("Not found");
            }
        }
        else{
            System.out.println("Select 1 or 2");
        }
    }

    /**
     * This method add a new employee
     */
    private void addEmployee(){ //CALL 2
        Scanner ad = new Scanner(System.in);
        Calendar calendar;
        Employee e;
        boolean itsOK = false;
        boolean controlID = false;
        boolean itsManager = false;
        int auxPhone = 0;
        String docID;
        System.out.println("ADD EMPLOYEE");
        System.out.println("Doc ID Manager: ");
        String inputID = ad.nextLine();
        for (int i = 0; i < myList.size(); i++){
            if(myList.get(i) instanceof Manager){
                if (myList.get(i).getDocId().equals(inputID))
                    itsManager = true;
            }
        }
        if (itsManager) {
            System.out.println("Name: ");
            String name = ad.nextLine();
            System.out.println("Surname: ");
            String surname = ad.nextLine();
            System.out.println("Address: ");
            String address = ad.nextLine();
            do {
                System.out.println("DocID: (Required)");
                docID = ad.nextLine();
                for (int i = 0; i < myList.size(); i++){
                    if (myList.get(i).getDocId().equals(docID)){
                        controlID = true;
                    }
                }
                if (controlID && docID.length()>1){
                    System.out.println("Cant registre another employee with the same" +
                            " DocID");
                    docID = "";
                }
            } while (docID.equals(""));
            String user = "";
            do {
                System.out.println("User: (Required)");
                user = ad.nextLine();
            }while(user.equals(""));
            String pass = "";
            do {
                System.out.println("Password: (Required)");
                pass = ad.nextLine();
            }while (pass.equals(""));
            System.out.println("Departament: ");
            String dep = ad.nextLine();
            do {
                System.out.println("Phone: ");
                String phone = ad.nextLine();
                if (phone.length() > 0) {
                    try {
                        auxPhone = Integer.parseInt(phone);
                        itsOK = true;
                    } catch (Exception x) {
                        System.out.println("Need Number Phone");
                    }
                } else {
                    phone = "";
                }
            } while (!itsOK);

            System.out.println("Hired Hours:");
            int hours = ad.nextInt();

            calendar = new Calendar(hours, 0, 0, 0,
                    "Not take yet", false, false);

            e = new Employee(name.toUpperCase(), surname.toUpperCase(), address,
                    docID.toUpperCase(), auxPhone, calendar, user, pass, dep);
            System.out.println("Registred employee");
            myList.add(e);
        }
        else{
            System.out.println("Restricted Access");
        }
    }

    /**
     * This method add a take personal days and control how many days
     */
    private void takePersonalDay(){ // CALL 3
        boolean searched = false;
        System.out.println("TAKE A PERSONAL DAY");
        Scanner tk = new Scanner(System.in);
        System.out.println("1.- Employee");
        System.out.println("2.- Manager");
        String inputOption = tk.nextLine();
        if (inputOption.equals("1")) {
            System.out.print("Your User: ");
            String userPD = tk.next();
            System.out.print("Your Password: ");
            String passPD = tk.next();
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i) instanceof Employee) {
                    if (((Employee) myList.get(i)).getUser().equals(userPD) &&
                            ((Employee) myList.get(i)).getPassword().equals(passPD)) {
                        if (myList.get(i).getCalendar().personalDay < myList.get(i)
                                .getCalendar().totalPersonalDays) {
                            System.out.print("Your reason: ");
                            String reason = tk.next();
                            myList.get(i).getCalendar().takePersonalDay();
                            myList.get(i).getCalendar().setReasonPersonalDay(reason);
                            myList.get(i).getCalendar().setTakeDaysP(true);
                            searched = true;
                            System.out.println("Registred day");
                        } else {
                            searched = true;
                            System.out.println("Cant take more 2 days for year");
                        }
                    }
                }
            }
            if (!searched) {
                System.out.println("Not found");
            }
        }
        else if (inputOption.equals("2")){
            System.out.print("Doc ID: ");
            String inputID = tk.next();
            boolean searchedM = false;
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).getDocId().equals(inputID)) {
                    if (myList.get(i).getCalendar().personalDay < myList.get(i)
                            .getCalendar().totalPersonalDays) {
                        System.out.print("Your reason: ");
                        String reason = tk.next();
                        myList.get(i).getCalendar().takePersonalDay();
                        myList.get(i).getCalendar().setReasonPersonalDay(reason);
                        myList.get(i).getCalendar().setTakeDaysP(true);
                        searchedM = true;
                        System.out.println("Registred day");
                    } else {
                        searchedM = true;
                        System.out.println("Cant take more 2 days for year");
                    }
                }
            }
            if (!searchedM) {
                System.out.println("Not found");
            }
        }
        else{
            System.out.println("Select 1 or 2");
        }
    }
    /**
     * This method add a take vacations and control how many days
     */
    private void takeVacation(){ // CALL 4
        System.out.println("TAKE VACATIONS");
        boolean searchV = false;
        Scanner tp = new Scanner(System.in);
        System.out.println("1.- Employee");
        System.out.println("2.- Manager");
        String inputOption = tp.nextLine();
        if (inputOption.equals("1")) {
            System.out.print("Your User: ");
            String userPD = tp.next();
            System.out.print("Your Password: ");
            String passPD = tp.next();
            for(Person e: myList){
                if (e instanceof Employee) {
                    if (((Employee) e).getUser().equals(userPD) && ((Employee) e).
                            getPassword().equals(passPD)) {
                        if (e.getCalendar().getVacationDay() <
                                e.getCalendar().getTotalVacationDays()) {
                            System.out.print("How many days?: ");
                            int numberDay = tp.nextInt();
                            if (numberDay < e.getCalendar().getMinDaysVacation()) {
                                System.out.println("Min days = 4");
                                searchV = true;
                            } else if (e.getCalendar().getVacationDay() + numberDay >
                                    e.getCalendar().getTotalVacationDays()) {
                                System.out.println("Only can take 30 days for " +
                                        "year of work");
                                searchV = true;
                            } else {
                                e.getCalendar().takeVacation(numberDay);
                                e.getCalendar().setTakeVacation(true);
                                searchV = true;
                                System.out.println("Registred vacations");
                            }
                        } else {
                            System.out.println("Only can take 30 days for year of work");
                        }
                    }
                }
            }
            if (!searchV) {
                System.out.println("Not found");
            }
        }
        else if (inputOption.equals("2")){
            System.out.print("Doc ID: ");
            String inputID = tp.next();
            boolean searchedM = false;
            for (Person e: myList){
                if (e instanceof Manager){
                    if (e.getDocId().equals(inputID)) {
                        if (e.getCalendar().getVacationDay() <
                                e.getCalendar().getTotalVacationDays()) {
                            System.out.print("How many days?: ");
                            int numberDay = tp.nextInt();
                            if (numberDay < e.getCalendar().getMinDaysVacation()) {
                                System.out.println("Min days = 4");
                                searchedM = true;
                            } else if (e.getCalendar().getVacationDay() + numberDay >
                                    e.getCalendar().getTotalVacationDays()) {
                                System.out.println("Only can take 30 days for year of work");
                                searchedM = true;
                            } else {
                                e.getCalendar().takeVacation(numberDay);
                                e.getCalendar().setTakeVacation(true);
                                searchedM = true;
                                System.out.println("Registred vacations");
                            }
                        } else {
                            System.out.println("Only can take 30 days for year of work");
                        }
                    }
                }

            }
            if (!searchedM) {
                System.out.println("Not found");
            }
        }
        else{
            System.out.println("Select 1 or 2");
        }
    }

    /**
     * Show stats about all employees
     */
    private void viewAllEmployees(){ // CALL 5
        boolean itsManager = false;
        Scanner fg = new Scanner(System.in);
        System.out.println("DATA EMPLOYEES");
        System.out.println("Doc ID Manager: ");
        String inputID = fg.nextLine();
        for (int i = 0; i < myList.size(); i++){
            if (myList.get(i) instanceof Manager){
                if (myList.get(i).getDocId().equals(inputID)){
                    itsManager = true;
                }
            }
        }
        if (itsManager) {
            for (Person p : myList) {
                if (p instanceof Employee){
                    System.out.println("Employee: ");
                    System.out.println(p.toString());
                }
                else if (p instanceof Manager){
                    System.out.println("Manager: ");
                    System.out.println(p.toString());
                }
            }
        }
        else{
            System.out.println("Restricted Access");
        }
    }

    /**
     * This method show how many hours worked all employees
     */
    private void lookHoursWorkedALlEmployees(){ // CALL 6
        Scanner aa = new Scanner(System.in);
        System.out.println("LOOK HOURS REALIZED");
        System.out.println("Doc ID Manager: ");
        String inputID = aa.nextLine();
        boolean itsManager = false;
        for (int i = 0; i < myList.size(); i++){
            if (myList.get(i) instanceof Manager){
                if (myList.get(i).getDocId().equals(inputID)){
                    itsManager = true;
                }
            }
        }
        if (itsManager) {
            for (Person p : myList) {
                if (p instanceof Employee) {
                    System.out.println("EMPLOYEE: " + p.getName() + ": " +
                            p.getCalendar().hoursWorked +
                            " hours.");
                }
                else if (p instanceof Manager){
                    System.out.println("MANAGER: " + p.getName() + ": " +
                            p.getCalendar().hoursWorked +
                            " hours.");
                }
            }
        }
        else{
            System.out.println("Restricted Access");
        }
    }

    /**
     * This method show how many free days
     */
    private void seeFreeDays() { // CALL 7
        boolean itsManager = false;
        Scanner bb = new Scanner(System.in);
        System.out.println("EMPLOYEES WITH PERSONAL DAYS");
        System.out.println("Doc ID Manager: ");
        String inputID = bb.nextLine();
        for (int i = 0; i < myList.size(); i++){
            if (myList.get(i) instanceof Manager){
                if ((myList.get(i)).getDocId().equals(inputID)){
                    itsManager = true;
                }
            }
        }
        if (itsManager) {
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).getCalendar().getTakeDaysP()) {
                    System.out.println(myList.get(i).getName() + ": " +
                            myList.get(i).getCalendar().getPersonalDay() + " days.");
                }
            }
        }
        else{
            System.out.println("Restricted Access");
        }
    }

    /**
     * This method show vacations
     */
    private void seeVacation(){ //CALL 8
        boolean itsManager = false;
        Scanner dd = new Scanner(System.in);
        System.out.println("EMPLOYEES WITH VACATIONS");
        System.out.println("Doc ID Manager: ");
        String inputID = dd.nextLine();
        for (int i = 0; i < myList.size(); i++){
            if (myList.get(i) instanceof Manager){
                if (((Manager)myList.get(i)).getDocId().equals(inputID)){
                    itsManager = true;
                }
            }
        }
        if (itsManager) {
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).getCalendar().getTakeVacation()) {
                    System.out.println(myList.get(i).getName() + ": " +
                            myList.get(i).getCalendar().getVacationDay() + " days.");
                }
            }
        }
        else{
            System.out.println("Restricted Access");
        }
    }

    /**
     * With this method can delete a employee
     */
    private void removeEmployee(){ // CALL 9
        boolean itsManager = false;
        Scanner ff = new Scanner(System.in);
        System.out.println("Doc ID employee for remove:");
        String removeEmployee = ff.next();
        boolean search = false;
        int  numberRemove = -1;
        System.out.println("REMOVE EMPLOYEE");
        System.out.println("Doc ID Manager: ");
        String inputID = ff.nextLine();
        for (int i = 0; i < myList.size(); i++){
            if (myList.get(i) instanceof Manager){
                if (myList.get(i).getDocId().equals(inputID)){
                    itsManager = true;
                }
            }
        }
        if (itsManager) {
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).getDocId().equals(removeEmployee)) {
                    numberRemove = i;
                    search = true;
                }
            }
            if (!search) {
                System.out.println("Not found");
            } else {
                System.out.println(myList.get(numberRemove));

                System.out.println("Remove? Y/N");
                String confirm = ff.next();

                if (confirm.toUpperCase().equals("Y")) {
                    myList.remove(numberRemove);
                    System.out.println("Delete completed");
                } else {
                    System.out.println("Deletion not completed");
                }
            }
        }
        else{
            System.out.println("Restricted Access");
        }
    }

    /**
     * This method changed a data
     */
    private void configDataPerson(){ //CALL 10
        int numberChange = -1;
        int auxPhone = 0;
        boolean searchData = false;
        boolean itsManager = false;
        String confirm;
        Scanner dd = new Scanner(System.in);
        System.out.println("CHANGE PERSONAL DATA");
        System.out.println("Doc ID Manager: ");
        String inputID = dd.nextLine();
        for (int i = 0; i < myList.size(); i++){
            if (myList.get(i) instanceof Manager){
                if (myList.get(i).getDocId().equals(inputID)){
                    itsManager = true;
                }
            }
        }
        if (itsManager) {
            System.out.println("Doc ID employee for change:");
            String changeData = dd.nextLine();
            System.out.println("PRESS \"Y\" FOR CHANGE");
            for (int i = 0; i < myList.size(); i++){
                if (myList.get(i).getDocId().equals(changeData)){
                    numberChange = i;
                    searchData = true;
                }
            }
            if (!searchData){
                System.out.println("Not found");
            }
            else {
                System.out.println(myList.get(numberChange).getSurname().
                        toUpperCase() + ", " + myList.get(numberChange).getName().
                        toUpperCase());
                System.out.println("Address: " +
                        myList.get(numberChange).getAddress());
                System.out.println("Change?: ");
                confirm = dd.nextLine().toUpperCase();
                if (confirm.equals("Y")) {
                    System.out.println("New address: ");
                    String newAd = dd.nextLine();
                    myList.get(numberChange).setAddress(newAd);
                } else {
                    System.out.println("Not changed");
                }
                System.out.println("Number Phone: " +
                        myList.get(numberChange).getNumberPhone());
                System.out.println("Change?: ");
                confirm = dd.nextLine().toUpperCase();
                if (confirm.equals("Y")) {
                    System.out.println("New Number Phone:");
                    String phone = dd.nextLine();
                    auxPhone = Integer.parseInt(phone);
                    myList.get(numberChange).setNumberPhone(auxPhone);
                } else {
                    System.out.println("Not changed");
                }
                System.out.println("Departament: " +
                        ((Employee)myList.get(numberChange)).getDepartmen());
                System.out.println("Change?: ");
                confirm = dd.nextLine().toUpperCase();
                if (confirm.equals("Y")) {
                    System.out.println("New Departament: ");
                    String dep = dd.nextLine();
                    ((Employee)myList.get(numberChange)).setDepartmen(dep);
                } else {
                    System.out.println("Not changed");
                }
                System.out.println("Hours hired: " +
                        myList.get(numberChange).getCalendar().hiredHours);
                System.out.println("Change?: ");
                confirm = dd.nextLine().toUpperCase();
                if (confirm.equals("Y")) {
                    System.out.println("New Hours hired: ");
                    String newHours = dd.nextLine();
                    try {
                        int auxHour = Integer.parseInt(newHours);
                        myList.get(numberChange).getCalendar().setHiredHours(auxHour);
                    } catch (Exception e) {
                        System.out.println("Need number hours");
                    }
                } else {
                    System.out.println("Not changed");
                }
                System.out.println("Registred changes");
            }
        }
        else{
            System.out.println("Restricted Access");
        }
    }
}

