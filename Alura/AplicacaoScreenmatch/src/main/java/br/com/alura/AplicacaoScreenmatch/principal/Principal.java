package br.com.alura.AplicacaoScreenmatch.principal;

import br.com.alura.AplicacaoScreenmatch.model.DadosEpisodio;
import br.com.alura.AplicacaoScreenmatch.model.DadosSerie;
import br.com.alura.AplicacaoScreenmatch.model.DadosTemporadas;
import br.com.alura.AplicacaoScreenmatch.model.Episodios;
import br.com.alura.AplicacaoScreenmatch.service.ConsumoApi;
import br.com.alura.AplicacaoScreenmatch.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitor = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=965d7058";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {

        System.out.println("Digite o nome da série para consulta: ");
        var nomeSerie = leitor.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporadas> temporadas = new ArrayList<>();
        if (dados.totalTemporadas() != null) {
            for (int i = 1; i <= dados.totalTemporadas(); i++) {
                json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporadas dadosTemporada = conversor.obterDados(json, DadosTemporadas.class);
                temporadas.add(dadosTemporada);
            }
        } else {
            System.out.println("Total de temporadas é nulo.");
        }
        temporadas.forEach(System.out::println);

        for (int i = 0; i < dados.totalTemporadas(); i++) {
            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println(episodiosTemporada.get(j).titulo());
            }
        }

//        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
//
//        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream()).collect(Collectors.toList());
//
//        System.out.println("\nTop 5 episodios");
//        dadosEpisodios.stream().filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
//                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed()).limit(5)
//                .forEach(System.out::println);
//
        List<Episodios> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream().map(d -> new Episodios(t.numero(), d))).collect(Collectors.toList());

//        episodios.forEach(System.out::println);
//
//        System.out.println("Digite um trecho do título do episódio");
//        var trechoTitulo = leitor.nextLine();
//        Optional<Episodios> episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().toLowerCase().contains(trechoTitulo.toLowerCase()))
//                .findFirst();
//        if (episodioBuscado.isPresent()){
//            System.out.println("Episódio encontrado!");
//            System.out.println("Temporada: " + episodioBuscado.get().getTemporada());
//        } else {
//            System.out.println("Episódio não encontrado");
//        }

//        System.out.println("A partir de que ano você deseja ver os episódios?");
//        var ano = leitor.nextInt();
//        leitor.nextLine();
//        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        episodios.stream().filter(e -> e.getDataLancamento() != null  && e.getDataLancamento().isAfter(dataBusca)).forEach(e -> System.out.println("Temporada: " + e.getTemporada() + "," + " Episódio: " + e.getTitulo() + ","  + " Número do episódio: " + e.getNumeroEpisodio() + "," + " Data de lançamento: " + e.getDataLancamento().format(formatador)));

        Map<Integer, Double> avaliacoesPorTemporada = episodios.stream().filter(e -> e.getAvaliacao() > 0.0).collect(Collectors.groupingBy(Episodios::getTemporada, Collectors.averagingDouble(Episodios::getAvaliacao)));
        System.out.println("Temporadas de " + dados.titulo() + " tem avaliação de: " + avaliacoesPorTemporada);

        DoubleSummaryStatistics est = episodios.stream().filter(e -> e.getAvaliacao() > 0.0).collect(Collectors.summarizingDouble(Episodios::getAvaliacao));
        System.out.println("Média: " + est.getAverage());
        System.out.println("Melhor episódio: " + est.getMax());
        System.out.println("Pior episódio: " + est.getMin());
        System.out.println("Quantidades episódios avaliados: " + est.getCount());

    }
}
