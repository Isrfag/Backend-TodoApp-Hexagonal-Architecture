package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.application.services;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.AdditionalTaskInfo;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.Task;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.in.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TaskService implements CreateTaskUseCase,
        DeleteTaskUseCase,
        GetAdditionalTaskInfoUseCase,
        RetrieveTaskUseCase,
        UpdateTaskUseCase {


    private final CreateTaskUseCase createTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;

    public TaskService(CreateTaskUseCase createTaskUseCase,
                       RetrieveTaskUseCase retrieveTaskUseCase,
                       GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase,
                       DeleteTaskUseCase deleteTaskUseCase,
                       UpdateTaskUseCase updateTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase=retrieveTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
        this.deleteTaskUseCase=deleteTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
    }

    @Override
    public Task createTask(Task task) {

        task.setCreationDate(LocalDateTime.now());
        return createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {

        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return updateTaskUseCase.updateTask(id,updateTask);
    }
}
