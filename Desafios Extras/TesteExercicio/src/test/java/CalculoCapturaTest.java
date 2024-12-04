

import org.example.CalculoCaptura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculoCapturaTest {
    private CalculoCaptura calculo;

    @BeforeEach
    void setUp() {
        calculo = new CalculoCaptura();
    }

    @Test
    void deveRetornarSQuandoGuardaCapturaFugitivo() {
        assertTrue(calculo.verificarCaptura(10, 5, 10), "O guarda deveria capturar o fugitivo.");
    }

    @Test
    void deveRetornarNQuandoFugitivoEscapa() {
        assertFalse(calculo.verificarCaptura(10, 12, 10), "O fugitivo deveria escapar.");
    }

    @Test
    void deveCapturarQuandoVelocidadeDoGuardaEhMuitoMaior() {
        assertTrue(calculo.verificarCaptura(20, 10, 30), "O guarda deveria capturar com velocidade muito maior.");
    }

    @Test
    void deveEscaparQuandoDistanciaInicialEhGrandeEDiferencaDeVelocidadePequena() {
        assertFalse(calculo.verificarCaptura(100, 10, 11), "O fugitivo deveria escapar devido à grande distância inicial e pequena diferença de velocidade.");
    }

    @Test
    void deveCapturarComVelocidadeIgualQuandoDistanciaInicialEhZero() {
        assertTrue(calculo.verificarCaptura(0, 10, 10), "O guarda deveria capturar quando a distância inicial é zero e as velocidades são iguais.");
    }

    @Test
    void deveCapturarQuandoVelocidadeFugitivoEhZero() {
        assertTrue(calculo.verificarCaptura(10, 0, 5), "O guarda deveria capturar o fugitivo quando ele está parado.");
    }

    @Test
    void deveEscaparComDistanciaInicialMuitoGrandeEDiferencaMinima() {
        assertFalse(calculo.verificarCaptura(1000, 1, 2), "O fugitivo deve escapar devido à grande distância inicial e diferença mínima de velocidade.");
    }
}
