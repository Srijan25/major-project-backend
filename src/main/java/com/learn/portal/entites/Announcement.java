package com.learn.portal.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "announcement")
@Getter
@Setter
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int announcementId;

    @Column(name = "Title", nullable = false, length = 50)
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name="Date")
    private String date;
}
