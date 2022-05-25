package com.othmen.meubles.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class meuble {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idmeuble;

@NotNull
@Size (min = 4,max = 15)
private String nommeuble;

public type gettype() {
	return type;
}
public void settype(type type) {
	this.type = type;
}
@Min(value = 10)
@Max(value = 10000)
private Double prixmeuble;



@ManyToOne
private type type;
public meuble() {
super();
}
public meuble(String nommeuble, Double prixmeuble) {
super();
this.nommeuble = nommeuble;
this.prixmeuble = prixmeuble;
}
public Long getIdmeuble() {
return idmeuble;
}
public void setIdmeuble(Long idmeuble) {
this.idmeuble = idmeuble;
}
public String getNommeuble() {
return nommeuble;
}
public void setNommeuble(String nommeuble) {
this.nommeuble = nommeuble;
}
public Double getPrixmeuble() {
return prixmeuble;
}
public void setPrixmeuble(Double prixmeuble) {
this.prixmeuble = prixmeuble;
}

@Override
public String toString() {
	return "meuble [idmeuble=" + idmeuble + ", nommeuble=" + nommeuble + ", prixmeuble=" + prixmeuble
			 + ", type=" + type + "]";
}
}
