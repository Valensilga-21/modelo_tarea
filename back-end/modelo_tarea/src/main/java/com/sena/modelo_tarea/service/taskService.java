package com.sena.modelo_tarea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sena.modelo_tarea.IService.ITaskService;
import com.sena.modelo_tarea.interfaces.ITask;
import com.sena.modelo_tarea.models.task;

public class taskService implements ITaskService{
    
    @Autowired
	private ITask data;
	
	@Override
	public Integer save(task task) {
		data.save(task);
		return task.getId();
	}


	@Override
	public List<task> findAll() {
		List<task> ListaTask=
		(List<task>) data.findAll();
		return ListaTask;
	}

	@Override
	public Optional<task> findOne(Integer id) {
		Optional<task> task=data.findById(id);
		return task;
	}


	@Override
	public int delete(Integer id) {
	    try {
	        data.deleteById(id);
	        return 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
}
