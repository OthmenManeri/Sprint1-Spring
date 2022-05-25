package com.othmen.meubles.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nommeubl", types = { meuble.class })
public interface meubleProjection {
public String getNommeuble();
}