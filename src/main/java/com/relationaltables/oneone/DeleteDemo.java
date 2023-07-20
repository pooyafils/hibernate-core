package com.relationaltables.oneone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try {
            session.beginTransaction();
Instructor instructor=session.get(Instructor.class,2);
System.out.println("found the  instructor "+instructor);
if(instructor!=null){
    session.delete(instructor);
    //it will delete both instructor and instructor detail
}

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }
}
