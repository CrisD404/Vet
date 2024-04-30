package Entity;

import java.time.LocalDate;
import java.time.Period;

import Enum.KindE;

public abstract class Pet {
    private String name;
    private LocalDate birthdate;
    private String color;
    private Double weight;

    protected String careRecommendation;
    protected KindE kind;
    protected boolean isExotic;

    Pet(String name, LocalDate birthdate, String color, Double weight) {
        this.name = name;
        this.birthdate = birthdate;
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public String getWeight() {
        return STR."\{weight}kg";
    }

    public KindE getKind() {
        return this.kind;
    }

    public boolean getIsExotic() {
        return this.isExotic;
    }

    public String getCareRecommendation() {
        return this.careRecommendation;
    }
}
