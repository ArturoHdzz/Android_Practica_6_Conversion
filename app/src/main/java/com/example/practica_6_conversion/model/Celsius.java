package com.example.practica_6_conversion.model;

public class Celsius extends Grado{
    /*public  Celsius(Double valor){
        this.setValor(valor);
        this.setUnidad("C");
    }*/
    public Celsius parse(Farenheit F){
        Celsius C = new Celsius();
        C.setValor((F.getValor()-32)/1.8);
        return C;
    }
    public Celsius parse(Kelvin K){
        Celsius C = new Celsius();
        C.setValor(K.getValor()-273.15);
        return C;
    }
}