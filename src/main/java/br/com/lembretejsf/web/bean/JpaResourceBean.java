package br.com.lembretejsf.web.bean;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaResourceBean {

    private static EntityManagerFactory entityManagerFactory;

    private static EntityManagerFactory getEntityManagerFactory(){

        if (entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("lembretejsf_db");
        }
        return entityManagerFactory;
    }

}
