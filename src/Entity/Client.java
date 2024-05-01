package Entity;

import Interface.Person;

import java.time.LocalDate;
import java.time.Period;

public class Client implements Person {
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String address;
    private Ticket ticket;
    private Pet pet;

    public Client(String name, String lastName, LocalDate birthdate, String address) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() { return ticket; };

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }
}
