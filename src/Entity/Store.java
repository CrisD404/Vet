package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Exception.ExoticPetException;
import Exception.IllegalPetException;
import Enum.KindE;
import Interface.AdoptionManagementI;

public class Store implements AdoptionManagementI {
    List<Pet> pets = new ArrayList<>();
    List<Client> clients = new ArrayList<>();

    public List<Pet> showAvaiblePets(Predicate<Pet> filter) {
        if (filter == null) return pets;
        return pets.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    public Ticket createPetAdoption(Client client, Pet pet) throws ExoticPetException {
        if(pet.getKind() == KindE.DINOSAUR && LocalDateTime.now().getHour() < 23) {
            throw new ExoticPetException("Esta mascota es exótica, no está disponible. (pasar despues de las 23:00hs *guiño*)");
        }
        pets.remove(pet);
        clients.add(client);
        return new Ticket(client, pet, Employee.getInstance());
    }

    public void registerPet(KindE kind, String name, LocalDate birthdate, String color, Double weight) throws IllegalPetException {
        switch (kind) {
            case CAT -> pets.add(new Cat(name, birthdate, color, weight));
            case DOG -> pets.add(new Dog(name, birthdate, color, weight));
            case SNAKE -> pets.add(new Snake(name, birthdate, color, weight));
            case HAMSTER -> pets.add(new Hamster(name, birthdate, color, weight));
            case DINOSAUR -> pets.add(new Dinosaur(name, birthdate, color, weight));
            default -> throw new IllegalPetException("Aún no tenemos los recursos necesarios para hospedar esta mascota :(");
        }
    }

    public List<Client> getClients() {
        return clients;
    }

}
