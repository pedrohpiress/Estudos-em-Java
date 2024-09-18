import java.sql.SQLOutput;
import java.util.Scanner;

public class DesafioBanco {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = leitor.next();
        System.out.println("Tipo de conta: ");
        String tipoConta = leitor.next();
        System.out.println("Digite seu saldo inicial");
        Double saldo = leitor.nextDouble();
        Integer operacoes = 0;

        System.out.println("""
                ***********************************
                Dados iniciais do cliente:
                Nome:                   %s
                Tipo de conta:          %s
                Saldo inicial:          R$: %.2f   
                ************************************
                """.formatted(nome, tipoConta, saldo));

        String menu = """
                Operações
                
                      1 - Consultar saldo
                      2 - Receber valor
                      3 - Transferir valor
                      4 - Sair
                """;

        System.out.println(menu);
        Scanner novo = new Scanner(System.in);

        while (operacoes != 4) {
            System.out.println(menu);
            operacoes = novo.nextInt();
            if (operacoes.equals(1)) {
                System.out.println("Seu saldo é de: " + saldo);
            } else if (operacoes.equals(2)) {
                Double receber = leitor.nextDouble();
                saldo += receber;
                System.out.println("Saldo atual: " + saldo);
            } else if (operacoes.equals(3)) {
                System.out.println("Qual o valor que deseja transferir? ");
                Double transferir = leitor.nextDouble();
                if (saldo >= transferir) {
                    saldo -= transferir;
                } else {
                    System.out.println("Não é possível realizar essa transferência");
                }
                System.out.println("Saldo atual: " + saldo);
            } else if (operacoes > 4) {
                System.out.println("Operação inválida");
            }
        }
    }
}
