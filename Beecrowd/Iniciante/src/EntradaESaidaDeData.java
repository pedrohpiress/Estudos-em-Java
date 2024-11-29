import java.util.Scanner;

public class EntradaESaidaDeData {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Integer dia = leitor.nextInt();
        Integer mes = leitor.nextInt();
        Integer ano = leitor.nextInt();

        System.out.println("%02d/%02d/%02d".formatted(mes, dia, ano));
        System.out.println("%02d/%02d/%02d".formatted(ano, mes, dia));
        System.out.println("%02d-%02d-%02d".formatted(dia, mes, ano));

    }
}
