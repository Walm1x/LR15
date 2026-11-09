package org.example;

public class Moon implements Orbitable, Explorable {
    private String name;
    private double orbitTime;
    private String planet;
    private String resources;

    public Moon(String name, double orbitTime, String planet, String resources) {
        this.name = name;
        this.orbitTime = orbitTime;
        this.planet = planet;
        this.resources = resources;
    }

    public String getName() { return name; }
    public double getOrbitTime() { return orbitTime; }
    public String getPlanet() { return planet; }

    @Override
    public void orbit() {
        System.out.println("Луна " + name + " вращается вокруг планеты " + planet);
    }

    @Override
    public void explore() {
        System.out.println("Проводится исследование спутника " + name);
    }

    @Override
    public String getResources() {
        return resources;
    }

    public void displayInfo() {
        System.out.println("плагета луна " + name + ", период орбиты " + orbitTime + " дней   планета " + planet + " ресурсы планетные  " + resources);
    }
}