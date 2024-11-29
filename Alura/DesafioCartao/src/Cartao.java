import java.util.ArrayList;
import java.util.List;

public class Cartao {
    private double limite;
    private double saldo;
    private List<Compra> compras;

    public Cartao(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public Boolean lancaCompra(Compra compras){
        if (this.saldo > compras.getValor()){
            this.saldo -= compras.getValor();
            this.compras.add(compras);
            return true;
        }

        return false;
    }

    public double getLimite() {
        return limite;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public double getSaldo() {
        return saldo;
    }

    //    public adicionarCompra(){
    //        compras.add()
    //    }
}
