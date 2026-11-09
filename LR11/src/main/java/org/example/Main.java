package org.example;

public class Main {
    public static void main(String[] args) {
        Software game = new Game("CyberGame", "2.1", 120.0, "RPG");
        Software editor = new Editor("PhotoEditor", "5.0", 45.0, "Graphics");

        game.install();
        game.install("C:/Games/CyberGame");
        game.install(45);

        System.out.println();
        editor.install();
        editor.install("D:/Programs/Editor");
        editor.install(3);

        Software[] softwares = { game, editor };

        for (Software sw : softwares) {
            sw.displayInfo();
            System.out.println("Системные требования " + sw.getRequirements());
        }
    }
}