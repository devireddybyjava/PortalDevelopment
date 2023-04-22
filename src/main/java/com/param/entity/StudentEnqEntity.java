package com.param.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
@Table(name="AIT_STUDENT_ENQURIES")
public class StudentEnqEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Enquiry_ID;
    private String Student_Name;
    private Long Phno;
    private String Class_Mode;
@CreationTimestamp
	private LocalDateTime createDate;

	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserDtlsEntity user;

}
