package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.out;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save (Task task);
    Optional<Task>findById(Long id);
    List<Task> findAll ();
    Optional<Task> update(Task task);
    boolean deletebyId (Long id);
}
