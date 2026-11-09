import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public boolean isExcellent() {
        return rating >= 8.0;
    }
}

class Store {
    String name;
    double area;
    int employees;

    public Store(String name, double area, int employees) {
        this.name = name;
        this.area = area;
        this.employees = employees;
    }
}

enum ExamResult {
    PASS, FAIL, EXCELLENT
}

class Exam {
    String subject;
    ExamResult result;

    public Exam(String subject, ExamResult result) {
        this.subject = subject;
        this.result = result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задания ");
        int task = scanner.nextInt();

        switch (task) {
            case 1:
                Movie movie = new Movie("Inception", "Christopher Nolan", 2010, 8.8);
                System.out.println("Фильм: " + movie.title);
                System.out.println("Рейтинг: " + movie.rating);
                System.out.println("Является отличным (rating >= 8): " + movie.isExcellent());
                break;

            case 2:
                Store[] stores = {
                        new Store("Гипермаркет", 1500.0, 60),
                        new Store("Продукты у дома", 120.0, 8),
                        new Store("Супермаркет", 800.0, 35),
                        new Store("Электроника", 450.0, 15),
                        new Store("ТЦ Столица", 3000.0, 120)
                };

                Store maxAreaStore = stores[0];
                Store maxEmpStore = stores[0];

                for (int i = 1; i < stores.length; i++) {
                    if (stores[i].area > maxAreaStore.area) {
                        maxAreaStore = stores[i];
                    }
                    if (stores[i].employees > maxEmpStore.employees) {
                        maxEmpStore = stores[i];
                    }
                }

                System.out.println("Магазин с максимальной площадью: " + maxAreaStore.name + " (" + maxAreaStore.area + " кв.м)");
                System.out.println("Магазин с максимальным количеством сотрудников: " + maxEmpStore.name + " (" + maxEmpStore.employees + " чел.)");
                break;

            case 3:
                Exam[] exams = {
                        new Exam("Математика", ExamResult.EXCELLENT),
                        new Exam("Физика", ExamResult.PASS),
                        new Exam("История", ExamResult.FAIL),
                        new Exam("Программирование", ExamResult.EXCELLENT),
                        new Exam("Химия", ExamResult.PASS),
                        new Exam("Английский язык", ExamResult.EXCELLENT)
                };

                System.out.println("Экзамены с результатом EXCELLENT:");
                for (Exam exam : exams) {
                    if (exam.result == ExamResult.EXCELLENT) {
                        System.out.println("- " + exam.subject);
                    }
                }
                break;

            default:
                System.out.println("Введите число от 1 до 3.");
                break;
        }

        scanner.close();
    }
}