package example.DAO;

import example.Classes.Turma;

import javax.persistence.*;
import java.util.List;

public class TurmaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAescola");

    public void criarTurma(Turma turma) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(turma);
        em.getTransaction().commit();
        em.close();
    }

    public List<Turma> listarTurmasComDetalhes() {
        EntityManager em = emf.createEntityManager();
        List<Turma> turmas = null;

        try {
            TypedQuery<Turma> query = em.createQuery("SELECT t FROM Turma t LEFT JOIN FETCH t.professor LEFT JOIN FETCH t.alunos", Turma.class);
            turmas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return turmas;
    }

}

