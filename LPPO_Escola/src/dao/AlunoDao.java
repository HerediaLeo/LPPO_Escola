/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Aluno;
import model.Turma;

/**
 *
 * @author coliv
 */
public class AlunoDao {
    
    public Aluno findById(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Aluno a = new Aluno();
        try {
            a = em.find(Aluno.class, id);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
            throw e;
        }
        return a;
    }
    
    
    public void cadastraAluno(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(aluno);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public Aluno findByMatricula(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Aluno a = new Aluno();
        try {
            a = em.find(Aluno.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return a;
    }
    
    public void removeAluno(Long matricula){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.getReference(Aluno.class, matricula));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    public List<Aluno> findByTurma(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Aluno> listaAluno = new ArrayList<>();
        try {
            listaAluno = em.createQuery("Select a From Aluno a where a.turma.id = " + id + "order by a.nome", Aluno.class).getResultList();
        } catch (Exception e) {
            throw e;
        }
        return listaAluno;
    }
    
    public List<Turma> findAllPcd(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Turma> lista = new ArrayList<>();
        try {
            lista = em.createQuery("select distinct(a.turma) from Aluno a where a.pcd = true", Turma.class).getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public List<Aluno> findAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Aluno> lista = new ArrayList<>();
        try {
            lista = em.createQuery("select a from Aluno a", Aluno.class).getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
}
