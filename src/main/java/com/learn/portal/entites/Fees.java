package com.learn.portal.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fees")
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
