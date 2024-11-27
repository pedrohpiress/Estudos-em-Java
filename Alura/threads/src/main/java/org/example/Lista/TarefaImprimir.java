package org.example.Lista;

public class TarefaImprimir implements Runnable {
    private final Lista lista;

    public TarefaImprimir(Lista lista) {
        this.lista = lista;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (lista) {
            if (!lista.estaCheia()){
                try {
                    System.out.println("indo dormir, aguardando notificação");
                    lista.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        for (int i = 0; i < lista.tamanho(); i++) {
            System.out.println(i + " - " + lista.pegaElemento(i));
        }
    }
}
