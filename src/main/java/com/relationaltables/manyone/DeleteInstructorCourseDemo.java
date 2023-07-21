package com.relationaltables.manyone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try {
            session.beginTransaction();

            System.out.println("getting instructor ");
            Course course = session.get(Course.class, 12);
            session.delete(course);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
