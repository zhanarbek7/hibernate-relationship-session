package com.hibernate;

import com.hibernate.dao.impl.PassportDaoImpl;
import com.hibernate.dao.impl.TeacherDaoImpl;
import com.hibernate.entity.Course;
import com.hibernate.entity.Passport;
import com.hibernate.entity.Student;
import com.hibernate.entity.Teacher;
import com.hibernate.util.DbConnection;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        Teacher teacher = new Teacher("Atai");
//
//        Student student1 = new Student("Katya");
//        Student student2 = new Student("Maksat");
//
//        Course course = new Course("Physics 1", teacher, List.of(student1, student2));



        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();

        Course teacher = entityManager.find(Course.class, 2L);
        entityManager.remove(teacher);

        entityManager.getTransaction().commit();
        entityManager.close();


    }


    public static void testMerge(){
        EntityManager entityManager = DbConnection.getEntityManager();

//        int addressId;
//        Person person = buildPerson("devender");
//        Address address = buildAddress(person);
//        person.setAddresses(Arrays.asList(address));
//        session.persist(person);
//        session.flush();
//        addressId = address.getId();
//        session.clear();
//
//        Address savedAddressEntity = session.find(Address.class, addressId);
//        Person savedPersonEntity = savedAddressEntity.getPerson();
//        savedPersonEntity.setName("devender kumar");
//        savedAddressEntity.setHouseNumber(24);
//        session.merge(savedPersonEntity);
//        session.flush();
        entityManager.getTransaction().begin();
        Teacher teacher = new Teacher("Mukhamed");
        Passport passport = new Passport("AC4937284",LocalDate.now());

    }


}