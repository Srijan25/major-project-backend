package com.learn.portal.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitDto {

	private int unitId;
	private int unitNumber;
	private String unitName;
	private String unitDesc;
	private List<String> notes;
	// private SubjectDto subject;

}
