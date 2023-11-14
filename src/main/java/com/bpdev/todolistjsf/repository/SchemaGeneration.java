package com.bpdev.todolistjsf.repository;

import java.util.List;

import com.bpdev.todolistjsf.model.Task;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SchemaGeneration {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BPDev");
		
		EntityManager em = emf.createEntityManager();
		
		List<Task> list = em.createQuery("from Task", Task.class).getResultList();
		
		System.out.println(list);
		
		em.close();
		emf.close();
	}
}
