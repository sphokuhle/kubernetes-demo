package com.example.kubernetesproject.controller;


import com.example.kubernetesproject.dto.StudentDto;
import com.example.kubernetesproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/")
@PreAuthorize("hasAuthority('admin_authorization')")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('admin_authorization')")
    public void register(@RequestHeader("Authorization") String token, @RequestBody StudentDto student) throws Exception {
        adminService.registerUser(token, student);
    }
}
