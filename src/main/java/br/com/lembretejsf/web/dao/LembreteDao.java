package br.com.lembretejsf.web.dao;

import br.com.lembretejsf.web.bean.JpaResourceBean;
import br.com.lembretejsf.web.model.Lembrete;

import javax.persistence.EntityManager;
import java.util.List;

public class LembreteDao {

    public List<Lembrete> listarTodos() throws Exception {

        EntityManager em  = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        List<Lembrete> lembretes = null;

        try {
            lembretes = em.createQuery("from Lembrete").getResultList();
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            em.close();
        }

        return lembretes;
    }

    public void inserir(Lembrete lembrete) throws Exception {

        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(lembrete);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);

        }finally {
            em.close();
        }
    }

    public void atualizar(Lembrete lembrete) throws Exception {

        EntityManager em  = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(lembrete);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);

        }finally {
            em.close();
        }
    }

    public void excluir(long id) throws Exception {

        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            throw new Exception(e);
        }finally {
            em.close();
        }
    }

    public Lembrete selecionar(long id) throws Exception{

        Lembrete lembrete;

        EntityManager em = JpaResourceBean.getEntityManagerFactory().createEntityManager();

        try {
            lembrete = em.find(Lembrete.class, id);
        }finally {
            em.close();
        }
        return lembrete;
    }
}
