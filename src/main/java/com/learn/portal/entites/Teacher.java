package com.learn.portal.entites;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    
    @Column(name = "teacher_name", nullable = false, length = 50)
    private String teacherName;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;
    
}
