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
import model.Turma;

/**
 *
 * @author coliv
 */
public class TurmaDao {
    
    public void atualizaTurma(Turma turma){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(turma);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public void cadastraTurma(Turma turma) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(turma);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
        }
    }
    
    public Turma findById(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Turma t = new Turma();
        try {
            t = em.find(Turma.class, id);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
            throw e;
        }
        return t;
    }
    
    public List<Turma> findAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Turma> lista = new ArrayList<>();
        try {
            lista = em.createQuery("Select a From Turma a", Turma.class).getResultList();
            em.close();
        } catch (Exception e) {
            em.close();
            throw e;
        }
        return lista;
    }
}
