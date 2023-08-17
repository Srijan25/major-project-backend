package com.learn.portal.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

}
