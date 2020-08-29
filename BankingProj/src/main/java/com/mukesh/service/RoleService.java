package com.mukesh.service;

import com.mukesh.domain.entity.Role;

/**
 * @author mukesh
 *
 */
public interface RoleService {

    Role findByRoleName(String roleName);
}
