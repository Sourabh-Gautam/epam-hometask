package com.epam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student", uniqueConstraints = @UniqueConstraint(columnNames = "email_address", name = "email_address_unique"))
public class Student {

	@Id
	@SequenceGenerator(name = "student_seq", sequenceName = "student_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	private Long studentId;
	private String firstName;
	private String lastName;

	@Column(name = "email_address", nullable = false)
	private String emailId;
	private String gaurdianName;
	private String gaurdianEmail;
	private String gaurdianMobile;

}
