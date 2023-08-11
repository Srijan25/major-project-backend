package com.learn.portal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class NewsDto {
    private int newsId;
    private String newsTitle;
    private String newsDescription;
    private Date newsDate;

}
