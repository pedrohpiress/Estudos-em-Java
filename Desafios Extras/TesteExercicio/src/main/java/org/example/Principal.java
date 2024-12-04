package org.example;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        CalculoCaptura calculo = new CalculoCaptura();

        while (leitor.hasNext()) {
            int distanciaInicial = leitor.nextInt();
            int velFugitivo = leitor.nextInt();
            int velGuardas = leitor.nextInt();

            System.out.println(calculo.verificarCaptura(distanciaInicial, velFugitivo, velGuardas) ? "S" : "N");
        }
        leitor.close();
    }
}
