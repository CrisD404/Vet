package Menu;

import Console.Console;
import Entity.*;
import Enum.KindE;

import Exception.IllegalPetException;
import Exception.ExoticPetException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.function.Predicate;

public class Menu {
    private final Store store = new Store();
    public Menu() {
        try {
            // Se hardcodean mascotas para mostrar funcionalidad.
            store.registerPet(KindE.SNAKE, "Serpentina", LocalDate.parse("2024-04-01"), "Verde", 4.10);
            store.registerPet(KindE.DOG, "Firulais", LocalDate.parse("2022-04-05"), "Negro", 6.14);
            store.registerPet(KindE.DOG, "Albondiga", LocalDate.parse("2014-11-12"), "Blanco", 6.24);
            store.registerPet(KindE.DOG, "Scooby doo", LocalDate.parse("2020-07-01"), "Café", 6.80);
            store.registerPet(KindE.CAT, "Gaturro", LocalDate.parse("1993-07-21"), "Naranja", 3.24);
            store.registerPet(KindE.CAT, "Macri", LocalDate.parse("1959-02-08"), "Gris", 3.10);
            store.registerPet(KindE.HAMSTER, "Pinky", LocalDate.parse("1990-08-12"), "Marrón", 0.94);
            store.registerPet(KindE.HAMSTER, "Cerebro", LocalDate.parse("1990-08-12"), "Blanco", 0.70);
            store.registerPet(KindE.DINOSAUR, "Mirta", LocalDate.parse("1700-01-12"), "Verde", 11740.15);
            Employee employee = this.register();
            this.mainMenu(employee);
        } catch (IllegalPetException e) {
            System.out.println(e.getMessage());
        }
    }

    private Employee register() {
        Console con = new Console("Formulario para ingreso de empleado");
        String name;
        String lastName;
        String role;
        String birthdate;
        do {
            con.print("Bienvenido, para continuar debe registrarse.");

            name = con.in("> Nombre");
            lastName = con.in("> Apellido");
            role = con.in("> Cargo");
            birthdate = con.in("> Fecha de nacimiento (aaaa-mm-dd) - (calcularemos tu edad)");

            con.print("Se guardará la siguiente información del empleado:")
                    .print(STR."Nombre: \{name} \nApellido: \{lastName} \nCargo: \{role} \nFecha de nacimiento: \{birthdate}");
        } while (!con.question("¿Es correcta? En caso contrario se volverá a preguntar."));

        try {
            return Employee.getInstance(name, lastName, role, LocalDate.parse(birthdate));
        }
        catch (DateTimeParseException e) {
            con.print("Fecha de nacimiento inválida, el formato deseado es aaaa-mm-dd. Por ejemplo: 2022-12-18 Argentina campeón del mundo.");
            return register();
        }
    }

    private void mainMenu(Employee employee) {
        boolean exit = false;
        Console con = new Console("Menú principal");
        do {
            con.print(STR."Bienvenido \{employee.getName()}")
                    .print("Por favor, seleccione una opción:")
                    .ln()
                    .print("1. Ver mascotas")
                    .print("2. Historial de adopciones")
                    .print("3. Mi información")
                    .ln()
                    .print("0. Salir");

            switch (con.inInt("> Ingrese una de las opciones disponibles")) {
                case 0:
                    exit = true;
                    con.print("¡Hasta la próxima! :)");
                    break;
                case 1:
                    exit = true;
                    petMenu();
                    break;
                case 2:
                    exit = true;
                    adoptionHistory();
                    break;
                case 3:
                    exit = true;
                    myProfile();
                    break;
                default:
                    con.print("Opción inválida, intente nuevamente");
                    break;
            }

        } while (!exit);

    }

    private void myProfile() {
        Console con = new Console("Mi perfil");
        Employee employee = Employee.getInstance();
        do {
            con.print(STR."""
                    Nombre: \{employee.getName()}
                    Apellido: \{employee.getLastName()}
                    Cargo: \{employee.getRole()}
                    Edad: \{employee.getAge()}
                    """);
        } while (!con.question("¿Desea volver?"));
        mainMenu(employee);
    }


