package com.sena.modelo_tarea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.modelo_tarea.interfaces.ITask;
import com.sena.modelo_tarea.models.task;
import com.sena.modelo_tarea.service.emailService;

@RequestMapping("/api/v1/")
@RestController
public class taskController {

    @Autowired
    private ITask taskService;

    @Autowired
    private emailService emailService;
	
	@PostMapping("/tasks")
    public ResponseEntity<Object> save(@RequestBody task task) {


        if (task.getTitle().equals("")) {
            
            return new ResponseEntity<>("El texto es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (task.getDue_date().equals("")) {
            
            return new ResponseEntity<>("La fecha limite es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (task.getAssigned_to().equals("")) {
            return new ResponseEntity<>("Este es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (task.getStatus().equals("")) {
            
            return new ResponseEntity<>("El estado es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        taskService.save(task);
        emailService.enviarAsignacionTarea(task.getAssigned_to());
        return new ResponseEntity<>(task, HttpStatus.OK);

    }
	
	@GetMapping("/tasks")
	public ResponseEntity<Object> findAll(){
		var ListaTask=taskService.findAll();
		return new ResponseEntity<>(ListaTask,HttpStatus.OK);
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Object> findOne(@PathVariable Integer id){
		var task=taskService.findById(id);
		return new ResponseEntity<>(task,HttpStatus.OK);
	}
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Object> delete(@PathVariable task id){
		taskService.delete(id);
		return new ResponseEntity<>("Tarea eliminada con exito",HttpStatus.OK);
	}
	
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody task taskUpdate){
		var task=taskService.findById(id).get();
		if (task != null) {
			task.setTitle(taskUpdate.getTitle());
			task.setDue_date(taskUpdate.getDue_date());
			task.setAssigned_to(taskUpdate.getAssigned_to());
			task.setStatus(taskUpdate.getStatus());

			taskService.save(task);
			return new ResponseEntity<>(task,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>("Error, tarea no encontrada",HttpStatus.BAD_REQUEST);
		}
	}
}
