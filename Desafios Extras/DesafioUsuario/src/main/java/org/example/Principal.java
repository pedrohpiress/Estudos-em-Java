package org.example;

import DAO.UsuarioDAO;
import tabelas.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Scanner leitor = new Scanner(System.in);
        Usuario usuarioInsert = new Usuario();

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Ver usuários cadastrados");
            System.out.println("0. Sair");
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    usuarioInsert.setNome(leitor.nextLine());
                    System.out.print("Digite o CPF: ");
                    usuarioInsert.setCpf(leitor.nextLine());
                    System.out.print("Digite o telefone: ");
                    usuarioInsert.setTelefone(leitor.nextLine());
                    System.out.print("Digite o email: ");
                    usuarioInsert.setEmail(leitor.nextLine());
                    System.out.print("Digite a data de nascimento (YYYY-MM-DD): ");
                    String dataNascStr = leitor.nextLine();
                    usuarioInsert.setDtNasc(LocalDate.parse(dataNascStr));
                    usuarioDao.insertUsuario(usuarioInsert);
                    break;
                case 2:
                    usuarioDao.selectUsuario();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        leitor.close();
    }
}
