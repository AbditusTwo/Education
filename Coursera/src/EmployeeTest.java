import java.util.*;

public class EmployeeTest {
    public static void main(String[] args) {
        //fill massive staff with 3 objects Employee
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10 ,1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        //increase salary by 5%
        for (Employee e : staff)
            e.raiseSalary(5);

        //show data for all objects of type Employee
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", hireDay=" + e.getHireDay());
    }
}

class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month -1, day);
        //In GregorianCalendar class Jan is 0
        hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}