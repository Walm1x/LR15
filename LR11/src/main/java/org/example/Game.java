package org.example;

public class Game extends Software {
    private String genre;

    public Game(String name, String version, double price, String genre) {
        super(name, version, price);
        this.genre = genre;
    }

    public String getGenre() { return genre; }

    @Override
    public String getRequirements() {
        return "Высокие требования";
    }
}
