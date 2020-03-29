package com.daniel.tdd.Test;

import com.daniel.tdd.*;


import static com.daniel.tdd.Test.haUmLance.ahaUmLance;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;



import org.junit.Before;
import org.junit.Test;



public class avaliadorTeste {

       private  Usuario daniel;
       private Usuario jorge;
       private Usuario rodrigo;
       private  Usuario joao;
       private Usuario maria;
       private Usuario cecilia;
       private Usuario criolo;

       private LeilaoBuilder leilaoBuilder;


    @Before
    public void setUp (){

        this.daniel = new Usuario(1, "Daniel");
        this.jorge = new Usuario(2, "Jorge");
        this.rodrigo = new Usuario(3, "Rodrigo");
        this.joao = new Usuario("Joao");
        this.maria = new Usuario("Maria");
        this.cecilia = new Usuario("Cecilia Meira");
        this.criolo = new Usuario("Criolo Doido");

        this.leilaoBuilder = new LeilaoBuilder();

    }

    @Test
    public void temUmlance (){

        Lance lance = new Lance(new Usuario("Steve Jobs"), 2000);

        Leilao leilao = leilaoBuilder.setDescricaoLeilao("Teste")
                .propoe(lance)
                .constroi();

        assertThat(leilao, ahaUmLance(lance));
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveAceitaLancesVazios (){
        Leilao leilao =  leilaoBuilder.
                setDescricaoLeilao("Lance vazio")
                .constroi();

        TresMaioresLances tresMaioresLances = new TresMaioresLances(leilao);
    }

        @Test
        public void deveDevolverLancesEsperados() {


            Leilao playstation3 =  leilaoBuilder.setDescricaoLeilao("Playstation 3")
                    .propoe(new Lance(daniel, 500))
                    .propoe(new Lance(jorge, 250))
                    .propoe(new Lance(rodrigo, 100))
                    .constroi();

            devolverMaiorOuMenorLance maioirLance = new devolverMaiorOuMenorLance(playstation3);


/*           assertEquals(500, maioirLance.getMaiorValor(), 0.00001 );
            assertEquals(100, new devolverMaiorOuMenorLance(playstation3).getMenorValor(), 0.00001);*/

            assertThat(maioirLance.getMaiorValor(), equalTo(500.0));

        }

        @Test
        public void testaMediaLances (){



            Leilao playstation3 = leilaoBuilder.setDescricaoLeilao("Plaustation 3")
                    .propoe(new Lance(daniel, 540))
                    .propoe(new Lance(jorge, 250))
                    .propoe( new Lance(rodrigo, 100))
                    .constroi();

            devolverValorMedioLances devolverValorMedioLances = new devolverValorMedioLances(playstation3);
            assertEquals(296.666667, devolverValorMedioLances.getValorMedio(), 0.00001);

        }

        @Test
        public void avaliarTresMaioresLances(){


            Leilao playstation3 = leilaoBuilder.setDescricaoLeilao("TV TOP")
                    .propoe(new Lance(daniel, 500))
                    .propoe(new Lance(jorge, 250))
                    .propoe(new Lance(rodrigo, 100))
                    .constroi();


            TresMaioresLances tresMaioresLances = new TresMaioresLances(playstation3);

            /*assertEquals(100, tresMaioresLances.getTresMaioresLances().get(0).getValor(), 0000.1);
            assertEquals(3, tresMaioresLances.getTresMaioresLances().size(), 0000.1);*/

            assertThat(tresMaioresLances.getTresMaioresLances(), hasItems(
                    new Lance(daniel, 500),
                    new Lance(jorge, 250),
                    new Lance(rodrigo, 100)
            ));

        }

        @Test
        public void testaUmLance (){

            Leilao playstation3 = leilaoBuilder.setDescricaoLeilao("DELL INSPIRON GAME")
                    .propoe(new Lance(daniel, 500))
                    .constroi();

            devolverMaiorOuMenorLance devolverMaiorOuMenorLance = new devolverMaiorOuMenorLance(playstation3);

            assertEquals(500, devolverMaiorOuMenorLance.getMaiorValor(), 0000.1);
            assertEquals(500, devolverMaiorOuMenorLance.getMenorValor(),0000.1);
        }

    @Test
    public void deveEntenderLeilaoComLancesEmOrdemRandomica() {


        Leilao leilao = leilaoBuilder.setDescricaoLeilao("Iphone 8 Semi-novo")
                .propoe(new Lance(joao,200.0))
                .propoe(new Lance(maria,450.0))
                .propoe(new Lance(joao,120.0))
                .propoe(new Lance(maria,700.0))
                .propoe(new Lance(joao,630.0))
                .propoe(new Lance(maria,230.0))
                .constroi();

        devolverMaiorOuMenorLance leiloeiro = new devolverMaiorOuMenorLance(leilao);

        assertEquals(700.0, leiloeiro.getMaiorValor(), 0.0001);
        assertEquals(120.0, leiloeiro.getMenorValor(), 0.0001);

    }

    @Test
    public void testeLanceVazio() {

        Leilao leilao = leilaoBuilder.setDescricaoLeilao("Spotify por 10 anos")
                .propoe(new Lance(maria,200.0))
                .constroi();

        TresMaioresLances tresMaioresLances = new TresMaioresLances(leilao);

        assertEquals(200,tresMaioresLances.getTresMaioresLances().get(0).getValor(), 0.0001);
    }

    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario (){

        Leilao leilao = leilaoBuilder.setDescricaoLeilao("Macbook 15")
                .propoe(new Lance(maria,200.0))
                .propoe(new Lance(jorge,200.0))
                .propoe(new Lance(jorge,23))
                .constroi();

        TresMaioresLances tresMaioresLances = new TresMaioresLances(leilao);

        assertEquals(2, leilao.getLances().size());
        assertEquals(200,tresMaioresLances.getTresMaioresLances().get(0).getValor(), 0.0001);
    }

    @Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario (){

        Leilao leilao = leilaoBuilder.setDescricaoLeilao("CD BACO ENCHU DO BLUES - XESÚX")

                .propoe(new Lance(maria,200.0))
                .propoe(new Lance(jorge,200.0))

                .propoe(new Lance(maria,200.0))
                .propoe(new Lance(jorge,200.0))

                .propoe(new Lance(maria,200.0))
                .propoe(new Lance(jorge,200.0))

                .propoe(new Lance(maria,200.0))
                .propoe(new Lance(jorge,200.0))

                .propoe(new Lance(maria,200.0))
                .propoe(new Lance(jorge,200.0))

                .propoe(new Lance(maria,200.0))
                .propoe(new Lance(jorge,200.0))
                .constroi();

        TresMaioresLances tresMaioresLances = new TresMaioresLances(leilao);

        assertEquals(10, leilao.getLances().size());
        assertEquals(200,tresMaioresLances.getTresMaioresLances().get(0).getValor(), 0.0001);
    }

    @Test
    public void dobraLanceDeUmUsuario (){

            Leilao leilao =  leilaoBuilder.setDescricaoLeilao("iPhone 11 pro Max")
                    .propoe( new Lance(daniel, 2000))
                    .propoe(new Lance(cecilia, 2500))
                    .propoe(new Lance(daniel, 5))
                    .propoe(new Lance(criolo, 5000))
                    .constroi();

            leilao.dobraLance(daniel);

            assertEquals(10, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0000.1);

    }
}


