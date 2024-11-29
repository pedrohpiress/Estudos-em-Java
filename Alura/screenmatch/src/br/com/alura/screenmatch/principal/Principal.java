package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
//        meuFilme.setNome("O Poderoso chefão");
//        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setIncluidoNoPlano(true);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duracao do filme " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibirFichaTecnica();
        meuFilme.avalia(8.0);
        meuFilme.avalia(9.0);
        meuFilme.avalia(10.0);
        System.out.println("Total de avaliacoes " + meuFilme.getTotalDeAvaliacao());
        System.out.println("Média de avaliações " + meuFilme.pegaMedia());
//        meuFilme.somaDasAvaliacoes = 10;
//        meuFilme.totalDeAvaliacao = 1;
//        System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie("Lost", 2000);
//        lost.setNome("Lost");
//        lost.setAnoDeLancamento(2000);
        lost.exibirFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporadas(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duracao para maratonar Lost: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar", 2023);
//        outroFilme.setNome("Avatar");
//        outroFilme.setAnoDeLancamento(2023);
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVizualizacoes(300);
        filtro.filtrar(episodio);

        Filme filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.setDuracaoEmMinutos(200);
//        filmeDoPaulo.setNome("Dogville");
//        filmeDoPaulo.setAnoDeLancamento(2003);
        filmeDoPaulo.avalia(10.0);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Nome do primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("tostring " + listaDeFilmes.get(0).toString());

    }
}