package Entity;

import java.time.LocalDateTime;

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
                Fecha y Hora: \{ this.created.toString() }

                Datos del Adoptante:
                Nombre: \{ this.client.getName() }
                Edad: \{ this.client.getAge() }
                Dirección: \{ this.client.getAddress() }

                Datos de la Mascota:
                Nombre: \{ this.pet.getName() }
                Fecha de Nacimiento: \{ this.pet.getBirthdate().toString() }
                Peso: \{ this.pet.getWeight() }
                Especie: \{ this.pet.getKind().toString() }
                Recomendaciones de Cuidado: \{ this.pet.getCareRecommendation() }

                Empleado Encargado:
                Nombre: \{ this.employee.getName() }
                Cargo: \{ this.employee.getRole() }
                -----------------------------------------
                ¡Gracias por adoptar a una mascota!
                -----------------------------------------
                """;
    }
}
