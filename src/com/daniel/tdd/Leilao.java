package com.daniel.tdd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {


    private String descricao;
        private List<Lance> lances;

        public Leilao(String descricao) {
            this.descricao = descricao;

            this.lances = new ArrayList<Lance>();
        }

        public void propoe(Lance lance) {

                if (isEmpty() || podeDarLance(lance)){
                        lances.add(lance);
                }
        }

    private boolean isEmpty() {
        return lances.isEmpty();
    }

    private boolean podeDarLance(Lance lance) {
        return !lance.equals(lances.get(lances.size()-1)) && UsuarioFezMaisQueCincoLances(lance) < 5;
    }

    public int UsuarioFezMaisQueCincoLances (Lance lance){
            int contador = 0;

            for (Lance lances:lances){
                if(lances.getUsuario().equals(lance.getUsuario())) contador++;
            }

            return contador;
        }


        public void dobraLance (Usuario usuario){

            Lance ultimo = null;

            for (Lance lance: this.lances) {
                if(lance.getUsuario().equals(usuario)) {
                    ultimo = lance;
                }
            }

            if(ultimo != null){
                this.propoe(new Lance(usuario, ultimo.getValor()*2));
            }

        }

        public String getDescricao() {
            return descricao;
        }

        public List<Lance> getLances() {
            return Collections.unmodifiableList (lances);
        }



    }

