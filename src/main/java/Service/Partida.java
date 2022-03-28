package Service;

import Model.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;

public class Partida {

    @Autowired
    private Baralho baralho;

    @Autowired
    private Carta carta;

    @Autowired
    private Jogador jogador;

    @Autowired
    private Mao mao;

    @Autowired
    private Rodada rodada;



    private criarBaralho (){

    }
}
