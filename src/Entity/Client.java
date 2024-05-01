package Entity;

import java.time.LocalDate;
import java.time.Period;

public class Client {
    private String name;
    private LocalDate birthdate;
    private String address;
    private Ticket ticket;
    private Pet pet;

    public Client(String name, LocalDate birthdate, String address) {
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
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