    private void petMenu() {
        boolean exit = false;
        Console con = new Console("Mascotas");
        Predicate<Pet> filter = null;

        do {
            List<Pet> pets = store.showAvaiblePets(filter);
            con.printPetPresentation(pets);

            con.print("Seleccione una mascota para más opciones")
                    .print("Por favor, seleccione una opción:")
                    .ln()
                    .print("1. Seleccionar mascota")
                    .print("2. Filtros")
                    .ln()
                    .print("0. Volver");

            switch (con.inInt("> Ingrese una de las opciones disponibles")) {
                case 0:
                    exit = true;
                    mainMenu(Employee.getInstance());
                    break;
                case 1:
                    int petIndex = con.inInt("> ID de la mascota");
                    if (pets.size() >= petIndex) {
                        exit = true;
                        showPetInfo(pets.get(petIndex));
                    }
                    break;
                case 2:
                    con.print("Seleccione un filtro")
                            .print("1. Especie")
                            .print("2. Color")
                            .print("3. Borrar filtros")
                            .ln()
                            .print("0. Volver");

                    switch (con.inInt("> Ingrese una de las opciones disponibles")) {
                        case 0:
                            exit = true;
                            break;
                        case 1:
                            con.print(STR."""
                                    1. \{KindE.DOG.toString()}
                                    2. \{KindE.CAT.toString()}
                                    3. \{KindE.HAMSTER.toString()}
                                    4. \{KindE.SNAKE.toString()}
                                    5. \{KindE.DINOSAUR.toString()}

                                    0. Volver
                                    """);
                            int gender = con.inInt("> Selecciona un número");
                            switch (gender) {
                                case 1 -> filter = pet -> pet.getKind().equals(KindE.DOG);
                                case 2 -> filter = pet -> pet.getKind().equals(KindE.CAT);
                                case 3 -> filter = pet -> pet.getKind().equals(KindE.HAMSTER);
                                case 4 -> filter = pet -> pet.getKind().equals(KindE.SNAKE);
                                case 5 -> filter = pet -> pet.getKind().equals(KindE.DINOSAUR);
                                case 0 -> petMenu();
                                default -> con.print("Opción inválida, volverá a la lista");
                            }
                            break;
                        case 2:
                            con.print("""
                                    1. Verde
                                    2. Negro
                                    3. Blanco
                                    4. Café
                                    5. Naranja
                                    6. Gris
                                    7. Marrón

                                    0. Volver
                                    """);
                            int color = con.inInt("> Selecciona un número");
                            switch (color) {
                                case 1 -> filter = pet -> pet.getColor().equals("Verde");
                                case 2 -> filter = pet -> pet.getColor().equals("Negro");
                                case 3 -> filter = pet -> pet.getColor().equals("Blanco");
                                case 4 -> filter = pet -> pet.getColor().equals("Café");
                                case 5 -> filter = pet -> pet.getColor().equals("Naranja");
                                case 6 -> filter = pet -> pet.getColor().equals("Gris");
                                case 7 -> filter = pet -> pet.getColor().equals("Marrón");
                                case 0 -> petMenu();
                                default -> con.print("Opción inválida, volverá a la lista.");
                            }
                            break;
                        case 3:
                            filter = null;
                            break;
                        default:
                            con.print("Opción inválida, intente nuevamente");
                    }
                    break;
                default:
                    con.print("Opción inválida, intente nuevamente");
            }
        } while (!exit);

    }

    private void showPetInfo(Pet pet) {
        boolean exit = false;
        Console con = new Console(pet.getName());

        do {
            con.printPetPresentation(pet);
            con.print("""
                    Por favor, seleccione una opción:
                    
                    1. Adoptar :)
                    
                    0. Volver :(
                    
                    """);
            switch (con.inInt("> Ingrese una de las opciones disponibles")) {
                case 0:
                    exit = true;
                    mainMenu(Employee.getInstance());
                    break;
                case 1:
                    exit = true;
                    adoptionMenu(pet);
                    break;
                default:
                    con.print("Opción inválida, intente nuevamente");
                    break;
            }
        } while (!exit);
    }

    private void adoptionMenu(Pet pet) {
        Console con = new Console("Menú de adopción");
        String name;
        String lastName;
        String birthdate;
        String address;

        do {
            con.print("Porfavor, ingrese los datos del adoptante").ln();
            name = con.in("> Nombre");
            lastName = con.in("> Apellido");
            birthdate = con.in("> Fecha de nacimiento (aaaa-mm-dd)");
            address = con.in("> Dirección");
        } while (!con.question("¿Es correcta? En caso contrario se volverá a preguntar."));

        try {
            Ticket ticket = store.createPetAdoption(new Client(name, lastName, LocalDate.parse(birthdate), address), pet);
            con.print(ticket.toString());
            con.print("En 5 segundos se lo redirigirá al menú principal.");
            con.sleep(5);
        }
        catch (DateTimeParseException e) {
            con.print("Fecha de nacimiento inválida, el formato deseado es aaaa-mm-dd. Por ejemplo: 2022-12-18 Argentina campeón del mundo.");
            adoptionMenu(pet);
        }
        catch (ExoticPetException | InterruptedException e) {
            con.print(e.getMessage());
        }
        catch (Exception e) {
            con.print("Error al generar adopción en este momento. Porfavor, intentelo más tarde o realice la adopción manual.");
            petMenu();
        }
        finally {
            mainMenu(Employee.getInstance());
        }
    }

    private void adoptionHistory() {
        Console con = new Console("Historial de adopciones");
        do {
            con.printPetHistory(store.getClients());
        } while (!con.question(""));
        mainMenu(Employee.getInstance());
    }
}
