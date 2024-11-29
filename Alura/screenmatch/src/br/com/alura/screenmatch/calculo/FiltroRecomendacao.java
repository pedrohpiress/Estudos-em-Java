package br.com.alura.screenmatch.calculo;


public class FiltroRecomendacao {

    public void filtrar (Classificavel classificavel){
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Está entre os preferidos do momento");
        } else if (classificavel.getClassificacao() >= 2){
            System.out.println("Muito bem classificado no momento");
        } else {
            System.out.println("Coloque na sua lsta para assistir depois");
        }
    }

}
