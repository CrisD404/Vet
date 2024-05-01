package Entity;

import Interface.Person;

import java.time.LocalDate;

public class Employee implements Person {
    private static Employee instance;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String role;

    private Employee(String name, String lastName, String role, LocalDate birthdate) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.birthdate = birthdate;
    }

    public static Employee getInstance(String name, String lastName, String role, LocalDate birthdate) {
        if(instance == null) {
            instance = new Employee(name, lastName, role, birthdate);
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

    @Override
    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    @Override
    public String toString() {
        return STR."Nombre: \{this.getName()} \nApellido: \{this.getLastName()} \nEdad \{this.getAge()}";
    }
}
