package com.th.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.th.entities.Admin;
import com.th.entities.Sortie;
import com.th.repository.AdminRepository;
import com.th.repository.ParticipantRepository;
import com.th.repository.SortieRepository;

@Service
public class SortieService implements SortieInt {
@Autowired
SortieRepository sortieRepository;
@Autowired
AdminRepository adminRepository;

public Sortie addOne(Sortie sortie)
{
return sortieRepository.save(sortie);	
}
public void assignResponsable(String nomcomplet, Sortie sortie)
{
	Admin admin=adminRepository.findByNomcomplet(nomcomplet);
	sortie.setAdmin(admin);
	addOne(sortie);
	
	
}
@Override
public void deleteOne(long id) {
	// TODO Auto-generated method stub
	sortieRepository.deleteById(id);
	
}
@Override
public List<Sortie> getAll() {
	// TODO Auto-generated method stub
	return sortieRepository.findAll();
}




}
