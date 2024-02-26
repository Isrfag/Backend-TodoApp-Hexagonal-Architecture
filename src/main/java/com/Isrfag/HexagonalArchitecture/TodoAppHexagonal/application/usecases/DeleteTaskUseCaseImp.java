package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.application.usecases;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.Task;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.in.DeleteTaskUseCase;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.out.TaskRepositoryPort;

public class DeleteTaskUseCaseImp implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public DeleteTaskUseCaseImp (TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort= taskRepositoryPort;
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskRepositoryPort.deletebyId(id);
    }
}
