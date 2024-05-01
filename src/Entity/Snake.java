package Entity;

import java.time.LocalDate;
import Enum.KindE;

public class Snake extends Pet {
    Snake(String name, LocalDate birthdate, String color, Double weight) {
        super(name, birthdate, color, weight);
        isExotic = false;
        kind = KindE.SNAKE;
        careRecommendation = "Asegurarse de mantener la temperatura y humedad adecuadas según la especie de serpiente y proporsionar un terrario espacioso con escondites, ramas y superficies para trepar. Además, ofrecer una dieta apropiada, que puede incluir ratones o ratas según el tamaño de la serpiente y por último siempre manipula a tu serpiente con suavidad y evita asustarla. \uD83D\uDC0D";
    }
}
