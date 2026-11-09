package org.example;

public class Main {
    public static void main(String[] args) {
        Orbitable[] bodies = {
                new Planet("Земля", 365.25, "Вода, Кислород, Металлы"),
                new Planet("Марс", 687.0, "Углекислый газ, Железо"),
                new Planet("Юпитер", 4333.0, "Водород, Гелий"),
                new Moon("Луна", 27.3, "Земля", "Реголит, Титан"),
                new Moon("Титан", 15.9, "Сатурн", "Азот, Углеводороды")
        };

        for (Orbitable body : bodies) {
            body.orbit();
            System.out.println("Время полного оборота: " + body.getOrbitTime() + " дней");

            if (body instanceof Explorable) {
                Explorable expBody = (Explorable) body;
                expBody.explore();
                System.out.println("Доступные ресурсы/данные " + expBody.getResources());
            }
        }
    }
}