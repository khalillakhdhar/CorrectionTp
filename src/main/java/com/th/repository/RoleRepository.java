package com.th.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.th.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
Role findByRoleName(String roleName);
}
