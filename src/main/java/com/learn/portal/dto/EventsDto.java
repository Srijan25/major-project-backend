package com.learn.portal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class EventsDto {
    private int eventsId;
    private String eventsTitle;
    private String eventsDescription;
    private Date eventsDate;
    private String eventsPhoto;

}
