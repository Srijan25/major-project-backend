package com.learn.portal.entites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
	private User feedBackFor;

	@Column(name = "subject")
	private String subject;

	@Column(name = "Parameter1")
	private String parameter1;

	@Column(name = "Parameter2")
	private String parameter2;

	@Column(name = "Parameter3")
	private String parameter3;

	@Column(name = "Parameter4")
	private String parameter4;

	@Column(name = "Parameter5")
	private String parameter5;

	@Column(name = "message")
	private String message;

}
