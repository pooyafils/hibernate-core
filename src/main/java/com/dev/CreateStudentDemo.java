package com.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try{
            System.out.println("creating new student object");
            Student student=new Student("paul","marker","@pauck.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Done");
        }

        finally {
            factory.close();
        }
    }
}
