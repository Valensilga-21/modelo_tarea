package com.sena.modelo_tarea.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sena.modelo_tarea.service.emailService;
import com.sena.modelo_tarea.service.taskService;

@Component
public class Task {
    @Autowired
    private taskService data;

    @Autowired
    private emailService email;
}
