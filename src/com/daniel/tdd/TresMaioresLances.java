package com.daniel.tdd;

import com.daniel.tdd.Lance;
import com.daniel.tdd.Leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TresMaioresLances {

    private List<Lance> lances = new ArrayList<Lance>();


    public TresMaioresLances(Leilao leilao){
        if (leilao.getLances().isEmpty()) throw new RuntimeException("Não há lances");

        pegandoValorDaLista(leilao);
        Collections.sort(lances);
    }

   public List<Lance> getTresMaioresLances (){
        return lances.subList(0, lances.size() > 3 ? 3 : lances.size());
   }

   private void pegandoValorDaLista (Leilao leilao){
       for (Lance lance: leilao.getLances()) {
           lances.add(lance);
       }

   }
}
