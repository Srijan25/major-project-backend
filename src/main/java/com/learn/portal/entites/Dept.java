package com.learn.portal.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departments")
//@NoArgsConstructor
@Getter
@Setter
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    private String deptName;
    @OneToMany(mappedBy = "dept")
    private java.util.List<Teacher> teachers;
    @OneToOne(mappedBy = "dept")
    private Hod hod;
    @OneToMany(mappedBy = "dept")
    private java.util.List<Semester> semesters;
}
