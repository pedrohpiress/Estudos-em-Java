package example;

import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        JPAutil jpautil = new JPAutil();
        TurmaDAO turmaDAO = new TurmaDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Sistema de Gestão Escolar ===");
            System.out.println("1. Cadastrar Turma");
            System.out.println("2. Cadastrar Aluno");
            System.out.println("3. Cadastrar Professor");
            System.out.println("4. Listar Turmas");
            System.out.println("5. Listar Alunos");
            System.out.println("6. Listar Professores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Turma turma = new Turma();
                    System.out.print("Nome da Turma: ");
                    turma.setNomeTurma(scanner.nextLine());

                    turmaDAO.criarTurma(turma);
                    System.out.println("Turma cadastrada com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome da turma: ");
                    String nomeTurmaAluno = scanner.nextLine();
                    Turma turmaAluno = turmaDAO.buscarTurma(nomeTurmaAluno);

                    if (turmaAluno != null) {
                        Aluno aluno = new Aluno();
                        System.out.print("Nome do Aluno: ");
                        aluno.setNome(scanner.nextLine());
                        turmaAluno.adicionarAluno(aluno);
                        jpautil.insertAluno(aluno);
                        System.out.println("Aluno cadastrado com sucesso na turma " + nomeTurmaAluno + "!");
                    } else {
                        System.out.println("Turma não existe! Por favor, crie uma turma primeiro.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome da turma: ");
                    String nomeTurmaProfessor = scanner.nextLine();
                    Turma turmaProfessor = turmaDAO.buscarTurma(nomeTurmaProfessor);

                    if (turmaProfessor != null) {
                        Professor professor = new Professor();
                        System.out.print("Nome do Professor: ");
                        professor.setNome(scanner.nextLine());
                        System.out.print("Salário: ");
                        professor.setSalario(scanner.nextDouble());
                        scanner.nextLine();
                        turmaProfessor.setProfessor(professor);
                        jpautil.insertProfessor(professor);
                        System.out.println("Professor cadastrado com sucesso na turma " + nomeTurmaProfessor + "!");
                    } else {
                        System.out.println("Turma não existe! Por favor, crie uma turma primeiro.");
                    }
                    break;

                case 4:
                    List<Turma> turmas = turmaDAO.listarTurmas();
                    System.out.println("=== Lista de Turmas ===");
                    for (Turma t : turmas) {
                        System.out.println("Nome: " + t.getNomeTurma());
                    }
                    break;

                case 5:
                    List<Aluno> alunos = jpautil.selectAlunos();
                    System.out.println("=== Lista de Alunos ===");
                    for (Aluno a : alunos) {
                        System.out.println("ID: " + a.getIdAluno() + ", Nome: " + a.getNome());
                    }
                    break;

                case 6:
                    List<Professor> professores = jpautil.selectProfessores();
                    System.out.println("=== Lista de Professores ===");
                    for (Professor p : professores) {
                        System.out.println("ID: " + p.getIdProfessor() + ", Nome: " + p.getNome() + ", Salário: " + p.getSalario());
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        jpautil.close();
        scanner.close();
    }
}
