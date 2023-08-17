package com.learn.portal.dto;

import com.learn.portal.entites.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FeedBackDto {
	private int feedbackId;
	private User feedBackFor;
	private String subject;
	private String parameter1;
	private String parameter2;
	private String parameter3;
	private String parameter4;
	private String parameter5;
	private String message;

}
