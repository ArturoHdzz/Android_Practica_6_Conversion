package com.example.practica_6_conversion.model;

public class Kelvin extends Grado{
    public Kelvin(Double valor) {
        this.setUnidad("K");
        this.setValor(valor);
    }

    public Kelvin parse(Farenheit F) {
        return new Kelvin(((F.getValor() - 32) * 5/9)+273.15);
    }

    public Kelvin parse(Celsius C) {
        return new Kelvin(C.getValor() + 273.15);
    }
}
