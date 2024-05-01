package Entity;

import java.time.LocalDate;
import Enum.KindE;

public class Hamster extends Pet{
    Hamster(String name, LocalDate birthdate, String color, Double weight) {
        super(name, birthdate, color, weight);
        isExotic = false;
        kind = KindE.HAMSTER;
        careRecommendation = "Asegurarse de proporcionarle un hábitat adecuado con suficiente espacio para moverse y explorar. Proporciona una rueda de ejercicio para que pueda mantenerse activo y entretenido. Además, ofrece una dieta equilibrada que incluya alimentos frescos como frutas y verduras. No olvides limpiar su jaula regularmente y proporcionarle un lugar cómodo para descansar. \uD83D\uDC39";
    }
}
