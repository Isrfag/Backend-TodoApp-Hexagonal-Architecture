package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.in;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {

    AdditionalTaskInfo getAdditionalTaskInfo (Long id);
}
