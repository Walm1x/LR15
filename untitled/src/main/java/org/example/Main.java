package org.example;
import java.util.HashMap;
import java.util.Map;

class Device {
    private String model;
    private int id;
    private double power;

    public Device(String model, int id, double power) {
        this.model = model;
        this.id = id;
        this.power = power;
    }

    public String getModel() { return model; }
    public int getId() { return id; }
    public double getPower() { return power; }

    @Override
    public String toString() {
        return "ID: " + id + ", Модель: " + model + ", Мощность: " + power + " Вт";
    }
}

class Phone extends Device {
    private String camera;

    public Phone(String model, int id, double power, String camera) {
        super(model, id, power);
        this.camera = camera;
    }

    public String getCamera() { return camera; }

    @Override
    public String toString() {
        return super.toString() + ", Камера: " + camera;
    }
}

class Tablet extends Device {
    private double screen;

    public Tablet(String model, int id, double power, double screen) {
        super(model, id, power);
        this.screen = screen;
    }

    public double getScreen() { return screen; }

    @Override
    public String toString() {
        return super.toString() + ", Экран: " + screen + "\"";
    }
}

class Laptop extends Device {
    private int battery;

    public Laptop(String model, int id, double power, int battery) {
        super(model, id, power);
        this.battery = battery;
    }

    public int getBattery() { return battery; }

    @Override
    public String toString() {
        return super.toString() + ", Батарея: " + battery + " мАч";
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Device> deviceMap = new HashMap<>();

        deviceMap.put("iPhone 15", new Phone("iPhone 15", 101, 20.0, "48 Мп"));
        deviceMap.put("Galaxy S24", new Phone("Galaxy S24", 102, 25.0, "50 Мп"));
        deviceMap.put("Pixel 8", new Phone("Pixel 8", 103, 27.0, "50 Мп"));

        deviceMap.put("iPad Air", new Tablet("iPad Air", 201, 30.0, 10.9));
        deviceMap.put("Galaxy Tab S9", new Tablet("Galaxy Tab S9", 202, 45.0, 11.0));
        deviceMap.put("Xiaomi Pad 6", new Tablet("Xiaomi Pad 6", 203, 33.0, 11.0));

        deviceMap.put("MacBook Pro", new Laptop("MacBook Pro", 301, 140.0, 7000));
        deviceMap.put("ASUS ROG", new Laptop("ASUS ROG", 302, 240.0, 9000));

        for (Map.Entry<String, Device> entry : deviceMap.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + " | Значение: " + entry.getValue());
        }
    }
}