package com.othmen.meubles.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.othmen.meubles.entities.type;
import com.othmen.meubles.repos.typeRepository;


@Service
public class typeServiceImpl implements typeService {

    @Autowired
    private typeRepository catRepository;

    @Override
    public List <type> findAll() {
        return catRepository.findAll();
    }

	@Override
	public type savetype(type c) {
		return catRepository.save(c);
	}

	@Override
	public type updatetype(type c) {
		return catRepository.save(c);
	}

	@Override
	public void deletetype(type c) {
		catRepository.delete(c);
	}

	@Override
	public void deletetypeById(Long idCat) {
		catRepository.deleteById(idCat);
	}

	@Override
	public type gettype(Long idCat) {
		return catRepository.findById(idCat).get();
	}

   
}