package com.relationaltables.manyone.UniDirectinal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetUniDirectinalCourseAndReview {
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
            Course course=session.get(Course.class,12);
            System.out.println(course);
            System.out.println(course.getReviewList());

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
