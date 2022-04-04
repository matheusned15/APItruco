package Model.Entity;

import javax.persistence.*;
import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baralho {

    private List<Carta> cartas = new ArrayList<>();
    private Random randomGenerator = new Random();


    public Baralho() {
        // Create new cards
        for (Rank rank : Rank.values()) {
            for (NAIPE naipe : NAIPE.values()) {
                Carta carta = new Carta(rank, naipe, false);
                this.cartas.add(carta);
            }
        }
    }


    public List<Carta> getCards() { return cartas; }

    public void setCards(ArrayList<Carta> _deck) { this.cartas = _deck; }

    public Carta drawRandomCard() {
        int index = this.randomGenerator.nextInt(cartas.size());
        Carta card = this.cartas.get(index);
        //System.out.println("Card Picked: " + card.toString());
        cartas.remove(index);
        return card;
    }

    public Carta drawTopCard() {
        Carta card = this.cartas.get(0);
        cartas.remove(0);
        System.out.println("Card Picked: " + card.toString());
        return card;
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cartas);
    }

    public void resetDeck() {
        this.cartas.clear();
        //Create new cards
        for (Rank rank : Rank.values()) {
            for (NAIPE naipe : NAIPE.values()) {
                Carta card = new Carta(rank, naipe, false);
                this.cartas.add(card);
            }
        }
    }
}
