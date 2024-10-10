public class Professor extends Usuario{
    private int salario;
    private String materias;
    private int turmas;

    public Professor(String nome, String endereco) {
        super(nome, endereco);
    }

    public void enviarNotas(Integer notasAlunos){
        notasAlunos++;
    }

    public int getTurmas() {
        return turmas;
    }

    public void setTurmas(int turmas) {
        this.turmas = turmas;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getMaterias() {
        return materias;
    }

    public void setMaterias(String materias) {
        this.materias = materias;
    }

}
