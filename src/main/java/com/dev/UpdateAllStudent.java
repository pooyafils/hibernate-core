package com.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateAllStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            System.out.println("update all students");
            session.createQuery("update Student set email='test update@gmail.com'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done !");
        } finally {
factory.close();
        }

    }
}
