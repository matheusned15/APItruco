package Model.Entity;


import javax.persistence.*;
import Model.Entity.Rank;
import javax.smartcardio.Card;
import java.util.Arrays;
import java.util.Objects;


public class Carta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public static final String BACK_CARD_IMAGE_SOURCE = "/rc/unesp/br/resources/cardBack_red3.png";
    static final String IMAGE_BASE_URI = "/rc/unesp/br/resources/";

    private Rank rank;

    private NAIPE naipe;

    private String imageSource;

    public Carta(Rank _rank, NAIPE _naipe, boolean _manilha) {
        setNaipe(_naipe);
        setRank(_rank);
        setManilha(_manilha);
        this.setImageSource(IMAGE_BASE_URI + this.toString() + ".png");
    }

    public Long getId() {
        return id;
    }

    public Rank getRank() {
        return rank;
    }

    public NAIPE getNaipe() {
        return naipe;
    }

    public String[] getNAIPES() {
        return NAIPES;
    }

    public String[] getCARTAS() {
        return CARTAS;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setNaipe(NAIPE naipe) {
        this.naipe = naipe;
    }

    public void setManilha(boolean manilha) {
        this.manilha = manilha;
    }

    public void setNAIPES(String[] NAIPES) {
        this.NAIPES = NAIPES;
    }

    public void setCARTAS(String[] CARTAS) {
        this.CARTAS = CARTAS;
    }

    public String getImageSource() {
        return this.imageSource;
    }

    public void setImageSource(String _imageSource) {
        this.imageSource = _imageSource;
    }

    private boolean manilha;

    public boolean isManilha(boolean manilha){
        return manilha;
    }

    public String[] NAIPES = {"Clubs", "Diamonds", "Hearts", "Spades" };

    public String[] CARTAS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace" };


    public void setBackCardImageSource() {
        this.imageSource = BACK_CARD_IMAGE_SOURCE;
    }

    public void criarBaralho(){
        int n = NAIPES.length * CARTAS.length;
        String[] deck = new String[n];
        for (int i = 0; i < CARTAS.length; i++) {
            for (int j = 0; j < NAIPES.length; j++) {
                deck[NAIPES.length*i + j] = CARTAS[i] + " of " + NAIPES[j];
            }
        }
    }

    public boolean verificaMaisForte(Carta outraCarta){
        //Quando tem manilha, mas a outraCarta não é manilha
        if(this.isManilha() && !outraCarta.isManilha())
            return true;

        //Esta carta não é manilha, mas outraCarta é manilha
        if(!this.isManilha() && outraCarta.isManilha())
        return false;

        //As duas são manilha, compara qual é maior
        if(this.isManilha() && outraCarta.isManilha())
            return (this.getNaipe().compareTo(outraCarta.getNaipe()) > 0);

        //Se chegar aqui, nenhuma das cartas é manilha
        //Apenas comparo as duas
        return (this.getRank().compareTo(outraCarta.getRank()) > 0);
    }

    private boolean isManilha() {
        return manilha;
    }

    static public Carta getFacedDownCard() {
        Carta card = new Carta(Rank.Ace, NAIPE.PAUS, false);
        card.setBackCardImageSource();
        return card;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (!Carta.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        //final Card thisCard = (Card) this;
        final Carta anotherCard = (Carta) obj;
        return (!this.verificaMaisForte(anotherCard) && !anotherCard.verificaMaisForte(this));
    }

    public int compareTo(Carta _anotherCard){
        return this.verificaMaisForte(_anotherCard) ? 1 : -1;
    }
}
