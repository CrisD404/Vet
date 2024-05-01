package Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private LocalDateTime created;
    private Client client;
    private Pet pet;
    private Employee employee;

    public Ticket(Client client, Pet pet, Employee employee) {
        this.client = client;
        this.pet = pet;
        this.employee = employee;
        created = LocalDateTime.now();
        client.setTicket(this);
        client.setPet(pet);
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return STR."""
                -----------------------------------------
                TICKET DE ADOPCIÓN
                -----------------------------------------
                Fecha y hora: \{ this.created.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) }

                Datos del adoptante:
                Nombre: \{ this.client.getName() }
                Edad: \{ this.client.getAge() }
                Dirección: \{ this.client.getAddress() }

                Datos de la mascota:
                Nombre: \{ this.pet.getName() }
                Fecha de nacimiento: \{ this.pet.getBirthdate().toString() }
                Peso: \{ this.pet.getWeight() }
                Especie: \{ this.pet.getKind().toString() }
                Recomendaciones de cuidado: \{ this.pet.getCareRecommendation() }

                Empleado encargado:
                Nombre: \{ this.employee.getName() }
                Cargo: \{ this.employee.getRole() }
                -----------------------------------------
                ¡Gracias por adoptar a una mascota!
                -----------------------------------------
                """;
    }
}
