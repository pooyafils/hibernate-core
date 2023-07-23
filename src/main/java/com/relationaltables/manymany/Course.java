package com.relationaltables.manymany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne(cascade ={ CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviewList;
    @ManyToMany(fetch = FetchType.LAZY,cascade ={CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name = "course_student",joinColumns = @JoinColumn(name = "course_id"),inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;
    public Course() {
    }

    public Course( String title, Instructor instructor) {

        this.title = title;
        this.instructor = instructor;
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
    public void addReview(Review reviewss){
        if(reviewList==null){
            reviewList=new ArrayList<>();
        }
        reviewList.add(reviewss);
    }
    public void addStudent(Student student){
        if(students==null){
            students=new ArrayList<>();
        }
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
