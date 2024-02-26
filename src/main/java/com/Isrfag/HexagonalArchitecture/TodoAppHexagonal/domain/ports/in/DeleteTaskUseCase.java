package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.in;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.Task;

public interface DeleteTaskUseCase {

    boolean deleteTask (Long id);
}
