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

    private String Name;

    private String mobileNumber;

    private String emailId;

    @OneToOne
    @JoinColumn(name = "deptId")
    private Dept dept;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;




}
