package com.toDo.controllers;

import com.toDo.model.ApiResponse;
import com.toDo.model.Task;
import com.toDo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) throws Exception {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) throws Exception {
        return taskService.updateTask(id, task);
    }



    @DeleteMapping("/{id}")
    public ApiResponse deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        ApiResponse res=new ApiResponse();
        res.setMessage("Task deleted successfully");
        res.setStatus(true);
        return res;
    }
}
