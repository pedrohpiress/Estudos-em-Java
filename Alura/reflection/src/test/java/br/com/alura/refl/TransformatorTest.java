package br.com.alura.refl;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TransformatorTest {

    Pessoa pessoa = new Pessoa (1, "João", "1234");

    @Test
    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        assertInstanceOf(PessoaDTO.class, pessoaDTO);
        assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
    }
}
