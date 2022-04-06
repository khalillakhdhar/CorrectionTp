package com.th.service;

import java.util.List;

import com.th.entities.Sortie;

public interface SortieInt {
	public Sortie addOne(Sortie sortie);
	public void assignResponsable(String nomcomplet, Sortie sortie);
	public void deleteOne(long id);
	public List<Sortie> getAll();
}
