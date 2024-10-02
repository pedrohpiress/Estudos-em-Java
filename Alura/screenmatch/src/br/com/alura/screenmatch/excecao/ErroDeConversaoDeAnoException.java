package br.com.alura.screenmatch.excecao;

public class aaa extends RuntimeException {
    private String mensagem;
    public aaa(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMensagem() {
        return mensagem;
    }
}
