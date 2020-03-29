package com.daniel.tdd;

import java.util.List;

public class devolverValorMedioLances {
    private Leilao leiloes;


    public devolverValorMedioLances (Leilao leiloes){
        this.leiloes = leiloes;
    }

    public double getValorMedio() {
        double somaValores = 0;

        List<Lance> lances = this.leiloes.getLances();

        for (Lance lance: lances) {
            somaValores += lance.getValor();
        }
        return somaValores/lances.size();
    }
}
