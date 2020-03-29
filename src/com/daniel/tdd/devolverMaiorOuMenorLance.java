package com.daniel.tdd;

import java.util.ArrayList;
import java.util.List;

public class devolverMaiorOuMenorLance {
    private Leilao leilao;
    private  List<Lance> lances;
    double maiorLance = Double.NEGATIVE_INFINITY;
    double menorValor = Double.POSITIVE_INFINITY;

    public devolverMaiorOuMenorLance(Leilao leilao){
        this.leilao = leilao;
        this.lances  = new ArrayList<Lance>();
        lances =  this.leilao.getLances();

        getMaiorLance();
    }

    private void getMaiorLance(){
        for (Lance lance: lances) {
            if(maiorLance < lance.getValor()) maiorLance = lance.getValor();
            if(menorValor > lance.getValor()) menorValor = lance.getValor();
        }

    }

    public  double getMenorValor (){
        return  this.menorValor;
    }

    public double getMaiorValor (){
        return this.maiorLance;
    }

}
