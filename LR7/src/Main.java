class Course {
    String name;
    int duration;
    int students;

    static int totalCourses = 0;
    static int totalStudents = 0;

    public Course(String name, int duration, int students) {
        this.name = name;
        this.duration = duration;
        this.students = students;
        totalCourses++;
        totalStudents += students;
    }

    public static double getAverageStudents() {
        if (totalCourses == 0) {
            return 0.0;
        }
        return (double) totalStudents / totalCourses;
    }
}

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course("Java", 48, 25);
        Course course2 = new Course("Python", 36, 30);
        Course course3 = new Course("Web", 40, 20);
        Course course4 = new Course("SQL", 24, 15);

        System.out.println("Среднее число студентов на курсах: " + Course.getAverageStudents());
    }
}