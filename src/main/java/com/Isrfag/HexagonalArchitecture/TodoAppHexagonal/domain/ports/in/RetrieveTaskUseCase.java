package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.in;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {

    Optional<Task> getTask (Long id);
    List<Task> getAllTasks();
}
