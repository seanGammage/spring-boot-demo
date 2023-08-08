package com.springbootexample.demo.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired // This annotation is used to Inject the TaskRepository into the TaskController within the Spring Context
    private TaskRepository repository;

    // CRUD

    // Create
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return repository.save(task);
    }

    // Read
    @GetMapping
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // Read
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return repository.findById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskData) {
        // findById(id) = SELECT * FROM Task WHERE ID = whatever the path variable is
        Optional<Task> existingTask = repository.findById(id);

        if(existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setTitle(taskData.getTitle());
            task.setDescription(taskData.getDescription());
            task.setComplete(taskData.isComplete());
            return repository.save(task);
        } else {
            throw new ResourceAccessException("Task not found with id: " + id);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
