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
    
    
    public void cadastraTurma(Turma turma) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPPO_EscolaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(turma);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
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
        } catch (Exception e) {
            em.getTransaction().rollback();
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
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
