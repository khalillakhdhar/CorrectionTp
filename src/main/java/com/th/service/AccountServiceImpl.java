package com.th.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.th.entities.Admin;
import com.th.entities.Role;
import com.th.repository.AdminRepository;
import com.th.repository.RoleRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AdminRepository adminRepository;
	@Autowired 
	RoleRepository roleRepository;
	@Bean
	public BCryptPasswordEncoder getBCPE()
	{
		return new BCryptPasswordEncoder();
		
	}
	
	
	@Override
	public Admin saveUser(Admin admin) {
		// TODO Auto-generated method stub
	//	long idf=adminRepository.findByLast1ById().getId();
		//idf++;
		String hashed=this.getBCPE().encode(admin.getPassword());
		admin.setPassword(hashed);
		return adminRepository.save(admin);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String email, String roleName) {
		// TODO Auto-generated method stub
		Role role=roleRepository.findByRoleName(roleName);
		Admin admin=adminRepository.findByEmail(email);
		admin.getRoles().add(role);

	}

	@Override
	public Admin findAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return adminRepository.findByEmail(email);
	}


	


	@Override
	public List<Admin> findAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}


	@Override
	public List<Role> findRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
