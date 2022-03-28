package Model.Entity;


import javax.persistence.*;
import java.util.ArrayList;



public class Mao {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private final ArrayList<Carta> cartasMao;


    Mao() {
        cartasMao = new ArrayList<>();
    }

}
