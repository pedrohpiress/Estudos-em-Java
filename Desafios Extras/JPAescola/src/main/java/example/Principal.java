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
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Criar Turma");
            System.out.println("4. Listar Turmas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Aluno aluno = new Aluno();
                    System.out.print("Nome do Aluno: ");
                    aluno.setNome(scanner.nextLine());

                    System.out.println("=== Turmas Disponíveis ===");
                    List<Turma> turmasDisponiveis = turmaDAO.listarTurmasComDetalhes();
                    for (Turma t : turmasDisponiveis) {
                        System.out.println("ID: " + t.getIdTurma() + ", Nome: " + t.getNomeTurma());
                    }

                    System.out.print("Escolha o ID da Turma para o Aluno: ");
                    int turmaId = scanner.nextInt();
                    scanner.nextLine();

                    Turma turmaSelecionada = null;
                    for (Turma t : turmasDisponiveis) {
                        if (t.getIdTurma() == turmaId) {
                            turmaSelecionada = t;
                            break;
                        }
                    }

                    if (turmaSelecionada != null) {
                        aluno.adicionarTurma(turmaSelecionada);
                        jpautil.insertAluno(aluno);
                        jpautil.atualizarTurma(turmaSelecionada); // Atualiza a turma para incluir o aluno
                        System.out.println("Aluno cadastrado na turma com sucesso!");
                    } else {
                        System.out.println("Turma não encontrada.");
                    }
                    break;

                case 2:
                    Professor professor = new Professor();
                    System.out.print("Nome do Professor: ");
                    professor.setNome(scanner.nextLine());
                    System.out.print("Salário: ");
                    professor.setSalario(scanner.nextDouble());
                    scanner.nextLine();
                    jpautil.insertProfessor(professor);
                    System.out.println("Professor cadastrado com sucesso!");
                    break;

                case 3:
                    Turma turma = new Turma();
                    System.out.print("Nome da Turma: ");
                    turma.setNomeTurma(scanner.nextLine());
                    System.out.print("ID do Professor para esta Turma: ");
                    int professorId = scanner.nextInt();
                    Professor professorTurma = jpautil.buscarProfessorComTurmasPorId(professorId);
                    if (professorTurma != null) {
                        turma.setProfessor(professorTurma);
                        professorTurma.adicionarTurma(turma);
                        turmaDAO.criarTurma(turma);
                        System.out.println("Turma criada com sucesso!");
                    } else {
                        System.out.println("Professor não encontrado.");
                    }
                    break;

                case 4:
                    List<Turma> turmas = turmaDAO.listarTurmasComDetalhes();
                    System.out.println("=== Lista de Turmas ===");
                    for (Turma t : turmas) {
                        System.out.println("Turma: " + t.getNomeTurma());
                        System.out.println("Professor: " + (t.getProfessor() != null ? t.getProfessor().getNome() : "Nenhum"));
                        System.out.print("Alunos: ");
                        if (!t.getAlunos().isEmpty()) {
                            for (Aluno alunoList : t.getAlunos()) {
                                System.out.print(alunoList.getNome() + ", ");
                            }
                        } else {
                            System.out.print("Nenhum aluno cadastrado.");
                        }
                        System.out.println();
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
