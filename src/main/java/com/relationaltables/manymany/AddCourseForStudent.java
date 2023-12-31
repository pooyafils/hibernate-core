package com.relationaltables.manymany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseForStudent {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();
            int studentId=5;
            Student student=session.get(Student.class,5);
            Course course=new Course("ios");
            Course course1=new Course("spring boot");
            course.addStudent(student);
            course1.addStudent(student);
            session.save(course);
            session.save(course1);


            session.getTransaction().commit();
        }
        finally {
            factory.close();
            session.close();
        }
        }
}
