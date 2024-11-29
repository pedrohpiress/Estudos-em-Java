import java.util.Scanner;

public class Hashmat {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        while (leitor.hasNextLine()) {
            long a = leitor.nextLong();
            long b = leitor.nextLong();
            long resultado = Math.abs(a - b);
            System.out.println(resultado);
        }
        leitor.close();
    }
}
