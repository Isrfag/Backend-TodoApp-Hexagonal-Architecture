package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.application.usecases;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.Task;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.in.UpdateTaskUseCase;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImp implements UpdateTaskUseCase {

    TaskRepositoryPort taskRepositoryPort;

    public  UpdateTaskUseCaseImp (TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort=taskRepositoryPort;
    }
    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(updateTask);
    }
}
