import java.util.ArrayList;
import java.util.Scanner;

public class ExercicioDois {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        while (true) {
            System.out.println("""
                    Selecione o que quer fazer e digite o número da alternativa
                    
                    1 - Digitar uma sequencia de números, um por vez
                    2 - Remover o primeiro número que foi inserido
                    3 - Sair
                    """);

            Integer alternativa = leitor.nextInt();

            switch (alternativa) {
                case 1:
                    System.out.println("Digite um número:");
                    Integer adicionarValor = leitor.nextInt();
                    lista.add(adicionarValor);
                    System.out.print("Números no vetor:");
                    for (Integer numero : lista) {
                        System.out.printf(" %d;", numero);
                    }
                    System.out.println("");
                    break;
                case 2:
                    if (!lista.isEmpty()) {
                        lista.removeFirst();
                        System.out.print("Números no vetor:");
                        for (Integer numero : lista) {
                            System.out.printf(" %d;", numero);
                        }
                        System.out.println("");
                    } else {
                        System.out.println("Não há elementos para remover.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    leitor.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}

