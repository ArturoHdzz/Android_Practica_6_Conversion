package com.example.practica_6_conversion.model;

public class Farenheit extends Grado{
    public Farenheit() {
        this.setUnidad("F");
    }

    public Farenheit(Double valor) {
        this();
        this.setValor(valor);
    }

    public Farenheit parse(Celsius C) {
        Farenheit F = new Farenheit();
        F.setValor(C.getValor() * 1.8 + 32);
        return F;
    }

    public Farenheit parse(Kelvin K) {
        Farenheit F = new Farenheit();
        F.setValor(K.getValor() * 9 / 5 - 459.67);
        return F;
    }
}
