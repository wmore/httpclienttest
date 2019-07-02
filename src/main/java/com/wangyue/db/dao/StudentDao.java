package com.wangyue.db.dao;

import com.wangyue.db.model.TStudent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentDao {
    public void saveStudent(TStudent student) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }

    public void batchSaveStudentS(List<TStudent> students) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(students);
        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }
}
