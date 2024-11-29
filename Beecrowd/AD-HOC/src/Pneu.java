import java.util.Scanner;

public class Pneu {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        while (leitor.hasNextLine()){

            Integer pressaoIndicada = leitor.nextInt();
            Integer pressaoLida = leitor.nextInt();

            int pressaoFinal = pressaoIndicada - pressaoLida;

            System.out.println(pressaoFinal);

        }
        leitor.close();
    }
}
