package com.learn.portal.entites;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Dept {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;

	@Column(name = "dept_name", nullable = false, length = 50)
	private String deptName;

	@OneToMany(mappedBy = "dept")
	private List<Teacher> teachers;

	@OneToMany(mappedBy = "dept")
	private List<Student> students;
	
	@OneToOne(mappedBy = "dept")
	private Hod hod;

}
