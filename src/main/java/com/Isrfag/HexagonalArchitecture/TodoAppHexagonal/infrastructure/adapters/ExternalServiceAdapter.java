package com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.infrastructure.adapters;

import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.models.AdditionalTaskInfo;
import com.Isrfag.HexagonalArchitecture.TodoAppHexagonal.domain.ports.out.ExternalServicePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    @Value("${spring.external.service.base-url}")
    private String basePathUrl;

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter () {
        restTemplate = new RestTemplate();
    }
    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {

        String apiUrl = basePathUrl + "/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(apiUrl,JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();
        if(todo==null) {
            return null;
        }
        String apiUrl2 = basePathUrl + "/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> responseUser = restTemplate.getForEntity(apiUrl2, JsonPlaceHolderUser.class);
        System.out.println(responseUser);
        JsonPlaceHolderUser user = responseUser.getBody();
        if(user==null) {
            return null;
        }
        user.setUserId(todo.getId());
        return new AdditionalTaskInfo(user.getUserId(), user.getName(), user.getEmail());

    }
    private static class JsonPlaceHolderTodo {
        private Long id;
        private Long userId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    private static class JsonPlaceHolderUser {
        private Long userId;
        private String name;
        private String email;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
