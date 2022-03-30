package Model.Entity;

public enum Rank {
    Quatro("4"),
    Cinco("5"),
    Seis("6"),
    Sete("7"),
    Queen("Q"),
    Jack("J"),
    King("K"),
    Ace("A"),
    Dois("2"),
    Tres("3");

    private String value;

    Rank(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public Rank getNext() {
        return this.ordinal() < Rank.values().length - 1
                ? Rank.values()[this.ordinal() + 1]
                : Quatro;
    }

}