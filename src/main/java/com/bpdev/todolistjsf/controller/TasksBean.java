package com.bpdev.todolistjsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bpdev.todolistjsf.model.Task;
import com.bpdev.todolistjsf.model.Urgency;
import com.bpdev.todolistjsf.repository.TaskRepository;
import com.bpdev.todolistjsf.services.TaskService;
import com.bpdev.todolistjsf.util.FacesMessages;

@Named
@ViewScoped
public class TasksBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TaskRepository taskRepository;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private TaskService taskService;
	
	private List<Task> taskList;
	
	private Task task;
	
	private String searchTerm;
	
	public void prepareNewTask() {
		task = new Task();
	}
	
	public void save() {
		taskService.save(task);
		
		updateRecords();
		
		messages.info("Task saved successfully!");
		
		prepareNewTask();
	}
	
	public void allTasks() {
		taskList = taskRepository.findAll();
	}
	
	public void search() {
		taskList = taskRepository.search(searchTerm);

		if (taskList.isEmpty()) {
			messages.info("Your query did not return records.");
		}
	}
	
	private void updateRecords() {
		if(alreadySearched()) {
			search();
		} else {
			allTasks();
		}
	}
	
	private boolean alreadySearched() {
		return searchTerm != null && !"".equals(searchTerm);
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public Task getTask() {
		return task;
	}
	
	public Urgency[] getUrgencyList() {
		return Urgency.values();
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	
	
}
