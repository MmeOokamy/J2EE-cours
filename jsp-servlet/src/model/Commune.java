package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="communes")
public class Commune {
	
	@Id
	@Column(name="no_commune")
	private String noCommune;
	
	@Column(name="no_dept", length = 3)
	private String noDept;
	
	@Column(name="nom", length = 50)
	private String nom;
	
	@Column(name="nom_std", length = 50)
	private String nomStd;
	
	@Column(name="type_chef_lieu", length = 1)
	private String typeChefLieu;
	
	@Column(name="type_commune", length = 30)
	private String typeCommune;

	
	
	public Commune () {
		
	}
	
	public String getNoCommune() {
		return noCommune;
	}

	public void setNoCommune(String noCommune) {
		this.noCommune = noCommune;
	}

	public String getNoDept() {
		return noDept;
	}

	public void setNoDept(String noDept) {
		this.noDept = noDept;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomStd() {
		return nomStd;
	}

	public void setNomStd(String nomStd) {
		this.nomStd = nomStd;
	}

	public String getTypeChefLieu() {
		return typeChefLieu;
	}

	public void setTypeChefLieu(String typeChefLieu) {
		this.typeChefLieu = typeChefLieu;
	}

	public String getTypeCommune() {
		return typeCommune;
	}

	public void setTypeCommune(String typeCommune) {
		this.typeCommune = typeCommune;
	}
	
	

}
