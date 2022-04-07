package com.th.controllers.simple;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.th.entities.Admin;
import com.th.entities.Sortie;
import com.th.service.AccountServiceImpl;
import com.th.service.SortieService;

@Controller
public class SortieSimpleController {
@Autowired
AccountServiceImpl apiadmin;
@Autowired 
SortieService sortieService;

@GetMapping("sortie")
public String getSorties(Model m)
{
Sortie sortie=new Sortie();
List<Admin> admins=apiadmin.findAdmins();
m.addAttribute("admins", admins);
m.addAttribute("sortie",sortie);
String nom="";
m.addAttribute("nom",nom);
return "sortie";
}
@PostMapping("sortie")
public String addSortie(@Valid Sortie sortie,@RequestParam String nom)
{
	System.out.println("le nom est: "+nom);
	Admin ad=apiadmin.findbynom(nom);
	sortie.setAdmin(ad);
	
sortieService.addOne(sortie);
//System.out.println("responsable"+responsable.toString());

return "redirect:/sortie";

}
	
	
}
