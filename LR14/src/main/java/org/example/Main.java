package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1");
        task1();

        System.out.println("\n2");
        task2(scanner);

        System.out.println("\n3");
        task3();

        System.out.println("\n4");
        task4(scanner);

        System.out.println("\n5");
        task5();

        scanner.close();
    }

    public static void task1() {
        String fileName = "beverage.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Любимый напиток эспрессошейк");
            writer.println("Горячий частично");
            writer.println("Без сахара");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(fileName);
        System.out.println("Имя файла " + file.getName());
        System.out.println("Путь " + file.getAbsolutePath());
        System.out.println("Размер " + file.length() + " байт");
        System.out.println("Существует " + file.exists());

        System.out.println("Содержимое файла");
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task2(Scanner scanner) {
        String fileName = "f2.txt";
        System.out.println("Введите 10 целых чисел");
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < 10; i++) {
                System.out.print("Число " + (i + 1) + ": ");
                int num = scanner.nextInt();
                writer.println(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Считанные числа из файла и проверка");
        int count = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                int num = Integer.parseInt(line);
                System.out.print(num + " ");
                if (num % 2 == 0 && num % 3 != 0) {
                    count++;
                }
            }
            System.out.println("\nКоличество чисел, кратных 2 и не кратных" + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task3() {
        String fFile = "f3.txt";
        String gFile = "g3.txt";
        String hFile = "h3.txt";
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fFile))) {
            for (int i = 0; i < 15; i++) {
                writer.println(random.nextInt(100) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writerG = new PrintWriter(new FileWriter(gFile));
             PrintWriter writerH = new PrintWriter(new FileWriter(hFile))) {
            List<String> lines = Files.readAllLines(Paths.get(fFile));
            for (String line : lines) {
                int num = Integer.parseInt(line);
                if (num % 3 == 0 && num % 5 != 0) {
                    writerG.println(num);
                } else {
                    writerH.println(num);
                }
            }
            System.out.println("Файлы g3.txt и h3.txt успешно сформированы");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task4(Scanner scanner) {
        String fileName = "f4.txt";
        System.out.println("Введите 12 вещественных значений кислотности рН");
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < 12; i++) {
                System.out.print("pH " + (i + 1) + ": ");
                double ph = scanner.nextDouble();
                writer.println(ph);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            double sum = 0;
            for (String line : lines) {
                sum += Double.parseDouble(line);
            }
            double average = lines.isEmpty() ? 0 : sum / lines.size();
            System.out.printf("Среднее значение pH: %.2f\n", average);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task5() {
        String fileName = "f5.txt";
        Random random = new Random();
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < 10; i++) {
                writer.println(random.nextInt(60));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            System.out.println("Сгенерированные числа в файле f5.txt");
            for (String line : lines) {
                int num = Integer.parseInt(line);
                System.out.print(num + " ");
                if (num < 30) {
                    count++;
                }
            }
            System.out.println("\nКоличество чисел, меньших 30 " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}