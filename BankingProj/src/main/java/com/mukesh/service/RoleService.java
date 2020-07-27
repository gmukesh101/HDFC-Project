package com.mukesh.service;

import com.mukesh.domain.entity.Role;

public interface RoleService {

    Role findByRoleName(String roleName);
}
