package com.learn.portal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitDto {

	private int unitId;
	private String unitName;
	private String unitDesc;
	private SubjectDto subject;

}
