package com.othmen.meubles.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.othmen.meubles.entities.type;
import com.othmen.meubles.entities.meuble;
@Repository
public interface meubleRepository extends JpaRepository<meuble, Long> {
	List<meuble> findByNommeuble(String nom);
	 List<meuble> findByNommeubleContains(String nom);
	 @Query("select p from meuble p where p.nommeuble like %:nom and p.prixmeuble > :prix")
	 List<meuble> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select p from meuble p where p.type = ?1")
	 List<meuble> findBytype (type type);
	 List<meuble> findBytypeIdtype(Long id);
	 List<meuble> findByOrderByNommeubleAsc();
	 @Query("select p from meuble p order by p.nommeuble ASC, p.prixmeuble DESC")
	 List<meuble> triermeublesNomsPrix();
	
}