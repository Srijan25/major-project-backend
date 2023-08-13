package com.learn.portal.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int studentId;

        @Column(name = "student_roll", nullable = false, length = 50)
        private int studentRoll;

        @Column(name = "student_name", nullable = false, length = 50)
        private String studentName;

        @Column(name = "semester", nullable = false, length = 10)
        private int semester;

        @OneToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "dept_id")
        private Dept dept;
}
