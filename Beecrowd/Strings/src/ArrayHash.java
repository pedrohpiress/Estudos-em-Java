import java.util.Scanner;

//Você terá como uma entrada várias linhas, cada uma com uma string. O valor de cada caracter é computado como segue:
//
//Valor = (Posição no alfabeto) + (Elemento de entrada) + (Posição do elemento)
//
//Todas posições são baseadas em zero. 'A' tem posição 0 no alfabeto, 'B' tem posição 1 no alfabeto, ... O cálculo de hash retornado é a soma de todos os caracteres da entrada. Por exemplo, se a entrada for:
//CBA
//        DDD
//
//então cada caractere deverá ser computado como segue:
//
//        2 = 2 + 0 + 0 : 'C' no elemento 0 posição 0
//        2 = 1 + 0 + 1 : 'B' no elemento 0 posição 1
//        2 = 0 + 0 + 2 : 'A' no elemento 0 posição 2
//        4 = 3 + 1 + 0 : 'D' no elemento 1 posição 0
//        5 = 3 + 1 + 1 : 'D' no elemento 1 posição 1
//        6 = 3 + 1 + 2 : 'D' no elemento 1 posição 2
//
//O cálculo final de hash será 2+2+2+4+5+6 = 21.
//
//Entrada
//A entrada contém vários casos de teste. A primeira linha de entrada contém um inteiro N que indica a quantidade de casos de teste. Cada caso de teste inicia com um inteiro L (1 ≤ L ≤ 100) que indica a quantidade de linhas que vem a seguir. Cada uma destas L linhas contém uma string com até 50 letras maiúsculas ('A' - 'Z').
//
//Saída
//Para cada caso de teste imprima o valor de hash que é calculado conforme o exemplo apresentado acima.

public class ArrayHash {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        while (leitor.hasNextLine()) {

            int qtdCasos = leitor.nextInt();
            for (int cont = 0; cont < qtdCasos; cont++) {
                int qtdLinhas = leitor.nextInt();
                leitor.nextLine();

                int total = 0;

                for (int linha = 0; linha < qtdLinhas; linha++) {
                    String entrada = leitor.nextLine();

                    for (int posicao = 0; posicao < entrada.length(); posicao++) {
                        char caractere = entrada.charAt(posicao);
                        int posicaoAlfabeto = caractere - 'A';
                        int elementoDeEntrada = cont;
                        int posicaoCaractere = posicao;

                        int valor = posicaoAlfabeto + elementoDeEntrada + posicaoCaractere;

                        total += valor;
                    }
                }
                System.out.println(total);

            }
        }
        leitor.close();
    }
}
