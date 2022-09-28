package com.example.kubernetesproject.controller;

import com.example.kubernetesproject.dto.authorization.AuthRequestDto;
import com.example.kubernetesproject.exception.LoginFailureHandler;
import com.example.kubernetesproject.repository.GradeRepository;
import com.example.kubernetesproject.util.JwtTokenUtil;
import com.example.kubernetesproject.util.LoginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/public/")
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class.getCanonicalName());

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    LoginUtil loginUtil;

    @Autowired
    GradeRepository gradeRepository;

    @PostMapping("login")
    public ResponseEntity<?> logon(@RequestBody @Valid AuthRequestDto request, HttpServletRequest httpServletRequest) {
        try {
            Map<String, Object> map = new HashMap<>();
            ResponseEntity<Map<String, Object>> response = loginUtil.login(request);
            if(response != null && response.getStatusCode().value() == 200) {
                String token = response.getBody().get("access_token") != null?
                        response.getBody().get("access_token").toString(): null;
                logger.info("token {}", token);
            }
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            LoginFailureHandler loginFailure = new LoginFailureHandler(sdf.format(new Date()), HttpStatus.UNAUTHORIZED.value(),
                    ex.getMessage(), httpServletRequest.getRequestURI());
            return new ResponseEntity<>(loginFailure, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("roles")
    private ResponseEntity<?> getGrantedRoles(@RequestHeader("Authorization") String token, HttpServletRequest httpServletRequest) {
        try {
            logger.info("method: roles, token {}", token);
            return new ResponseEntity<>(jwtTokenUtil.getGrantedAuthorities(token.replaceFirst("Bearer ","")),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            LoginFailureHandler loginFailure = new LoginFailureHandler(sdf.format(new Date()), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(), httpServletRequest.getRequestURI());
            return new ResponseEntity<>(loginFailure, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("all")
    private ResponseEntity<?> testPublicEndpoints() {
        try {
            logger.info("testing public endpoints...");
            return new ResponseEntity<>(gradeRepository.getAllGrades(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            LoginFailureHandler loginFailure = new LoginFailureHandler(sdf.format(new Date()), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage(), "Student_Portal/api/v1/public/all");
            return new ResponseEntity<>(loginFailure, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
