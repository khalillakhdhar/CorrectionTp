package com.th.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.th.entities.Sortie;
import com.th.service.SortieService;

@RestController
@RequestMapping("api/")
public class SortieController {
@Autowired
SortieService sortieService;
	@PostMapping("/sortie/{nomcomplet}")
	public void addSortie(@PathVariable String nomcomplet,@RequestBody Sortie sortie)
	{
		
		 sortieService.assignResponsable(nomcomplet, sortie);
	}
	@GetMapping("/sortie")
	public List<Sortie> getAll()
	{
		return sortieService.getAll();
	}
	
}
