abstract class Weapon {
    private String name;
    private double damage;
    private double range;

    public Weapon(String name, double damage, double range) {
        this.name = name;
        this.damage = damage;
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public abstract void attack();
    public abstract String getType();

    public void displayInfo() {
        System.out.println("название " + name + "урон " + damage + "дальность " + range);
    }
}

class Sword extends Weapon {
    private double sharpness;

    public Sword(String name, double damage, double range, double sharpness) {
        super(name, damage, range);
        this.sharpness = sharpness;
    }

    public double getSharpness() {
        return sharpness;
    }

    public void setSharpness(double sharpness) {
        this.sharpness = sharpness;
    }

    @Override
    public void attack() {
        System.out.println("рубящий удар");
    }

    @Override
    public String getType() {
        return "Холодное оружие";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("острота " + sharpness + "тип " + getType());
    }
}

class Bow extends Weapon {
    private int arrows;

    public Bow(String name, double damage, double range, int arrows) {
        super(name, damage, range);
        this.arrows = arrows;
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    @Override
    public void attack() {
        System.out.println("стрельба из лука");
    }

    @Override
    public String getType() {
        return "Метательное оружие";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("колво стрел " + arrows + "тип " + getType());
    }
}

public class Main {
    public static void main(String[] args) {
        Weapon[] weapons = {
                new Sword("обычный меч", 85.5, 1.5, 95.0),
                new Sword("японский меч", 70.0, 1.2, 98.0),
                new Sword("Ржавый меч", 40.0, 1.0, 45.5),
                new Bow("Охотничий лук", 50.0, 40.0, 20),
                new Bow("какаой-нибудь другой лук", 65.0, 60.0, 30)
        };

        for (Weapon weapon : weapons) {
            weapon.displayInfo();
            weapon.attack();
            System.out.println("Тип оружия " + weapon.getType());
        }

    }
}