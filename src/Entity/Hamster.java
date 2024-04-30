package Entity;

import java.time.LocalDate;
import Enum.KindE;

public class Hamster extends Pet{
    Hamster(String name, LocalDate birthdate, String color, Double weight) {
        super(name, birthdate, color, weight);
        isExotic = false;
        kind = KindE.HAMSTER;
    }
}
