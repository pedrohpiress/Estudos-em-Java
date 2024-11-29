//Joãozinho tem que ajudar seu pai. Um relatório específico com alguns números está saindo com caracteres indesejáveis no meio. A ideia é apenas somar os 3 valores que aparecem em cada linha sempre na mesma posição, ignorando as letras e apresentar esta soma. Não existem espaços em branco na linha.
//
//        Entrada
//A primeira linha de entrada contém um inteiro N (N < 100000). Seguem N linhas com exatos 14 caracteres que devem ser lidas e delas extraídos e somados os três números existentes.
//
//Saída
//Para cada linha de entrada, seu programa deve apresentar um valor numérico inteiro, que é a soma dos 3 números existentes na linha.

import java.util.Scanner;

public class ProblemaCalculadora {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        int linhas = leitor.nextInt();
        leitor.nextLine();

        for (int i = 0; i < linhas; i++) {
            String linha = leitor.nextLine();
            StringBuilder numeros = new StringBuilder();

            for (char inteiro : linha.toCharArray()) {
                if (Character.isDigit(inteiro)) {
                    numeros.append(inteiro);
                }
            }

            if (numeros.length() != 14) {
                System.out.println("A linha deve conter exatamente 6 dígitos.");
            }

            int num1 = Integer.parseInt(numeros.substring(0, 2));
            int num2 = Integer.parseInt(numeros.substring(2, 4));
            int num3 = Integer.parseInt(numeros.substring(4, 6));

            int soma = num1 + num2 + num3;

            System.out.println(soma);
        }

        leitor.close();
    }
}
