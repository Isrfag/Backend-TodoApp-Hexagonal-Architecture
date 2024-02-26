package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.infrastructure.repositories;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.Task;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskRepository extends JpaRepository <TaskEntity, Long> {


}
