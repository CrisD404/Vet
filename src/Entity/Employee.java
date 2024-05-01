package Entity;

public class Employee {
    private static Employee instance;
    private String name;
    private String lastName;
    private String role;
    private String age;

    private Employee(String name, String lastName, String role, String age) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.age = age;
    }

    public static Employee getInstance(String name, String lastName, String role, String age) {
        if(instance == null) {
            instance = new Employee(name, lastName, role, age);
        }
        return instance;
    }

    public static Employee getInstance() {
        return  instance;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return STR."Nombre: \{this.name} \nApellido: \{this.lastName} \nEdad \{this.age}";
    }
}
