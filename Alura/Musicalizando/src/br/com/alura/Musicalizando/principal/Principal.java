package br.com.alura.Musicalizando.principal;

import br.com.alura.Musicalizando.modelo.MinhasPreferidas;
import br.com.alura.Musicalizando.modelo.Musica;
import br.com.alura.Musicalizando.modelo.Podcast;

public class Principal {
    public static void main(String[] args) {
        Musica minhamusica = new Musica();
        minhamusica.setTitulo("Forever");
        minhamusica.setCantor("Kiss");

        for (int i = 0; i < 1000; i++) {
            minhamusica.reproduzir();
        }

        for (int i = 0; i < 500; i++) {
            minhamusica.curtir();
        }

        Podcast meupodcast = new Podcast();
        meupodcast.setTitulo("Pires dev");
        meupodcast.setApresentador("Pedro Pires");

        for (int i = 0; i < 5000; i++) {
            meupodcast.reproduzir();
        }

        for (int i = 0; i < 3000; i++) {
            meupodcast.curtir();
        }

        System.out.println("Sua musica tem " + minhamusica.getCurtidas() + " curtidas");
        System.out.println("Seu podcast tem " + meupodcast.getCurtidas() + " curtidas");

        MinhasPreferidas preferidas = new MinhasPreferidas();
        preferidas.inclui(meupodcast);
        preferidas.inclui(minhamusica);
    }
}
