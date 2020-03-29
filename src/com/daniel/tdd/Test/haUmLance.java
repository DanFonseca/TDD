package com.daniel.tdd.Test;

import com.daniel.tdd.Lance;
import com.daniel.tdd.Leilao;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;



public class haUmLance extends TypeSafeMatcher<Leilao> {


    @Override
    protected boolean matchesSafely(Leilao leilao) {
        return !leilao.getLances().isEmpty();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Nao há lances");
    }

    @Factory
    public static Matcher<Leilao> ahaUmLance(Lance lance) {
        return  new haUmLance();
    }



}
