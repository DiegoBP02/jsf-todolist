package com.bpdev.todolistjsf.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.bpdev.todolistjsf.model.Task;
import com.bpdev.todolistjsf.repository.TaskRepository;
import com.bpdev.todolistjsf.util.Transactional;

public class TaskService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TaskRepository taskRepository;
	
	@Transactional
	public void save(Task task) {
		taskRepository.save(task);
	}
	
	@Transactional
	public void remove(Task task) {
		taskRepository.remove(task);
	}

}
