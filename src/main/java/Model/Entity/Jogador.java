package Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "jogador", schema = "truco")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
