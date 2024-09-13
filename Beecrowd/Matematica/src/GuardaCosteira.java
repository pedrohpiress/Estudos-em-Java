import java.util.Scanner;

public class GuardaCosteira {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        while (leitor.hasNext()){
            Integer distanciaInicial = leitor.nextInt();
            Integer velFugitivo = leitor.nextInt();
            Integer velGuardas = leitor.nextInt();

            double distanciaLimite = 12.0;

            double distanciaGuarda = Math.sqrt(distanciaInicial * distanciaInicial + distanciaLimite * distanciaLimite);
            double tempoFugitivo = distanciaLimite / velFugitivo;
            double tempoGuardas = distanciaGuarda / velGuardas;

            if (tempoGuardas <= tempoFugitivo){
                System.out.println("S");
            } else {
                System.out.println("N");
            }

        }
        leitor.close();

    }
}
