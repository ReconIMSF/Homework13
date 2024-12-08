import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String parentName;
    private final String lastName;
    private int subdivision;
    private int salary;
    static int count;
    int id;

    public Employee(String firstName, String parentName, String lastName, int subdivision, int salary) {
        this.firstName = firstName;
        this.parentName = parentName;
        this.lastName = lastName;
        this.subdivision = subdivision;
        this.salary = salary;
        this.id = count++;
    }


    public static int id(int i) {
        i++;
        return i;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getParentName() {
        return parentName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSubdivision() {
        return subdivision;
    }

    public int getSalary() {
        return salary;
    }

    public int getCount() {
        return count;
    }

    public void setSubdivision(int subdivision) {
        this.subdivision = subdivision;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + firstName + " "
                + parentName + " "
                + lastName +
                ", отдел " + subdivision +
                ", зарплата " + salary;
    }

    public String toStringSubd() {
        return id + " " + firstName + " "
                + parentName + " "
                + lastName +
                ", зарплата " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return subdivision == employee.subdivision && salary == employee.salary && id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(parentName, employee.parentName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, parentName, lastName, subdivision, salary, id);
    }

}
