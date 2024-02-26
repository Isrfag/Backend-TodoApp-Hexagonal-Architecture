package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.application.usecases;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.Task;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.in.CreateTaskUseCase;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImp implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImp (TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort=taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {

        return taskRepositoryPort.save(task);

    }
}
