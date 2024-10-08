package example;

import javax.persistence.*;
import java.util.List;

public class JPAutil {
    private EntityManagerFactory emf;

    public JPAutil() {
        this.emf = Persistence.createEntityManagerFactory("JPAescola");
    }

    public void insertProfessor(Professor professor) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(professor);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public void insertAluno(Aluno aluno) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Professor buscarProfessorComTurmasPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Professor professor = null;
        try {
            professor = em.find(Professor.class, id);
            if (professor != null) {
                // Forçar o carregamento das turmas
                professor.getTurmas().size();
            }
        } finally {
            em.close();
        }
        return professor;
    }

    public Professor buscarProfessorPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Professor professor = null;
        try {
            professor = em.find(Professor.class, id);
        } catch (Exception e) {
            e.printStackTrace(); // Log de erros
        } finally {
            em.close();
        }
        return professor;
    }


    public Aluno buscarAlunoPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Aluno aluno = null;
        try {
            aluno = em.find(Aluno.class, id);
        } catch (Exception e) {
            e.printStackTrace(); // Log de erros
        } finally {
            em.close();
        }
        return aluno;
    }


    public void close() {
        if (emf != null) {
            emf.close();
        }
    }

    public void atualizarTurma(Turma turma) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(turma);
        em.getTransaction().commit();
        em.close();
    }
}
