package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="departements")
public class Departement {
	
	@Id
	@Column(name="no_dept")
	private String noDept;
	
	@Column(name="no_region")
	private Integer noRegion;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="nom_std")
	private String nomStd;
	
	@Column(name="surface")
	private Integer surface;
	
	@Column(name="nb_habitants")
	private Integer nbHabitants;
	
	@Column(name="date_creation", columnDefinition = "DATE") // /!\ Attention format particulier pour les dates!
	private Date dateCreation;
	
	@Column(name="`chef-lieu`")
	private String chefLieu;
	
	@Column(name="url_wiki")
	private String urlWiki;
	
	@ManyToOne
	@PrimaryKeyJoinColumn( name="no_region" )
	private Region region;
	
	public String toString() {
		return nom;
	}
	
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Departement() {
	}

	public String getNoDept() {
		return noDept;
	}

	public void setNoDept(String noDept) {
		this.noDept = noDept;
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

	public String getNomStd() {
		return nomStd;
	}

	public void setNomStd(String nomStd) {
		this.nomStd = nomStd;
	}

	public Integer getSurface() {
		return surface;
	}

	public void setSurface(Integer surface) {
		this.surface = surface;
	}

	public Integer getNbHabitants() {
		return nbHabitants;
	}

	public void setNbHabitants(Integer nbHabitants) {
		this.nbHabitants = nbHabitants;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getChefLieu() {
		return chefLieu;
	}

	public void setChefLieu(String chefLieu) {
		this.chefLieu = chefLieu;
	}

	public String getUrlWiki() {
		return urlWiki;
	}

	public void setUrlWiki(String urlWiki) {
		this.urlWiki = urlWiki;
	}


	
	

}
