package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.infrastructure.controllers;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.application.services.TaskService;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.AdditionalTaskInfo;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTaks = taskService.createTask(task);
        return new ResponseEntity<>(createdTaks, HttpStatus.CREATED);

    }
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById (@PathVariable Long taskId) {

        return taskService.getTask(taskId).map(task -> new ResponseEntity<>(task,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); //or else es pq es optional

    }
    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks () {
        return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
    }
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask (@PathVariable("taskId") Long taskId, @RequestBody Task taskToUpdate ) {

        taskToUpdate.setId(taskId);

        return taskService.updateTask(taskId,taskToUpdate).map(task -> new ResponseEntity<>(task,HttpStatus.ACCEPTED))
                        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask (@PathVariable("taskId") Long taskId) {

        if (taskService.deleteTask(taskId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{taskId}/additionalInfo")
    public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInfo (@PathVariable Long taskId) {
        return new ResponseEntity<>(taskService.getAdditionalTaskInfo(taskId),HttpStatus.OK);
    }
}
