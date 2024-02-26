package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.application.usecases;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.AdditionalTaskInfo;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.out.ExternalServicePort;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.out.TaskRepositoryPort;

public class GetAdditionalTaskInfoUseCaseImp implements GetAdditionalTaskInfoUseCase {
    private final ExternalServicePort externalServicePort;
    public GetAdditionalTaskInfoUseCaseImp (ExternalServicePort externalServicePort)  {
        this.externalServicePort=externalServicePort;
    }
    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {

        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
