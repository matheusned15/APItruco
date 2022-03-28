package Model.Entity;


import javax.persistence.*;


public class Carta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String[] NAIPES = {"Clubs", "Diamonds", "Hearts", "Spades" };

    public String[] CARTAS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace" };


    public void criarBaralho(){
        int n = NAIPES.length * CARTAS.length;
        String[] deck = new String[n];
        for (int i = 0; i < CARTAS.length; i++) {
            for (int j = 0; j < NAIPES.length; j++) {
                deck[NAIPES.length*i + j] = CARTAS[i] + " of " + NAIPES[j];
            }
        }
    }
}
