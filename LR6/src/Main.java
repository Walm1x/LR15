class Student {
    private String name;
    private int age;
    private String group;
    private int quantity;


    public int getQuantity(){
    return quantity;}

   public void setQuantity(int quantity){
   this.quantity = quantity;
   }

   public Student(String name, int age, String group, int quantity){
        this(name, age, group );
        this.quantity = quantity;
    }
/*
    Student student1 = new student ("Виталик" , 18 , "т - 876543" , 1);

     */
//написать конструктор с 4 полями и внутри с quantity

















    public Student(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void displayInfo() {
        System.out.println("имя " + name + " возраст " + age + " группа " + group);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Алексей", 20, "Т-2723");
        Student student2 = new Student("Мария", 19, "Т-2456");

        student1.displayInfo();
        student2.displayInfo();
    }
}