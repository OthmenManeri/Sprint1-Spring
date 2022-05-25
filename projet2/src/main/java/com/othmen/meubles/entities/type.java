package com.othmen.meubles.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Entity
public class type {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idtype;
private String nomtype;
private String descriptiontype;
@JsonIgnore
@OneToMany(mappedBy = "type")
private List<meuble> produits;
public type() {}
public type(String nomtype, String descriptiontype, List<meuble> produits) 
{
super();
this.nomtype = nomtype;
this.descriptiontype = descriptiontype;
this.produits = produits;
}
public Long getIdtype() {
return idtype;
}
public void setIdtype(Long idtype) {
this.idtype = idtype;
}
public String getNomtype() {
return nomtype;
}
public void setNomtype(String nomtype) {
this.nomtype = nomtype;
}
public String getDescriptiontype() {
return descriptiontype;
}
public void setDescriptiontype(String descriptiontype) {
this.descriptiontype = descriptiontype;
}
public List<meuble> getProduits() {
return produits;
}
public void setProduits(List<meuble> produits) {
this.produits = produits;
}
@Override
public String toString() {
	return "type [idtype=" + idtype + ", nomtype=" + nomtype + ", descriptiontype=" + descriptiontype + "]";
}
}