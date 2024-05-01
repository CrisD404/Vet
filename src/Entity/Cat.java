package Entity;

import java.time.LocalDate;
import Enum.KindE;

public class Cat extends Pet {

    Cat(String name, LocalDate birthdate, String color, Double weight) {
        super(name, birthdate, color, weight);
        isExotic = false;
        kind = KindE.CAT;
        careRecommendation = "Asegúrarse de cepillar su pelaje regularmente, proporcionarle un rascador para mantener sus uñas en buen estado y ofrecerle una dieta equilibrada y agua fresca. Además, no olvides jugar con él para estimular su mente y mantenerlo activo. \uD83D\uDC3E";
    }
}
