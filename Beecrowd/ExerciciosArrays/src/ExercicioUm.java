import java.util.Scanner;
import java.util.ArrayList;

public class ExercicioUm {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        while (true) {
            System.out.println("""
                    Selecione o que quer fazer e digite o número da alternativa
                    
                    1 - Digitar uma sequencia de números, um por vez
                    2 - Remover o último número que foi inserido
                    3 - Ler o seu vetor programa
                    4 - Sair
                    """);

            Integer alternativa = leitor.nextInt();

            switch (alternativa) {
                case 1:
                    System.out.println("Digite um número:");
                    Integer adicionarValor = leitor.nextInt();
                    lista.add(adicionarValor);
                    break;
                case 2:
                    if (!lista.isEmpty()) {
                        lista.removeLast();
                    } else {
                        System.out.println("Não há elementos para remover.");
                    }
                    break;
                case 3:
                    if (!lista.isEmpty()) {
                        System.out.print("Números no vetor:");
                        for (Integer numero : lista) {
                            System.out.printf(" %d;", numero);
                        }
                    } else {
                        System.out.println("A lista está vazia.");
                    }
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    leitor.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }
}

