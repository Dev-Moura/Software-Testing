package com.SoftwareTesting.java.calculaFinanceiro;


public class CalculadoraFinanceira {

    private final ConversorDeMoeda conversor;

    public CalculadoraFinanceira(ConversorDeMoeda conversor) {
        this.conversor = conversor;
    }

    public double somarEmReais(double valorEmReais, double valorEmDolar) {
        double convertido = conversor.dolarParaReal(valorEmDolar);
        return valorEmReais + convertido;
    }
}



































































