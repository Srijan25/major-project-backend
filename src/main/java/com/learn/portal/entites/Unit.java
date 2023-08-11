package com.learn.portal.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "units")
//@NoArgsConstructor
@Getter
@Setter
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unitId;
    private String unitName;
    private List<String> Notes;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;
}
