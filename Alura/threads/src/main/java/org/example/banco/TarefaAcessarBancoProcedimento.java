package org.example.banco;

public class TarefaAcessarBancoProcedimento implements Runnable {

    private final PoolDeConexao pool;
    private final GerenciadorDeTransacao tx;

    public TarefaAcessarBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
        synchronized (pool) {
            System.out.println("comendo a tx");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("peguei a conexao");
                tx.begin();
            }
        }
    }
}
