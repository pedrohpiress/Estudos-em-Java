import java.util.Scanner;

public class KageBunshinNoJutsu {
    public static void main(String[] args) {

            Scanner leitor = new Scanner(System.in);

            while (leitor.hasNext()){
                Integer numeroNinjas = leitor.nextInt();
                Integer qtdTecnica = 0;

                while (numeroNinjas > 1) {
                    numeroNinjas = numeroNinjas / 2;
                    qtdTecnica++;
                }
                System.out.println(qtdTecnica);
            }
    }
}
