package example.Classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfessor;

    private String nome;
    private double salario;

    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas = new ArrayList<>();

    public Professor() {}

    public int getIdProfessor() {
        return idProfessor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
        turma.setProfessor(this);
    }
}
