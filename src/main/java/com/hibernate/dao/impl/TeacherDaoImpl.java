package com.hibernate.dao.impl;

import com.hibernate.dao.TeacherDao;
import com.hibernate.entity.Teacher;
import com.hibernate.util.DbConnection;
import jakarta.persistence.EntityManager;

public class TeacherDaoImpl implements TeacherDao {
    @Override
    public void addTeacher(Teacher teacher) {
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
