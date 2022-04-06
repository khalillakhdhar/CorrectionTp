package com.th.service;
import java.util.List;

import com.th.entities.Admin;
import com.th.entities.Role;

public interface AccountService {
	public Admin saveUser(Admin admin);
	public Role saveRole(Role role);
	public void addRoleToUser(String email, String roleName);
	public Admin findAdminByEmail(String email);
	
	public List<Admin> findAdmins();
	public List<Role> findRoles();
	
}
