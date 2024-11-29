package br.com.alura.AplicacaoScreenmatch.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
