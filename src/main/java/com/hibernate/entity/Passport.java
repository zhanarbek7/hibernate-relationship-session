package com.hibernate.entity;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;
    private LocalDate issued;
    private LocalDate expiresAt;

    @OneToOne()
    @JoinColumn(name = "teacher")
    private Teacher teacher_id;

    public Passport(String passportNumber, LocalDate issued, Teacher teacher) {
        this.passportNumber = passportNumber;
        this.issued = issued;
        this.expiresAt = issued.plusYears(10);
        this.teacher_id = teacher;
    }

    public Passport(String passportNumber, LocalDate issued) {
        this.passportNumber = passportNumber;
        this.issued = issued;
        this.expiresAt = issued.plusYears(10);
    }
}
