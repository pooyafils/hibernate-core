package com.relationaltables.manyone.UniDirectinal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUniDirectinalCourseAndReview {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Instructor instructor=new Instructor("alex","smit","@smit.com");
            InstructorDetail instructorDetail=new InstructorDetail("smit course","java");
            instructor.setInstructorDetail(instructorDetail);
 Course course=new Course("PAC MAN",instructor);
 course.addReview(new Review("good courses"));
            course.addReview(new Review("good course"));
            instructor.add(course);
            session.save(instructor);
session.save(course);


    System.out.println("Done !");
            session.getTransaction().commit();
        }
        finally {
factory.close();
session.close();
        }
    }
}
