package org.example;

public class Editor extends Software {
    private String format;

    public Editor(String name, String version, double price, String format) {
        super(name, version, price);
        this.format = format;
    }

    public String getFormat() { return format; }

    @Override
    public String getRequirements() {
        return "Низкие требования";
    }
}
