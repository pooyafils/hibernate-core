package com.relationaltables.manyone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();
        try {
            session.beginTransaction();

            Instructor instructor=new Instructor("alexo","smitho","@googlesmitho.com");
            InstructorDetail instructorDetail=new InstructorDetail("smitho youtube","youtube");
            Course course=new Course("java",instructor);

            instructor.add(course);
            instructor.setInstructorDetail(instructorDetail);

            session.save(instructor);
            System.out.println("instructor has been saved !"+instructor.getId());


            session.getTransaction().commit();
            System.out.println("Done !");
    }
        finally {
            session.close();
            factory.close();
        }
        }
}
