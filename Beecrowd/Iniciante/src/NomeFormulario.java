import java.util.Scanner;

public class NomeFormulario {
    public static void main(String[] args) {

        String linhaDeTexto = "";

        Scanner leitor = new Scanner(System.in);
        linhaDeTexto = leitor.nextLine();

        if (linhaDeTexto.length() > 80){
            System.out.println("NO");
            System.out.println(linhaDeTexto.length());
        } else {
            System.out.println("YES");
            System.out.println(linhaDeTexto.length());
        }


    }
}
