import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Employee {
    String fullname;
    double salary;

    public Employee(String fullname, double salary) {
        this.fullname = fullname;
        this.salary = salary;
    }
}

class Report {
    public static void generateReport(Employee[] employees) {
        for (Employee emp : employees) {
            System.out.printf(emp.fullname, emp.salary);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int task = scanner.nextInt();
        scanner.nextLine();

        switch (task) {
            case 1:
                String str1 = scanner.nextLine();
                boolean res1 = str1.contains("Java");
                System.out.println(res1);
                break;

            case 2:
                String str2 = scanner.nextLine();
                String cleaned = str2.replace(" ", "").toLowerCase();
                String reversed = new StringBuilder(cleaned).reverse().toString();
                boolean res2 = cleaned.equals(reversed);
                System.out.println(res2);
                break;

            case 3:
                Employee[] employees = {
                        new Employee("Иванов", 1250.5),
                        new Employee("Петров", 3400.0),
                        new Employee("Сидоров", 890.75)
                };
                Report.generateReport(employees);
                break;

            case 4:
                String text = "a1a a2b a3c a4d a5e";
                Pattern pattern = Pattern.compile("a\\d[b-e]");
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    System.out.println(matcher.group());
                }
                break;

            default:
                break;
        }

        scanner.close();
    }
}