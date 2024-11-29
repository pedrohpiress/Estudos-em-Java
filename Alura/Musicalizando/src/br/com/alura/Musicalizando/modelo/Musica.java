package br.com.alura.Musicalizando.modelo;

public class Musica extends Audio{
    private String album;
    private String cantor;
    private String genero;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public int getClassificacao() {
        if (this.getTotalReproducoes() > 2000){
            return 10;
        } else {
            return 8;
        }
    }
}
