package com.othmen.meubles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.othmen.meubles.entities.meuble;
import com.othmen.meubles.entities.type;
import com.othmen.meubles.repos.meubleRepository;

@Service
public class meubleServiceImpl implements meubleService {
@Autowired
meubleRepository meubleRepository;
@Override
public meuble savemeuble(meuble p) {
	return meubleRepository.save(p);
	}
	@Override
	public meuble updatemeuble(meuble p) {
	return meubleRepository.save(p);
	}
	@Override
	public void deletemeuble(meuble p) {
	meubleRepository.delete(p);
	}
	 @Override
	public void deletemeubleById(Long id) {
	meubleRepository.deleteById(id);
	}
	@Override
	public meuble getmeuble(Long id) {
	return meubleRepository.findById(id).get();
	}
	@Override
	public List<meuble> getAllmeubles() {
	return meubleRepository.findAll();
	}
	@Override
	public Page<meuble> getAllmeublesParPage(int page, int size) {
		return meubleRepository.findAll(PageRequest.of(page, size));

	}
	@Override
	public List<meuble> findByNommeuble(String nom) {
	return meubleRepository.findByNommeuble(nom);
	}
	@Override
	public List<meuble> findByNommeubleContains(String nom) {
	return meubleRepository.findByNommeuble(nom);
	}
	@Override
	public List<meuble> findByNomPrix(String nom, Double prix) {
		return meubleRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<meuble> findBytype(type type) {
	return meubleRepository.findBytype(type);
	}
	@Override
	public List<meuble> findBytypeIdtype(Long id) {
	return meubleRepository.findBytypeIdtype(id);
	}
	@Override
	public List<meuble> findByOrderByNommeubleAsc() {
	return meubleRepository.findByOrderByNommeubleAsc();
	}
	@Override
	public List<meuble> triermeublesNomsPrix() {
	return meubleRepository.triermeublesNomsPrix();
	}
}