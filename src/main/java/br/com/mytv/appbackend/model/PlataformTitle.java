package br.com.mytv.appbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlataformTitle {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlataformTitle;
	
	@ManyToOne
	private Title title;
	
	@ManyToOne
	private Plataform plataform;
	
	private String linkPlataform;

	public Long getIdPlataformTitle() {
		return idPlataformTitle;
	}

	protected void setIdPlataformTitle(Long idPlataformTitle) {
		this.idPlataformTitle = idPlataformTitle;
	}

	public Title getIdTitle() {
		return title;
	}

	public void setIdTitle(Title title) {
		this.title = title;
	}

	public Plataform getIdPlataform() {
		return plataform;
	}

	public void setIdPlataform(Plataform plataform) {
		this.plataform = plataform;
	}

	public String getLinkPlataform() {
		return linkPlataform;
	}

	public void setLinkPlataform(String linkPlataform) {
		this.linkPlataform = linkPlataform;
	}

	public PlataformTitle(Title title, Plataform plataform, String linkPlataform) {
		this.title = title;
		this.plataform = plataform;
		this.linkPlataform = linkPlataform;
	}
	
	
}
