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

    public List<Professor> selectProfessores() {
        EntityManager em = emf.createEntityManager();
        List<Professor> professores = null;

        try {
            TypedQuery<Professor> query = em.createQuery("SELECT p FROM Professor p", Professor.class);
            professores = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Adiciona um log para ver erros
        } finally {
            em.close();
        }

        return professores;
    }

    public List<Aluno> selectAlunos() {
        EntityManager em = emf.createEntityManager();
        List<Aluno> alunos = null;

        try {
            TypedQuery<Aluno> query = em.createQuery("SELECT a FROM Aluno a LEFT JOIN FETCH a.turmas", Aluno.class);
            alunos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return alunos;
    }

    public void close() {
        if (emf != null) {
            emf.close();
        }
    }
}
