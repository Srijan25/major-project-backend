package com.learn.portal.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
//@NoArgsConstructor
@Getter
@Setter
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int studentId;

        private int sid;

        private String studentName;


        private Boolean status;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "semesterId")
        private Semester semester;

        @OneToOne
        @JoinColumn(name = "userId")
        private User user;

}
