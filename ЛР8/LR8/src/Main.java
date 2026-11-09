class Carrier {
    private String name;
    private double capacity;
    private double speed;

    public Carrier(String name, double capacity, double speed) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void deliver() {
        System.out.println("Доставка груза");
    }

    public void displayInfo() {
        System.out.println("Название: " + name + ", Грузоподъемность: " + capacity + ", Скорость: " + speed);
    }
}

class Ship extends Carrier {
    private double tonnage;

    public Ship(String name, double capacity, double speed, double tonnage) {
        super(name, capacity, speed);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public void deliver() {
        System.out.println("Перевозка по воде");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Тоннаж: " + tonnage);
    }

    public void anchor() {
        System.out.println(getName() + " отдал якорь.");
    }
}

class Truck extends Carrier {
    private int wheels;

    public Truck(String name, double capacity, double speed, int wheels) {
        super(name, capacity, speed);
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public void deliver() {
        System.out.println("Перевозка по суше");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Количество колес: " + wheels);
    }

    public void loadCargo() {
        System.out.println(getName() + " загружает груз в кузов.");
    }
}

public class Main {
    public static void main(String[] args) {
        Carrier[] carriers = new Carrier[5];
        carriers[0] = new Ship("Победа", 5000.0, 25.0, 1200.0);
        carriers[1] = new Ship("Аврора", 3000.0, 30.0, 800.0);
        carriers[2] = new Ship("Нептун", 7000.0, 22.0, 2000.0);
        carriers[3] = new Truck("Volvo", 20.0, 90.0, 8);
        carriers[4] = new Truck("MAN", 25.0, 85.0, 6);

        for (Carrier carrier : carriers) {
            carrier.displayInfo();
            carrier.deliver();
            if (carrier instanceof Ship) {
                ((Ship) carrier).anchor();
            } else if (carrier instanceof Truck) {
                ((Truck) carrier).loadCargo();
            }
        }
    }
}