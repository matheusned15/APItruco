package Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "carta", schema = "truco")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Baralho {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final char c[] = {'A', '2', '3', '4', '5', '6', '7', 'J', 'Q', 'K'};

    @OneToMany
    private final ArrayList<Carta> utilizadas = new ArrayList<>();

}
