package com.example.practica_6_conversion.model;

public class Kelvin extends Grado{
    public Kelvin() {
        this.setUnidad("K");
    }

    public Kelvin(Double valor) {
        this();
        this.setValor(valor);
    }

    public Kelvin parse(Farenheit F) {
        Kelvin K = new Kelvin();
        K.setValor((F.getValor() + 459.67) * 5 / 9);
        return K;
    }

    public Kelvin parse(Celsius C) {
        Kelvin K = new Kelvin();
        K.setValor(C.getValor() + 273.15);
        return K;
    }
}
