package com.learn.portal.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subjects")
//@NoArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;
    private String subjectName;
    private String subjectCode;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @OneToMany(mappedBy = "subject")
    private java.util.List<Unit> units;


}
