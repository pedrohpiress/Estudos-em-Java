import java.math.BigInteger;
import java.util.Scanner;

public class SomaDeFatorial {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        while (leitor.hasNext()) {

            int primeiroNum = leitor.nextInt();
            int segundoNum = leitor.nextInt();

            BigInteger fatorialPrimeiro = BigInteger.ONE;
            BigInteger fatorialSegundo = BigInteger.ONE;

            for (int i = 2; i <= primeiroNum; i++) {
                fatorialPrimeiro = fatorialPrimeiro.multiply(BigInteger.valueOf(i));
            }

            for (int i = 2; i <= segundoNum; i++) {
                fatorialSegundo = fatorialSegundo.multiply(BigInteger.valueOf(i));
            }

            BigInteger resultadoSoma = fatorialPrimeiro.add(fatorialSegundo);

            System.out.println(resultadoSoma);

        }

        leitor.close();
    }
}

