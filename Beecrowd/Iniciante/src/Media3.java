import java.util.Scanner;

public class Media3 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Double nota1 = leitor.nextDouble();
        Double nota2 = leitor.nextDouble();
        Double nota3 = leitor.nextDouble();
        Double nota4 = leitor.nextDouble();

        Integer peso1 = 2;
        Integer peso2 = 3;
        Integer peso3 = 4;
        Integer peso4 = 1;

        Double mediaPonderada = (nota1 * peso1 + nota2 * peso2 + nota3 * peso3 + nota4 * peso4) / (peso1 + peso2 + peso3 + peso4);

        System.out.printf("Media: %.1f%n", Math.floor(mediaPonderada * 10) / 10);

        double mediaExame = 0.0;

        if (mediaPonderada < 5) {
            System.out.println("Aluno reprovado.");
        } else if (mediaPonderada >= 5 && mediaPonderada <= 6.9) {
            System.out.println("Aluno em exame.");

            Double notaExame = leitor.nextDouble();

            System.out.println("Nota do exame: " + notaExame);

            mediaExame = (mediaPonderada + notaExame) / 2;

            if (mediaPonderada >= 5) {
                System.out.println("Aluno aprovado.");
                System.out.println(String.format("""
                        Media final: %.1f""", mediaExame));
            } else {
                System.out.println("Aluno reprovado.");
                System.out.println(String.format("""
                        Media final: %.1f""", mediaExame));
            }

        } else {
            System.out.println("Aluno aprovado.");
        }

    }
}
