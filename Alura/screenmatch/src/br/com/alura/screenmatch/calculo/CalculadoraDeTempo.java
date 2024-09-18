package br.com.alura.screenmatch.calculo;

import br.com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

//    public void inclui (Filme filmes){
//        this.tempoTotal += filmes.getDuracaoEmMinutos();
//    }
//
//    public void inclui (Serie series){
//        this.tempoTotal += series.getDuracaoEmMinutos();
//    }

    public void inclui (Titulo titulos){
        System.out.println("Adicionando duração em minutos de " + titulos);
        this.tempoTotal += titulos.getDuracaoEmMinutos();
    }
}
