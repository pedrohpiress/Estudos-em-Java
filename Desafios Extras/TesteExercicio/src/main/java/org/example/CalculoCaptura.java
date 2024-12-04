package org.example;

public class CalculoCaptura {
    private static final double DISTANCIA_LIMITE = 12.0;
    private static final double DISTANCIA_LIMITE_QUADRADO = DISTANCIA_LIMITE * DISTANCIA_LIMITE;

    private double calcularTempoGuarda(int distanciaInicial, int velGuardas) {
        double distanciaGuarda = Math.sqrt(distanciaInicial * distanciaInicial + DISTANCIA_LIMITE_QUADRADO);
        return distanciaGuarda / velGuardas;
    }

    public boolean verificarCaptura(int distanciaInicial, int velFugitivo, int velGuardas) {
        double tempoFugitivo = DISTANCIA_LIMITE / velFugitivo;
        double tempoGuardas = calcularTempoGuarda(distanciaInicial, velGuardas);
        return tempoGuardas <= tempoFugitivo;
    }

}
