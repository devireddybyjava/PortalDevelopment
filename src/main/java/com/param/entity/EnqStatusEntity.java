package com.param.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="AIT_ENQURIRY_STATUS")
public class EnqStatusEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Status_Id;
	private String Status_Name;
}
