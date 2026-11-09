package org.example;

public class Software {
    protected String name;
    protected String version;
    protected double price;

    public Software(String name, String version, double price) {
        this.name = name;
        this.version = version;
        this.price = price;
    }

    public String getName() { return name; }
    public String getVersion() { return version; }
    public double getPrice() { return price; }

    public void install() {
        System.out.println("Устанавливаю");
    }

    public void install(String path) {
        System.out.println("Устанавливаю в " + path);
    }

    public void install(int size) {
        System.out.println("Устанавливаю размером " + size + " ГБ");
    }

    public String getRequirements() {
        return "Стандартные требования";
    }

    public void displayInfo() {
        System.out.println("ПО " + name + " версия " + version + " цена " + price + " руб.");
    }
}