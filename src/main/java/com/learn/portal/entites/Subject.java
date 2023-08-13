package com.learn.portal.entites;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subjects")
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;
    
    @Column(name = "subject_name", nullable = false, length = 50)
    private String subjectName;
    
    @Column(name = "subject_code", nullable = false, length = 50)
    private String subjectCode;
    
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Unit> units;

    @Column(name = "semester", nullable = false, length = 50)
    private Integer semester;
    
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    

}
