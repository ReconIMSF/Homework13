//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;

public class Main {

    private final static Random RANDOM = new Random();
    static int searchSubdivision = RANDOM.nextInt(1, 6);
    static int percent = RANDOM.nextInt(5, 15);
    static int randSalary = RANDOM.nextInt(80_000, 105_000);
//    private final static String[] FIRSTNAMES = {"Андрей", "Сергей", "Алексей", "Дмитрий", "Олег", "Пётр", "Иван"}
//    private final static String[] PARENTNAMES = {"Андреевич", "Сергеевич", "Алексеевич", "Дмитриевич", "Олегович", "Петрович", "Иванович"}
//    private final static String[] LASTNAMES = {"Андреев", "Сергеев", "Алексеев", "Дмитриев", "Сидоров", "Петров", "Иванов"}
    public static Employee[] employee = new Employee[10];

//
//    public static void initEmployees() {
//        for (int i = 0; i < employee.length; i++) {
//            String fullName = LASTNAMES[RANDOM.nextInt(0,LASTNAMES.length)] + " " +
//                    FIRSTNAMES[RANDOM.nextInt(0, FIRSTNAMES.length)] + " " +
//                    PARENTNAMES[RANDOM.nextInt(0, LASTNAMES.length)] + " ";
//            employee[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50_000, 100_000));
//        }
//    }

//    public static int getCurrentSize (Employee) {
//        return employee.length;
//    }

    public static int calculateTotalSalary() {
        int totalSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            totalSalary += employee[i].getSalary();
        }
        return totalSalary;
    }

    public static void findMinSalary() {
        int minSalary = employee[0].getSalary();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < minSalary) {
                minSalary = employee[i].getSalary();
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() == minSalary) {
                System.out.println("Cотрудник с минимальной зарплатой " + employee[i]);
            }
        }
    }

    public static void findMaxSalary() {
        int maxSalary = employee[0].getSalary();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() > maxSalary) {
                maxSalary = employee[i].getSalary();
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() == maxSalary) {
                System.out.println("Cотрудник с наибольшей зарплатой " + employee[i]);
            }
        }
    }

    public static int middleSalary() {
        int midSalary = calculateTotalSalary()/employee.length;
        return midSalary;
    }
    public static void salaryIndex(int percent) {
        System.out.println("Индексация зарплаты сотрудников");
        for (int i = 0; i < employee.length; i++) {
            employee[i].setSalary((int) (employee[i].getSalary() + employee[i].getSalary() * percent/100));
        }
    }

    public static void printSubdivision(int searchSubdivision) {
        System.out.println("Сотрудники отдела " + searchSubdivision);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSubdivision() == searchSubdivision) {
                System.out.println(employee[i].toStringSubd());
            }
        }
    }

    public static void subdFindMinSalary(int searchSubdivision) {
        int subdMinSalary = employee[0].getSalary();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSubdivision() == searchSubdivision && employee[i].getSalary() < subdMinSalary) {
                subdMinSalary = employee[i].getSalary();
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() == subdMinSalary) {
                System.out.println("Cотрудник отдела " + searchSubdivision
                        + " с минимальной зарплатой " + employee[i].toStringSubd());
            }
        }
    }
    public static void subdFindMaxSalary(int searchSubdivision) {
        int subdMaxSalary = employee[0].getSalary();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSubdivision() == searchSubdivision && employee[i].getSalary() > subdMaxSalary) {
                subdMaxSalary = employee[i].getSalary();
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() == subdMaxSalary) {
                System.out.println("Cотрудник отдела " + searchSubdivision
                        + " с наибольшей зарплатой " + employee[i].toStringSubd());
            }
        }
    }

    public static int findSubdTotalSalary(int searchSubdivision) {
        int subdTotalSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSubdivision() == searchSubdivision) {
                subdTotalSalary += employee[i].getSalary();
            }
        }
        return subdTotalSalary;
    }

    public static int subdMiddleSalary(int searchSubdivision) {
        int subdEmployees = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSubdivision() == searchSubdivision) {
                subdEmployees += 1;
            }
        }
        int subdMidSalary = findSubdTotalSalary(searchSubdivision)/subdEmployees;
        return subdMidSalary;
    }

    public static void subdSalaryIndex(int searchSubdivision, int percent) {
        System.out.println("Индексация зарплаты сотрудников отдела " + searchSubdivision);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSubdivision() == searchSubdivision) {
                employee[i].setSalary((int) (employee[i].getSalary() + employee[i].getSalary() * percent/100));
            }
        }
    }

    public static void findSalaryLess(int randSalary) {
        System.out.println("Ищем сотрудников с зарплатой меньше, чем " + randSalary);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < randSalary) {
                System.out.println(employee[i].toStringSubd());
            }
        }
    }

    public static void findSalaryExceed(int randSalary) {
        System.out.println("Ищем сотрудников с зарплатой, равной или больше, чем " + randSalary);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() >= randSalary) {
                System.out.println(employee[i].toStringSubd());
            }
        }
    }

    public static void main(String[] args) {
        //initEmployees();
        employee[0] = new Employee("Сергей", "Алексеевич", "Филлипов", 1, 97_000);
        employee[1] = new Employee("Николай", "Рубенович", "Матвеев", 4, 85_000);
        employee[2] = new Employee("Мария", "Семёновна", "Агниец", 2, 89_000);
        employee[3] = new Employee("Ксения", "Александровна", "Гулич", 3, 100_500);
        employee[4] = new Employee("Алексей", "Максимович", "Гуреев", 1, 102_000);
        employee[5] = new Employee("Александра", "Васильевна", "Викулова", 2, 80_000);
        employee[6] = new Employee("Егор", "Артемович", "Матросов", 3, 91_000);
        employee[7] = new Employee("Пётр", "Адамович", "Карпов", 4, 99_000);
        employee[8] = new Employee("Анна", "Викторовна", "Протасова", 5, 90_000);
        employee[9] = new Employee("Дмитрий", "Сергеевич", "Елистратов", 5, 105_000);

        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i]);
        }
        System.out.println("Сумма затрат на зарплату " + calculateTotalSalary());
        findMinSalary();
        findMaxSalary();
        System.out.println("Средняя зарплата сотрудников " + middleSalary());
        salaryIndex(percent);
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i].toString());
        }
        System.out.println(" ");
        printSubdivision(searchSubdivision);
        System.out.println(" ");
        subdFindMinSalary(searchSubdivision);
        System.out.println(" ");
        subdFindMaxSalary(searchSubdivision);
        System.out.println("Средняя зарплата сотрудников в отделе "
                + subdMiddleSalary(searchSubdivision));
        System.out.println("Сумма затрат на зарплату по отделу " + findSubdTotalSalary(searchSubdivision));
        subdSalaryIndex(searchSubdivision, percent);
        printSubdivision(searchSubdivision);
        System.out.println(" ");
        findSalaryLess(randSalary);
        System.out.println(" ");
//        findSalaryExceed(randSalary);
    }
}