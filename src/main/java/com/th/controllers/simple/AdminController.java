package com.th.controllers.simple;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.th.entities.Admin;
import com.th.entities.Role;
import com.th.service.AccountServiceImpl;

@Controller
public class AdminController {

	@Autowired
	AccountServiceImpl accountServiceImpl;
	@GetMapping("/admin")
	public String myAdminPage(Model m)
	{
		List<Admin> admins=accountServiceImpl.findAdmins();
		Admin admin=new Admin();
		List<Role> roles=accountServiceImpl.findRoles();
		m.addAttribute("admins", admins);
		m.addAttribute("admin",admin);
		m.addAttribute("roles",roles);
		return "adminmanage";
		
	}
	@PostMapping("add")
	public String addAdmin(@Valid Admin admin,@RequestParam String role)
	{
		accountServiceImpl.saveUser(admin);
		accountServiceImpl.addRoleToUser(admin.getEmail(), role);
		
		
		
		return "redirect:/admin";
		
		
	}
	
	
	
	
}
