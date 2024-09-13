import java.util.Scanner;

//João quer montar um painel de leds contendo diversos números. Ele não possui muitos leds, e não tem certeza se conseguirá montar o número desejado. Considerando a configuração dos leds dos números abaixo, faça um algoritmo que ajude João a descobrir a quantidade de leds necessário para montar o valor.
//
//Obs.: Para programadores de Javascript, recomenda-se o uso de "input.trim().split('\n')" para evitar erros conhecidos.
//
//
//
//
//Entrada
//A entrada contém um inteiro N, (1 ≤ N ≤ 1000) correspondente ao número de casos de teste, seguido de N linhas, cada linha contendo um número (1 ≤ V ≤ 10100) correspondente ao valor que João quer montar com os leds.
//
//Saída
//Para cada caso de teste, imprima uma linha contendo o número de leds que João precisa para montar o valor desejado, seguido da palavra "leds".

public class Led {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int qtdCasosTeste = leitor.nextInt();
        int[] ledsPorDigito = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        for (int i = 0; i <= qtdCasosTeste; i++) {
            int totalLeds = 0;
            String numero = leitor.nextLine();

            for (char digito : numero.toCharArray()) {
                int digitoInt = Character.getNumericValue(digito);
                totalLeds += ledsPorDigito[digitoInt];
            }

            if (i > 0) {
                System.out.println(totalLeds + " leds");
            }
        }

    }
}
