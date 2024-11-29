package com.example.validacoes;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import com.example.validacoes.RespostaErro;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class TratadorErros {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<RespostaErro> handleProdutoNaoEncontrado(ProdutoNaoEncontradoException ex) {
        RespostaErro respostaErro = new RespostaErro("Produto não encontrado", ex.getMessage());
        return new ResponseEntity<>(respostaErro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<RespostaErro> handleResponseStatusException(ResponseStatusException ex) {
        RespostaErro respostaErro = new RespostaErro(ex.getReason(), ex.getMessage());
        return new ResponseEntity<>(respostaErro, ex.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespostaErro> handleGeneralException(Exception ex) {
        RespostaErro respostaErro = new RespostaErro("Erro inesperado", "Ocorreu um erro inesperado: " + ex.getMessage());
        return new ResponseEntity<>(respostaErro, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
