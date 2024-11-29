package org.example.Banheiro;

public class TarefaLimpeza implements Runnable {
    private final Banheiro banheiro;

    public TarefaLimpeza(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        banheiro.limpa();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
