package com.daniel.tdd.Test;

import com.daniel.tdd.Lance;
import com.daniel.tdd.Leilao;

public class LeilaoBuilder {

    private Leilao leilao;

    public LeilaoBuilder setDescricaoLeilao(String descricao){
        this.leilao = new Leilao(descricao);
        return this;
    }



    public LeilaoBuilder propoe (Lance lance){
        this.leilao.propoe(lance);
        return this;
    }

    public Leilao constroi (){
        return this.leilao;
    }

}
