package com.bpdev.todolistjsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bpdev.todolistjsf.model.Task;
import com.bpdev.todolistjsf.repository.TaskRepository;

@Named
@ViewScoped
public class TasksBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Task> taskList;
	
	private Task task;
	
	@Inject
	private TaskRepository taskRepository;
	
	public void allTasks() {
		taskList = taskRepository.findAll();
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
	
}
