package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.infrastructure.entities;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Sequence e identity hacen lo mismo
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;

    public TaskEntity () {
    }
    public TaskEntity (Long id, String title, String description, LocalDateTime creationDate, boolean completed) {
        this.id=id;
        this.title=title;
        this.description=description;
        this.creationDate=creationDate;
        this.completed=completed;
    }
    public static TaskEntity fromDomainModel (Task task) {

        return new TaskEntity(task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.isCompleted());
    } //Esto es una manera de crear una entidad usando el modelo

    //Lo mismo pero al reves de entity a domain
    public Task toDomainModel () {
        return new Task (id,title,description,creationDate,completed);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
