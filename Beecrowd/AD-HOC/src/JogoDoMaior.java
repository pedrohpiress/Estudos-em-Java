import java.util.Scanner;

public class JogoDoMaior {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        while (leitor.hasNextLine()) {
            int rodadas = leitor.nextInt();

            if (rodadas == 0) {
                break;
            }

            leitor.nextLine();

            int ptsJogadorUm = 0;
            int ptsJogadorDois = 0;

            for (int i = 0; i < rodadas; i++) {
                int numJogadorUm = leitor.nextInt();
                int numJogadorDois = leitor.nextInt();

                leitor.nextLine();

                if (numJogadorUm > numJogadorDois) {
                    ptsJogadorUm++;
                } else if (numJogadorDois > numJogadorUm) {
                    ptsJogadorDois++;
                }
            }

            System.out.println(ptsJogadorUm + " " + ptsJogadorDois);
        }

        leitor.close();
    }
}
