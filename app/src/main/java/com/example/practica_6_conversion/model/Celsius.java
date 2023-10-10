package com.example.practica_6_conversion.model;

public class Celsius extends Grado{
    public Celsius(Double valor) {
        this.setUnidad("C");
        this.setValor(valor);
    }

    public Celsius parse(Farenheit F) {
        return new Celsius((F.getValor() - 32) / 1.8);
    }

    public Celsius parse(Kelvin K) {
        return new Celsius(K.getValor() - 273.15);
    }
}
