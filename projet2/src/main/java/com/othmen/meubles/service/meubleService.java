package com.othmen.meubles.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.othmen.meubles.entities.type;
import com.othmen.meubles.entities.meuble;
public interface meubleService {
meuble savemeuble(meuble p);
meuble updatemeuble(meuble p);
void deletemeuble(meuble p);
 void deletemeubleById(Long id);
meuble getmeuble(Long id);
List<meuble> getAllmeubles();
Page<meuble> getAllmeublesParPage(int page, int size);
List<meuble> findByNommeuble(String nom);
List<meuble> findByNommeubleContains(String nom);
List<meuble> findByNomPrix (String nom, Double prix);
List<meuble> findBytype (type type);
List<meuble> findBytypeIdtype(Long id);
List<meuble> findByOrderByNommeubleAsc();
List<meuble> triermeublesNomsPrix();
}