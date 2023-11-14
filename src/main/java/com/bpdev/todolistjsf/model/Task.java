package com.bpdev.todolistjsf.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task implements Serializable{

	private static final long serialVersionUID = 1541259616632441601L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "task_name", nullable = false, length = 80)
	private String taskName;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Urgency urgency;
}
