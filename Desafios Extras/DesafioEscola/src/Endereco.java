public class Endereco extends Usuario{
    private String rua;
    private String cidade;

    public Endereco(String nome, String endereco) {
        super(nome, endereco);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
