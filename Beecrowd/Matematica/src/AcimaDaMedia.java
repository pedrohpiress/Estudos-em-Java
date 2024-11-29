import java.util.Scanner;

public class AcimaDaMedia {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int qtdRodadas = leitor.nextInt();
        leitor.nextLine();

        int contador = 1;
        while (contador <= qtdRodadas) {
            int qtdNotas = leitor.nextInt();
            int[] medias = new int[qtdNotas];
            double mediasJuntas = 0.0;

            for (int i = 0; i < qtdNotas; i++) {
                medias[i] = leitor.nextInt();
                mediasJuntas += medias[i];
            }

            leitor.nextLine();
            double mediasFinais = mediasJuntas / qtdNotas;
            double mediasMaiores = 0.0;

            for (double verMaior : medias) {
                if (verMaior > mediasFinais) {
                    mediasMaiores++;
                }
            }
            double percentual = (mediasMaiores / qtdNotas) * 100;
            System.out.printf("%.3f%%%n", percentual);

            contador++;
        }

        leitor.close();
    }
}
