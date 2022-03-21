package Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name = "mao", schema = "truco")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mao {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final ArrayList<Carta> cartasMao;


    Mao() {
        cartasMao = new ArrayList<>();
    }
}
