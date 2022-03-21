package Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "carta", schema = "truco")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int numero;

    @Column
    private NAIPE naipe;

    @Column
    private COR Cor;

}
