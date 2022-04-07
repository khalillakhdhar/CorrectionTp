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
List<Admin> admins=apiadmin.findAdmins(); // récupération de la liste des admins
m.addAttribute("admins", admins); // ajout de liste
m.addAttribute("sortie",sortie); // ajout d'instance
String nom=""; // initialisation de nomcomplet d'admin
m.addAttribute("nom",nom);
return "sortie";
}
@PostMapping("sortie")
public String addSortie(@Valid Sortie sortie,@RequestParam String nom)
{
	// @RequestParam nom récupére le nom complet envoyé depuis le menu déroulant
	Admin ad=apiadmin.findbynom(nom); // recherche d'admin
	sortie.setAdmin(ad); // association de admin=> sortie
	
sortieService.addOne(sortie); // ajout de sortie avec responsable
//System.out.println("responsable"+responsable.toString());

return "redirect:/sortie";

}
	
	
}
