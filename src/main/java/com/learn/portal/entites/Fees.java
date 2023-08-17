package com.learn.portal.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Fees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feesId;

//    @OneToMany(mappedBy = "fees")
//    @JoinColumn(name = "user_id")
//    private User user ;

}
