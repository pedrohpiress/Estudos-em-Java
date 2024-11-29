import java.util.Scanner;

public class Filhos {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        while (leitor.hasNextLine()) {

            Integer filhos = leitor.nextInt();
            Integer filhas = leitor.nextInt();

            if (filhos == 0 && filhas == 0){
                break;
            }

            int totalFilhos;
            while (filhas >= 0 && filhos >= 0) {
                totalFilhos = filhos + filhas;
                System.out.println(totalFilhos);
                break;
            }

        }

        leitor.close();

    }
}
