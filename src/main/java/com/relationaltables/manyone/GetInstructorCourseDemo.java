package com.relationaltables.manyone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try {
            System.out.println("getting instructor ");
            session.beginTransaction();
            Instructor instructor=session.get(Instructor.class,7);
            System.out.println(instructor.getCourses());
            System.out.println(instructor.getInstructorDetail());
            session.getTransaction().commit();
            System.out.println("Done !");
        }
        finally {
            factory.close();
            session.close();
        }
    }
}
