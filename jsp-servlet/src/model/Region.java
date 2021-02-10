package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="regions")
public class Region {
	

	@Id
	@Column(name="no_region")
	private Integer noRegion;
	
	@Column(name="nom", length = 50)
	private String nom;
	
	@Column(name="surface", length = 11 )
	private Integer surface;
	
	@Column(name="description")
	private String description;
	
	@Column(name="url_wiki", length = 100)
	private String urlWiki;
	
	//on cible l'entity/class de Departement par region et on en fait une liste
	@OneToMany(targetEntity = Departement.class, mappedBy = "region" )
	public ArrayList<Departement> departements = new ArrayList<Departement>();
	
	public ArrayList<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(ArrayList<Departement> departements) {
		this.departements = departements;
	}

	public Region() {
		
	}
	
	public String toString() {
		return nom;
	}
	
	public Integer getNoRegion() {
		return noRegion;
	}

	public void setNoRegion(Integer noRegion) {
		this.noRegion = noRegion;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlWiki() {
		return urlWiki;
	}

	public void setUrlWiki(String urlWiki) {
		this.urlWiki = urlWiki;
	}
	
	

}
