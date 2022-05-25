package com.othmen.meubles.service;

import java.util.List;

import com.othmen.meubles.entities.type;


public interface typeService {

    List <type> findAll();
    
    type savetype(type c);
    type updatetype(type c);
    void deletetype(type c);
     void deletetypeById(Long id);
     type gettype (Long idCat);

}