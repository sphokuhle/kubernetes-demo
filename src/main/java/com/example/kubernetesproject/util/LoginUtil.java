package com.example.kubernetesproject.util;

import com.example.kubernetesproject.dto.authorization.AuthRequestDto;
import com.example.kubernetesproject.dto.authorization.KeycloakCredentialsDto;
import com.example.kubernetesproject.service.KeycloakKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginUtil {

    @Autowired
    private KeycloakKeyService keycloakKeyService;

    @Value("${app.sso.auth-url}")
    private String KEYCLOAK_URL;

    @Value("${keycloak.realm}")
    private String REALM;

    @Value("${keycloak.resource}")
    private String CLIENT_ID;

//    @Value("${keycloak.credentials.secret}")
//    private String SECRET;

    private final static String GRANT_TYPE = "password";

    public ResponseEntity<Map<String, Object>> login(AuthRequestDto authRequest) {

        KeycloakCredentialsDto keycloakCredentialsDto = new KeycloakCredentialsDto();
        keycloakCredentialsDto.setUsername(authRequest.getUsername());
        keycloakCredentialsDto.setPassword(authRequest.getPassword());
        keycloakCredentialsDto.setClientId(CLIENT_ID);
        keycloakCredentialsDto.setGrantType(GRANT_TYPE);
        keycloakCredentialsDto.setClientSecret(keycloakKeyService.getPublicKeys().get("secret"));

        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getMessageConverters().add(new ObjectToUrlEncodedConverter(new ObjectMapper()));
        HttpHeaders headers = new HttpHeaders();
        Map<String, Object> map = new HashMap<>();
        Class<Map<String, Object>> clazz = (Class<Map<String, Object>>)map.getClass();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(MediaType.parseMediaTypes(MediaType.APPLICATION_JSON_VALUE));

        HttpEntity<KeycloakCredentialsDto> entity = new HttpEntity<>(keycloakCredentialsDto, headers);
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(KEYCLOAK_URL, HttpMethod.POST, entity, clazz);
        return response;
    }
}
