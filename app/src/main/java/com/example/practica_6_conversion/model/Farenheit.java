package com.example.practica_6_conversion.model;

public class Farenheit extends Grado{
    public Farenheit(Double valor) {
        this.setUnidad("F");
        this.setValor(valor);
    }

    public Farenheit parse(Celsius C) {
        return new Farenheit((C.getValor() * 1.8) + 32);
    }

    public Farenheit parse(Kelvin K) {
        return new Farenheit(((K.getValor() - 273.15) * 9/5) + 32);
    }
}
