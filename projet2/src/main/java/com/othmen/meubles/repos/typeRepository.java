package com.othmen.meubles.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.othmen.meubles.entities.type;


@Repository
public interface typeRepository extends JpaRepository<type, Long>{

}