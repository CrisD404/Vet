package Entity;

import java.time.LocalDate;
import Enum.KindE;

public class Dog extends Pet {
    Dog(String name, LocalDate birthdate, String color, Double weight) {
        super(name, birthdate, color, weight);
        isExotic = false;
        kind = KindE.DOG;
        careRecommendation = "Asegurarse de sacarlo a pasear regularmente para que haga ejercicio y socialice. Además, proporciona una dieta equilibrada, agua fresca y un lugar cómodo para descansar. No olvides cepillar su pelaje y revisar sus orejas y patas para mantenerlo limpio y libre de parásitos. \uD83D\uDC36";
    }
}
