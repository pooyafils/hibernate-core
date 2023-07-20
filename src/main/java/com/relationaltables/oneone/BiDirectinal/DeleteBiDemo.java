package com.relationaltables.oneone.BiDirectinal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteBiDemo {
    public static void main(String[] args) {

        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try {
            session.beginTransaction();

InstructorDetail instructorDetail=session.get(InstructorDetail.class,3);
System.out.println("deleting  instructor Detail "+instructorDetail);
session.delete(instructorDetail);
System.out.println("Done !");
            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
        }
}
