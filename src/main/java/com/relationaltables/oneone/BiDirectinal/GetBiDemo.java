package com.relationaltables.oneone.BiDirectinal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetBiDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try {
            session.beginTransaction();

            System.out.println("find instructor bi ");
            InstructorDetail instructorDetail=session.get(InstructorDetail.class,3);
            System.out.println("bi instructor  "+instructorDetail.getInstructor());
System.out.println("done !");
            session.getTransaction().commit();
        }

        finally {
            session.close();
factory.close();
        }
    }
}
