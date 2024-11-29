import java.util.Scanner;

//As crianças adoram desenhar árvores de natal e você desafiou algumas delas a desenharem árvores de diversos tamanhos com apenas com o caractere asterisco "*".
//
//A regra é simples. De baixo para cima, o tronco da árvore consiste de 3 asteriscos e depois 1. Em seguida vem o restante da árvore, com cada fileira de folhas iniciando no tamanho que você determinou e diminuindo de dois em dois, até chegar na copa da árvore que terá apenas um asterisco. Note que para isso dar certo, somente será permitido tamanhos ímpares para estas árvores.
//
//        Entrada
//A entrada contém vários casos de teste e termina com EOF. Cada caso de teste consiste em um inteiro N (2 < N < 100).
//
//Saída
//Para cada caso de teste de entrada, seu programa deverá desenhar uma árvore conforme especificação acima e exemplo abaixo, com uma linha em branco após cada árvore.

public class ArvoreDeNatal {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        while (leitor.hasNextInt()) {
            int qtdAsterisco = leitor.nextInt();
            char asterisco = '*';
            int base = qtdAsterisco;

            for (int i = 1; i <= base; i += 2) {
                for (int j = (base - i) / 2; j > 0; j--) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print(asterisco);
                }
                System.out.println();
            }

            for (int i = 0; i < 1; i++) {
                for (int j = (base - 1) / 2; j > 0; j--) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }

            for (int i = 0; i < 1; i++) {
                for (int j = (base - 3) / 2; j > 0; j--) {
                    System.out.print(" ");
                }
                System.out.println("***");
            }

            System.out.println();
        }

        leitor.close();

    }
}
