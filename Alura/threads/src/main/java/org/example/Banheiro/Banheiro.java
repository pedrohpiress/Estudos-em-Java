package org.example.Banheiro;

public class Banheiro {

    private boolean ehSujo = true;

    public void fazNumero1() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            while (ehSujo){
                esperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa rapida");

            dormeUmPouco(5000);
            this.ehSujo = true;
            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mão");
            System.out.println(nome + " saindo do banheiro");
        }


    }

    public void fazNumero2() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            while (ehSujo){
                esperaLaFora(nome);
            }

            System.out.println(nome + " fazendo coisa demorada");
            dormeUmPouco(10000);
            this.ehSujo = true;
            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mão");
            System.out.println(nome + " saindo do banheiro");
        }
    }

    private static void dormeUmPouco(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void limpa(){
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {
            System.out.println(nome + " limpando o banheiro");

            if (!ehSujo){
                System.out.println(nome + " não esta sujo, vou sair");
                return;
            }
            ehSujo = false;

            System.out.println(nome + " fazendo coisa demorada");
            dormeUmPouco(13000);
            this.notifyAll();
            System.out.println(nome + " saindo do banheiro");
        }
    }

    private void esperaLaFora(String nome){
        System.out.println(nome + " eca! banheiro está sujo");
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
