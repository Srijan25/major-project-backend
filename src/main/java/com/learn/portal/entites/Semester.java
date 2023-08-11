package com.learn.portal.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "semesters")
//@NoArgsConstructor
@Getter
@Setter
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int semesterId;
    private int semesterNumber;
    @ManyToOne
    @JoinColumn(name = "deptId")
    private Dept dept;
    @OneToMany(mappedBy = "semester")
    private List<Subject> subjects;
    @OneToMany(mappedBy = "semester")
    private List<Student> students;
}
