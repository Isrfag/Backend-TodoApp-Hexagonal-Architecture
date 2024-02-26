package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.out;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {

    AdditionalTaskInfo getAdditionalTaskInfo (Long taskId);
}
