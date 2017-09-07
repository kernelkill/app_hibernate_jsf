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
}
