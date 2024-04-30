package Enum;

public enum KindE {
    CAT("GATO"),
    DINOSAUR("DINOSAURIO"),
    DOG("PERRO"),
    HAMSTER("HAMSTER"),
    SNAKE("SERPIENTE");

    private final String kind;
    KindE(final String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return kind;
    }
}
