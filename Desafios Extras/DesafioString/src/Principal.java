import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = leitor.nextLine();

        OperacaoCaracteres op = new TrocaCaracteres();
        String trocada = op.trocarLetras(palavra);
        System.out.println("Palavra transcrita: " + op.trocarLetras(trocada));

        leitor.close();
    }
}
