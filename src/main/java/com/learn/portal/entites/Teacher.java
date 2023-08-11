package com.learn.portal.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teachers")
//@NoArgsConstructor
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    private String teacherName;
    private String teacherMobileNumber;
    private Boolean status = false;

    @OneToOne
    @JoinColumn(name = "deptId")
    private Dept dept;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
}
