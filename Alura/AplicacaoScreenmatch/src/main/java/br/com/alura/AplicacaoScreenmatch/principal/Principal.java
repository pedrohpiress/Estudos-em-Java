package br.com.alura.AplicacaoScreenmatch.principal;

import br.com.alura.AplicacaoScreenmatch.model.*;
import br.com.alura.AplicacaoScreenmatch.repository.SerieRepository;
import br.com.alura.AplicacaoScreenmatch.service.ConsumoApi;
import br.com.alura.AplicacaoScreenmatch.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;


public class Principal {


    private Scanner leitor = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=965d7058";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private List<DadosSerie> dadosSeries = new ArrayList<>();

    private List<Serie> series = new ArrayList<>();

    private SerieRepository repositorio;

    private Optional<Serie> serieBusca;

    public Principal(SerieRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {

        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    -----------------------------
                    1 - Buscar séries
                    2 - Buscar episódios
                    3 - Listar séries
                    4 - Buscar série pelo título
                    5 - Buscar série por ator
                    6 - Top 5 series
                    7 - Buscar série por categoria
                    8 - Buscar série por máximo de temporadas
                    9 - Buscar por nome do episódio
                    10 - Top 5 Episódios de uma série
                    11 - Buscar episódios a partir de uma data
                    
                    0 - Sair
                    -----------------------------
                    """;

            System.out.println(menu);
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 4:
                    buscarPorTitulo();
                    break;
                case 5:
                    buscarSeriePorAtor();
                    break;
                case 6:
                    buscarTop5Series();
                    break;
                case 7 :
                    buscarSeriePorCategoria();
                    break;
                case 8:
                    buscarPorMaximoTemporadas();
                    break;
                case 9:
                    buscarEpisodioPorNome();
                    break;
                case 10:
                    buscarTop5EpisodiosPorSerie();
                    break;
                case 11:
                    buscarEpisodiosAposUmaData();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

    }

    private void buscarEpisodiosAposUmaData() {
        buscarPorTitulo();
        if (serieBusca.isPresent()){
            System.out.println("Digite o ano limite de lançamento");
            var anoLancamento = leitor.nextInt();
            leitor.nextLine();
            Serie serie = serieBusca.get();
            List<Episodios> episodiosAno = repositorio.episodiosPorSerieEAno(serie, anoLancamento);
            episodiosAno.forEach(System.out::println);
        }
    }

    private void buscarTop5EpisodiosPorSerie() {
        buscarPorTitulo();

        if (serieBusca.isPresent()){
            Serie serie = serieBusca.get();
            List<Episodios> topEpisodios = repositorio.topEpisodiosPorSerie(serie);
            topEpisodios.forEach(e -> System.out.printf("Série: %s - Temporada: %s - Episódio: %s - %s - Avaliação %s\n", e.getSerie().getTitulo(), e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo(), e.getAvaliacao()));
        }
    }

    private void buscarEpisodioPorNome() {
        System.out.println("Qual o nome do episódio para busca");
        var trechoEpisodio = leitor.nextLine();
        List<Episodios> episodiosEncontrados = repositorio.episodiosPorTrecho(trechoEpisodio);
        episodiosEncontrados.forEach(e -> System.out.printf("Série: %s - Temporada: %s - Episódio: %s - %s\n", e.getSerie().getTitulo(), e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()));
    }

    private void buscarPorMaximoTemporadas() {
        System.out.println("Qual o máximo de temporadas que a série pode ter?");
        var totalTemporadas = leitor.nextInt();
        System.out.println("E qual o avaliação mínima que a série deve ter?");
        var avaliacao = leitor.nextDouble();
        List<Serie> seriePorTemporada = repositorio.seriesPorTemporadaEAValiacao(totalTemporadas, avaliacao);
        seriePorTemporada.forEach(System.out::println);
    }

    private void buscarSeriePorCategoria() {
        System.out.println("Deseja buscar séries por qual categoria?");
        var nomeGenero = leitor.nextLine();
        Categoria categoria = Categoria.fromPortugues(nomeGenero);
        List<Serie> seriesPorCategoria = repositorio.findByGenero(categoria);
        System.out.println("Séries da categoria: " + seriesPorCategoria);
        seriesPorCategoria.forEach(System.out::println);
    }

    private void buscarTop5Series() {
        List<Serie> serieTop = repositorio.findTop5ByOrderByAvaliacaoDesc();
        serieTop.forEach(s -> System.out.println(s.getTitulo() + ", " + " avaliação: " + s.getAvaliacao()));
    }

    private void buscarSeriePorAtor() {
        System.out.println("Escolha um ator(a) para ser pesquisado");
        var nomeAtor = leitor.nextLine();
        System.out.println("Avaliações a partir de que nota?");
        var avaliacoes = leitor.nextDouble();
        List<Serie> serieBuscada = repositorio.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAtor, avaliacoes);

        if (!serieBuscada.isEmpty()) {
            System.out.println("Séries em que " + "'" + nomeAtor + "'" + " trabalhou: ");
            serieBuscada.forEach(s -> System.out.println(s.getTitulo() + ", " + " avaliação: " + s.getAvaliacao()));

        } else {
            System.out.println("Ator(a) não encontrado(a) em alguma série");
        }
    }

    private void buscarPorTitulo() {
        System.out.println("Escolha uma série pelo nome");
        var nomeSerie = leitor.nextLine();
        serieBusca = repositorio.findByTituloContainingIgnoreCase(nomeSerie);

        if (serieBusca.isPresent()) {
            System.out.println("Dados da série: " + serieBusca.get());

        } else {
            System.out.println("Série não encontrada");
        }
    }

    private void listarSeriesBuscadas() {
        series = repositorio.findAll();
        series.stream().sorted(Comparator.comparing(Serie::getGenero)).forEach(System.out::println);
    }

    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        Serie serie = new Serie(dados);
        repositorio.save(serie);
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitor.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie() {
        listarSeriesBuscadas();
        System.out.println("Escolha uma série pelo nome");
        var nomeSerie = leitor.nextLine();

        Optional<Serie> serie = repositorio.findByTituloContainingIgnoreCase(nomeSerie);

        if (serie.isPresent()) {
            var serieEncontrada = serie.get();
            List<DadosTemporadas> temporadas = new ArrayList<>();
            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumoApi.obterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporadas dadosTemporada = conversor.obterDados(json, DadosTemporadas.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodios> episodios = temporadas.stream().
                    flatMap(d -> d.episodios().stream().
                            map(e -> new Episodios(d.numero(), e))).
                    collect(Collectors.toList());
            serieEncontrada.setEpisodios(episodios);
            repositorio.save(serieEncontrada);
        } else {
            System.out.println("Série não encontrada");
        }
    }
}


