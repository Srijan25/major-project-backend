package com.learn.portal.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "feedback")
@Getter
@Setter

public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="subject")
    private String subject;

    @Column(name="Parameter1")
    private String Parameter1;

    @Column(name="Parameter2")
    private String Parameter2;

    @Column(name="Parameter3")
    private String Parameter3;

    @Column(name="Parameter4")
    private String Parameter4;

    @Column(name="Parameter5")
    private String Parameter5;

    @Column(name="message")
    private String message;

}
