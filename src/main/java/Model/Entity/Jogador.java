package Model.Entity;
import javax.persistence.*;


public class Jogador {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Mao maoJogador;

    Jogador() {
        this.maoJogador = new Mao();
    }
}
