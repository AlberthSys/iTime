//CLASS FOR CREATE FILE

package main;

import data.*;
import data.Calendar;

import java.io.*;
import java.util.*;;

public class FileUtils {
    public ArrayList<Person> loadStats() {
        ArrayList<Person> myList = new ArrayList<>();
        BufferedReader br;
        String line;
        String[] aux;
        Calendar calendar;
        Employee employee;
        Manager manager;
        if (!(new File("stats.txt")).exists() ) {
            return myList;
        }
        else {
            try {
                br = new BufferedReader(new FileReader("stats.txt"));
                while ((line = br.readLine()) != null) {
                    aux = line.split(";");
                    String name = aux[0];
                    String surname = aux[1];
                    String address = aux[2];
                    String docID = aux[3];
                    int numberPhone = Integer.parseInt(aux[4]);
                    int hiredHours = Integer.parseInt(aux[5]);
                    int hoursWorked = Integer.parseInt(aux[6]);
                    int personalDay = Integer.parseInt(aux[7]);
                    int vacationDays = Integer.parseInt(aux[8]);
                    String reason = aux[9];
                    boolean takePersonal = Boolean.parseBoolean(aux[10]);
                    boolean takeVacation = Boolean.parseBoolean(aux[11]);
                    if (aux.length > 14) {
                        String user = aux[12];
                        String pass = aux[13];
                        String departament = aux[14];
                        calendar = new Calendar(hiredHours, hoursWorked, personalDay,
                                vacationDays, reason, takePersonal, takeVacation);
                        employee = new Employee(name, surname, address, docID, numberPhone, calendar,
                                user, pass, departament);
                        myList.add(employee);
                    } else {
                        String area = aux[12];
                        String level = aux[13];
                        calendar = new Calendar(hiredHours, hoursWorked, personalDay,
                                vacationDays, reason, takePersonal, takeVacation);
                        manager = new Manager(name, surname, address, docID, numberPhone, calendar,
                                area, level);
                        myList.add(manager);
                    }
                }
                br.close();
                return myList;
            } catch (IOException fileError) {
                System.out.println("Error: " + fileError.getMessage());
            } catch (ArrayIndexOutOfBoundsException r) {
                System.out.println("Error: check your data 1: " + r.getMessage());
            }
        }
        return myList;
    }

    public void saveStats(ArrayList<Person> myList) {
        String line = null;
        PrintWriter pr = null;
        Collections.sort(myList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        if ((new File("stats.txt")).exists() ) {
            File Obj = new File("stats.txt");
            Obj.delete();
        }
        if (myList.size() > 0){
            try {
                pr = new PrintWriter(new BufferedWriter
                        (new FileWriter("stats.txt", true)));
                for (Person e: myList) {
                    if (e instanceof Manager) {
                        Person aux = (Manager) e;
                        line = e.getName() + ";" + e.getSurname() + ";" + e.getAddress()
                                + ";" + e.getDocId() + ";" + e.getNumberPhone() + ";" +
                                e.getCalendar().getHiredHours() + ";" +
                                e.getCalendar().getHoursWorked() + ";" +
                                e.getCalendar().getPersonalDay() + ";" +
                                e.getCalendar().getVacationDay() + ";" +
                                e.getCalendar().getReasonPersonalDay() + ";" +
                                e.getCalendar().getTakeDaysP() + ";" +
                                e.getCalendar().getTakeVacation() + ";" +
                                ((Manager) e).getArea() + ";" +
                                ((Manager) e).getLevel();
                        pr.println(line);

                    } else if (e instanceof Employee) {
                        line = e.getName() + ";" + e.getSurname() + ";" + e.getAddress()
                                + ";" + e.getDocId() + ";" + e.getNumberPhone() + ";" +
                                e.getCalendar().getHiredHours() + ";" +
                                e.getCalendar().getHoursWorked() + ";" +
                                e.getCalendar().getPersonalDay() + ";" +
                                e.getCalendar().getVacationDay() + ";" +
                                e.getCalendar().getReasonPersonalDay() + ";" +
                                e.getCalendar().getTakeDaysP() + ";" +
                                e.getCalendar().getTakeVacation() + ";" +
                                ((Employee) e).getUser() + ";" +
                                ((Employee) e).getPassword() + ";" +
                                ((Employee) e).getDepartmen();
                        pr.println(line);
                    }
                }
                pr.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (pr != null){
                    pr.close();
                }
            }
        }
        else{
            System.out.println("No exist program");
        }
    }
}
