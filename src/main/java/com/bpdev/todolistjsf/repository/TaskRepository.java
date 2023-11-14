package com.bpdev.todolistjsf.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.bpdev.todolistjsf.model.Task;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class TaskRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public TaskRepository() {
	}

	public TaskRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Task findById(Long id) {
		return manager.find(Task.class, id);
	}

	public List<Task> search(String name) {
		String jpql = "from Task where taskName like :taskName";
		
		TypedQuery<Task> query = manager
				.createQuery(jpql, Task.class);
		
		query.setParameter("taskName", name + "%");
		
		return query.getResultList();
	}
	
	public List<Task> findAll() {
         return manager.createQuery("from Task", Task.class).getResultList();
    }

	public Task save(Task task) {
		return manager.merge(task);
	}

	public void remove(Task task) {
		task = findById(task.getId());
		manager.remove(task);
	}
}
