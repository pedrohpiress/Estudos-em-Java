package org.example.BuscadorTexto;

public class Principal {

    public static void main(String[] args) {
        String nome = "Jon";

        String pathAssinaturas1 = Principal.class.getClassLoader().getResource("assinaturas1.txt").getPath();
        String pathAssinaturas2 = Principal.class.getClassLoader().getResource("assinaturas2.txt").getPath();
        String pathAutores = Principal.class.getClassLoader().getResource("autores.txt").getPath();

        Thread threadAssinaturas1 = new Thread(new TarefaBuscaTextual(pathAssinaturas1, nome));
        Thread threadAssinaturas2 = new Thread(new TarefaBuscaTextual(pathAssinaturas2, nome));
        Thread threadAutores = new Thread(new TarefaBuscaTextual(pathAutores, nome));

        threadAssinaturas1.start();
        threadAssinaturas2.start();
        threadAutores.start();
    }

}
