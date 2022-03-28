package Model.Entity;

import javax.persistence.*;
import java.util.ArrayList;

public class Baralho {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private final ArrayList<Carta> utilizadas = new ArrayList<>();

}
