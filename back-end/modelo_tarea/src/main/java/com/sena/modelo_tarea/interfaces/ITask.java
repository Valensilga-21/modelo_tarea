package com.sena.modelo_tarea.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.modelo_tarea.models.task;
@Repository
public interface ITask extends CrudRepository<task, Integer>{

}
