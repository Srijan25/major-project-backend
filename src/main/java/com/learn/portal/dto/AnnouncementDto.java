package com.learn.portal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnouncementDto {
    private int announcementId;
    private String title;
    private String description;
    private String date;
}
