package com.sena.modelo_tarea.IService;

import java.util.List;
import java.util.Optional;

import com.sena.modelo_tarea.models.task;

public interface ITaskService {
    public Integer save(task task);
	public List<task> findAll();
	public Optional<task> findOne(Integer id);
	public int delete(Integer id);
}
