package com.learn.portal.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "units")
@Getter
@Setter
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unitId;

    @Column(name = "unit_number", nullable = false, length = 50)
    private int unitNumber;
    
    @Column(name = "unit_name", nullable = false, length = 50)
    private String unitName;
    
    @Column(name = "unit_desc", nullable = false, length = 500)
    private String unitDesc;
    
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
