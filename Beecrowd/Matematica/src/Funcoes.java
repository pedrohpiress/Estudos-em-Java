import java.util.Scanner;

public class Funcoes {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Integer qtdRodadas = leitor.nextInt();


        int contador = 1;
        while (contador <= qtdRodadas) {
            Integer x = leitor.nextInt();
            Integer y = leitor.nextInt();

            Double formulaRafael = Math.pow((3 * x), 2) + Math.pow(y, 2);
            Double formulaBeto = 2 * Math.pow(x, 2) + Math.pow((5 * y), 2);
            Double formulaCarlos = -100 * x + Math.pow(y, 3);
            if (formulaRafael > formulaBeto && formulaRafael > formulaCarlos) {
                System.out.println("Rafael ganhou");
                contador++;
            }
            if (formulaBeto > formulaRafael && formulaBeto > formulaCarlos) {
                System.out.println("Beto ganhou");
                contador++;
            }
            if (formulaCarlos > formulaRafael && formulaCarlos > formulaBeto) {
                System.out.println("Carlos ganhou");
                contador++;
            }

        }

        leitor.close();
    }
}
