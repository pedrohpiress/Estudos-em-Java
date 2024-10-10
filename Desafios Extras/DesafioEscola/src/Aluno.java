public class Aluno extends Usuario{
    private int matricula;
    private int turma;
    private int coeficienteGlobal;

    public Aluno(String nome, String endereco) {
        super(nome, endereco);
    }

    public void enviarAtividade(Integer totalAtividades){
        totalAtividades++;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getCoeficienteGlobal() {
        return coeficienteGlobal;
    }

    public void setCoeficienteGlobal(int coeficienteGlobal) {
        this.coeficienteGlobal = coeficienteGlobal;
    }
}
