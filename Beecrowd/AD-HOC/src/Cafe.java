import java.util.Scanner;

public class Cafe {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Integer numEstudantes = leitor.nextInt();
        Integer litrosCafe = leitor.nextInt();
        Integer mlPorEstudante = leitor.nextInt(); // transformar para litro depois

        Integer totalCafeMl = numEstudantes * mlPorEstudante;
        Integer totalLitrosNecessarios = (totalCafeMl + 999) / 1000;

        Integer lotesNecessarios = (totalLitrosNecessarios + litrosCafe - 1) / litrosCafe;
        Integer prepararLitros = lotesNecessarios * litrosCafe;

        System.out.println(prepararLitros);
    }
}
