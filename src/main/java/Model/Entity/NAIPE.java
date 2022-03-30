package Model.Entity;

public enum NAIPE {

    PAUS("p"),
    COPAS("C"),
    ESPADAS("E"),
    OUROS("O");

    private String value;

    NAIPE(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

