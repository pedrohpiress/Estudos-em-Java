public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.nome = "O Poderoso chefão";
        meuFilme.anoDeLancamento = 1970;
        meuFilme.incluidoNoPlano = true;

        meuFilme.exibirFichaTecnica();
        meuFilme.avalia(8.0);
        meuFilme.avalia(9.0);
        meuFilme.avalia(10.0);
        System.out.println(meuFilme.somaDasAvaliacoes);
        System.out.println(meuFilme.totalDeAvaliacao);
        System.out.println(meuFilme.pegaMedia());
    }
}