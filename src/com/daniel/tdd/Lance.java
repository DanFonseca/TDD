package com.daniel.tdd;

import java.util.Objects;

public class Lance implements Comparable<Lance>{

    private Usuario usuario;
    private double valor;

    public Lance(Usuario usuario, double valor) {
        this.usuario = usuario;
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getValor() {
        return valor;
    }


    @Override
    public int compareTo(Lance outroValor) {
        if (this.valor < outroValor.valor) return -1;
            if (this.valor > outroValor.valor) return 1;
            return 0;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lance lance = (Lance) o;
        return usuario.equals(lance.usuario);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

