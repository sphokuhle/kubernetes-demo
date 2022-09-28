package com.example.kubernetesproject.dto;

import com.example.kubernetesproject.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleDto {
    Long roleId;
    private String roleName;

    public RoleDto(Role role) {
        this.roleId = role.getRoleId();
        this.roleName = role.getRoleName();
    }
}
