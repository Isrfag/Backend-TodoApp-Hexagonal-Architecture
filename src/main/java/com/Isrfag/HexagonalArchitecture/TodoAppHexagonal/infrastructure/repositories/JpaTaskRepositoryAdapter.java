package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.infrastructure.repositories;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.Task;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.out.TaskRepositoryPort;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository repository;

    public JpaTaskRepositoryAdapter (JpaTaskRepository repository) {
        this.repository=repository;
    }

    @Override
    public Task save(Task task) {
        //Pasamos el task a task entity
        TaskEntity taskEntity= TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = repository.save(taskEntity);
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return  repository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll().stream().map(TaskEntity::toDomainModel).toList();
    }

    @Override
    public Optional<Task> update(Task task) {


        if (repository.existsById(task.getId())) {


             TaskEntity savedTaskEntity = repository.save(TaskEntity.fromDomainModel(task));
             return Optional.of(savedTaskEntity.toDomainModel());

        }else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deletebyId(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }else {return false;}

    }
}
