package com.hibernate.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id;

    private String name;


    @OneToMany(mappedBy = "teacher", cascade = CascadeType.REMOVE)
    private List<Course> courses;

    @OneToOne(mappedBy = "teacher_id")
    @JoinColumn(name = "passport_id")
    private Passport passport;



    public Teacher(String name) {
        this.name = name;
    }
}
