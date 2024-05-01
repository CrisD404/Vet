package Interface;

import Entity.Client;
import Entity.Pet;
import Entity.Ticket;
import Exception.ExoticPetException;
import Exception.IllegalPetException;
import Enum.KindE;

import java.time.LocalDate;

public interface AdoptionManagementI {
    Ticket createPetAdoption(Client client, Pet pet) throws ExoticPetException;
    void registerPet(KindE kind, String name, LocalDate birthdate, String color, Double weight) throws IllegalPetException;
}
