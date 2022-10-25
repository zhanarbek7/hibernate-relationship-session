package com.hibernate.dao.impl;

import com.hibernate.dao.PassportDao;
import com.hibernate.entity.Passport;
import com.hibernate.util.DbConnection;
import jakarta.persistence.EntityManager;

public class PassportDaoImpl implements PassportDao {
    @Override
    public void addPassport(Passport passport) {
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(passport);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
