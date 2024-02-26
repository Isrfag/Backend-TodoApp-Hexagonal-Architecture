package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.infrastructure.config;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.application.services.TaskService;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.application.usecases.*;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.in.DeleteTaskUseCase;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.out.ExternalServicePort;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.out.TaskRepositoryPort;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.infrastructure.adapters.ExternalServiceAdapter;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImp(taskRepositoryPort),
                new RetrieveTaskUseCaseImp(taskRepositoryPort),
                getAdditionalTaskInfoUseCase,
                new DeleteTaskUseCaseImp(taskRepositoryPort),
                new UpdateTaskUseCaseImp(taskRepositoryPort)

        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort (JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase (ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImp(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort () {
        return new ExternalServiceAdapter();
    }
}
