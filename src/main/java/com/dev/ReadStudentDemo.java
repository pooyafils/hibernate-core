package com.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            System.out.println("creating new student object");
            Student student = new Student("zara", "marker", "@zara.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("saving student with id " + student.getId());

// getting student from database

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("geting student with id " + student.getId());
            Student student1 = session.get(Student.class, student.getId());
            System.out.println("get student" + student1);
            session.getTransaction().commit();


            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
