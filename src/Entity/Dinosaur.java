package Entity;

import java.time.LocalDate;
import Enum.KindE;

public class Dinosaur extends Pet {
    Dinosaur(String name, LocalDate birthdate, String color, Double weight) {
        super(name, birthdate, color, weight);
        isExotic = true;
        kind = KindE.DINOSAUR;
    }
}
