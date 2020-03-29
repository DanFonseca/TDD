package com.daniel.tdd.ehBissexto;

public class ehBissexto {

    public boolean ehbissexto(int ano){
        //O ano é bissexto quando é divisível por 4, mas não por 100.
        //O ano não é bissexto quando é divisível por 100, mas não por 400. Caso as duas afirmações sejam verdadeira, ele é bissexto
        boolean ehDivisivelpor400 = ano % 400 == 0;
        boolean ehDivisivelpor100 = ano % 100 ==0;
        boolean ehDivisivelPor4 = ano % 4 ==0;

        return (ehDivisivelPor4 && !ehDivisivelpor100) || (ehDivisivelpor100 && !ehDivisivelpor400)
                || (ehDivisivelPor4 && ehDivisivelpor100 && ehDivisivelpor400);
    }
}
