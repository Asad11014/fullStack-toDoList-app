package com.toDo.service;

import com.toDo.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id) throws Exception;
    Task createTask(Task task);
    Task updateTask(Long id, Task task) throws Exception;
    void deleteTask(Long id);

    Task updateStatus(Long id) throws Exception;
}
