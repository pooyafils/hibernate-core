package com.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try{
            Session session=factory.getCurrentSession();
            session.beginTransaction();
            int id=1;
       // Student student=session.get(Student.class,id);
        System.out.println("delete student");
        //session.delete(student);

            // delete student with different way
            session.createQuery("delete from Student  where id=2").executeUpdate();
        session.getTransaction().commit();
        System.out.println("Done !");
        }
        finally {
            factory.close();
        }
    }
}
