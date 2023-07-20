package com.relationaltables.oneone;

import com.dev.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try {
            System.out.println("saving began");
            session.beginTransaction();
            Instructor instructor=new Instructor("alex","smith","@googlesmith.com");
            InstructorDetail instructorDetail=new InstructorDetail("smith youtube","youtube");
instructor.setInstructorDetail(instructorDetail);
session.save(instructor);
System.out.println("instructor has been saved !");
            session.getTransaction().commit();
        }

        finally {
factory.close();
        }
    }
}
