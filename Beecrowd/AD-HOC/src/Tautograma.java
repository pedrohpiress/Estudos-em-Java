import java.util.Scanner;

public class Tautograma {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        while (true) {
            String frase = leitor.nextLine();

            if (frase.equals("*")) {
                break;
            }

            String[] palavras = frase.split(" ");

            if (palavras.length == 0) {
                System.out.println("N");
                continue;
            }

            char letraInicial = Character.toLowerCase(palavras[0].charAt(0));
            boolean letrasIguais = true;

            for (int i = 1; i < palavras.length; i++) {
                if (Character.toLowerCase(palavras[i].charAt(0)) != letraInicial) {
                    letrasIguais = false;
                    break;
                }
            }

            if (letrasIguais) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }

        leitor.close();
    }
}
