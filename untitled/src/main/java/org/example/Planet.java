package org.example;

public class Planet implements Orbitable, Explorable {
    private String name;
    private double orbitTime;
    private String resources;

    public Planet(String name, double orbitTime, String resources) {
        this.name = name;
        this.orbitTime = orbitTime;
        this.resources = resources;
    }

    public String getName() { return name; }
    public double getOrbitTime() { return orbitTime; }
    public String getResources() { return resources; }

    @Override
    public void orbit() {
        System.out.println("Планета " + name + " вращается по орбите вокруг звезды.");
    }

    @Override
    public void explore() {
        System.out.println("Проводится сканирование и исследование планеты " + name);
    }

    public void displayInfo() {
        System.out.println("Планета: " + name + ", Период орбиты: " + orbitTime + " дней, Ресурсы: " + resources);
    }
}