import br.com.v8.modelos.*;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Calculo numeros = new Calculo();

        System.out.println("Digite a operacao que deseja fazer");
        String operacao = leitor.next().toLowerCase();
        if (!operacao.equals("soma") && !operacao.equals("divisao") && !operacao.equals("multiplicacao") && !operacao.equals("subtracao")) {

            System.out.println("Digite uma operação valida!");

        } else {

            System.out.println("Digite o primeiro numero");
            numeros.numero1 = leitor.nextDouble();

            System.out.println("Digite o segundo numero");
            numeros.numero2 = leitor.nextDouble();
            OperacaoMatematica soma = new Soma();
            OperacaoMatematica subtracao = new Subtracao();
            OperacaoMatematica multiplicacao = new Multiplicacao();
            OperacaoMatematica divisao = new Divisao();

            double retorno = 0;

            switch (operacao) {
                case "soma" -> retorno = numeros.resultado = soma.calcular(numeros.numero1, numeros.numero2);
                case "subtracao" -> retorno = numeros.resultado = subtracao.calcular(numeros.numero1, numeros.numero2);
                case "multiplicacao" ->
                        retorno = numeros.resultado = multiplicacao.calcular(numeros.numero1, numeros.numero2);
                case "divisao" -> retorno = numeros.resultado = divisao.calcular(numeros.numero1, numeros.numero2);
                default -> System.out.println("erro");
            }

            System.out.println("Resultado: " + retorno);

        }

    }
}
