package com.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
          //  List<Student> findStudent = session.createQuery("from Student").list();
        //    List<Student> findStudent = session.createQuery("from  Student s where s.lastName='marker'").list();
            List<Student> findStudent = session.createQuery("from Student s where s.lastName='marker' and s.firstName='paul'").list();
            for (Student student : findStudent) {

                System.out.println(student);

            }
            session.getTransaction().commit();

        }
        finally{
                factory.close();
            }
    }
}
