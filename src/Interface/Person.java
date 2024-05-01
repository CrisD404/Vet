package Interface;

import java.time.LocalDate;
import java.time.Period;

public interface Person {
    String getName();
    String getLastName();
    LocalDate getBirthdate();

    default int getAge() {
        return Period.between(getBirthdate(), LocalDate.now()).getYears();
    }

}
