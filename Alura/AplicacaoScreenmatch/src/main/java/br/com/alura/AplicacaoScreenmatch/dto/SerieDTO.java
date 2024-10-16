package br.com.alura.AplicacaoScreenmatch.dto;

import br.com.alura.AplicacaoScreenmatch.model.Categoria;

public record SerieDTO(Long id,

                       String titulo,

                       Integer totalTemporadas,

                       Double avaliacao,

                       Categoria genero,

                       String atores,

                       String poster,

                       String sinopse
) {
}
