public class ParamTest {
    public static void main (String[] args) {
        /*
        * Test1. Methods can't change number valuse
        */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        //tripleValue(percent);
        System.out.println();

        /*
        * Test 2: methods can change object state
        */
        System.out.println("\nTesting tripleSalary");
        //Employee harry = new Employee("Harry", 50000);
        //System.out.println("Before: salary=" + harry.getSalary());
        //tripleSalary(harry);
        //System.out.println("After: salary=" + harry.getSalary());

        /*
        * Test 3: methods can'r attach new objects to objects parameters
        */
        System.out.println("\nTesting swap:");
        //Employee a = new Employee("Alice", 70000);
        //Employee b = new Employee("Bob", 60000);
        System.out.println();
        }
    }
//}