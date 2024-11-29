package DAO;

import tabelas.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsuarioDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Loja");

    public void insertUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(usuario);

        em.getTransaction().commit();
        em.close();
    }

    public void selectUsuario() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
        List<Usuario> usuarios = query.getResultList();

        for (Usuario usuario : usuarios) {
            System.out.println("--------------------------");
            System.out.println("ID: " + usuario.getIdUsuario());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("CEP: " + usuario.getCep());
            System.out.println("Data de nascimento: " + usuario.getDtNasc());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Telefone: " + usuario.getTelefone());
            System.out.println("--------------------------");
        }

        em.close();
    }
}
