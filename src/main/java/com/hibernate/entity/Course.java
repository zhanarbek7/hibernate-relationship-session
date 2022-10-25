package com.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String course_name;


    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "STUDENTS_COURSES",
            joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    )
    private List<Student> students;

    public Course(String course_name) {
        this.course_name = course_name;
    }

    public Course(String course_name, Teacher teacher) {
        this.course_name = course_name;
        this.teacher = teacher;
    }


    public Course(String course_name, Teacher teacher, List<Student> students) {
        this.course_name = course_name;
        this.teacher = teacher;
        this.students = students;
    }
}
