package com.learn.portal.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EventsDto {
    private int eventsId;
    private String eventsTitle;
    private String eventsDescription;
    private Date eventsDate;
    private String eventImage;

}
