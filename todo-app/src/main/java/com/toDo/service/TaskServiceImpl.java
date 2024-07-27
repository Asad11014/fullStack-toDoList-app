package com.toDo.service;

import com.toDo.model.Task;
import com.toDo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) throws Exception {
        return taskRepository.findById(id)
                .orElseThrow(() -> new Exception("Task not found with id " + id));
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) throws Exception {
        Task existingTask = getTaskById(id);
        existingTask.setTitle(task.getTitle());

        existingTask.setCompleted(task.isCompleted());
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateStatus(Long id) throws Exception {
        Task existingTask = getTaskById(id);
        existingTask.setCompleted(!existingTask.isCompleted());
        return taskRepository.save(existingTask);
    }
}
