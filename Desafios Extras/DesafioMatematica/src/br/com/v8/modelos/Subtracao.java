package br.com.v8.modelos;

public class Subtracao extends Calculo implements OperacaoMatematica {

    @Override
    public double calcular(double numero1, double numero2) {
        return resultado = numero1 - numero2;
    }
}
