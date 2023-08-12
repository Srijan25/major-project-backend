package com.learn.portal.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hods")
//@NoArgsConstructor
@Getter
@Setter
public class Hod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hodId;

    @Column(name = "hod_name", nullable = false, length = 50)
    private String hodName;

    @OneToOne
    @JoinColumn(name = "deptId")
    private Dept dept;

}
