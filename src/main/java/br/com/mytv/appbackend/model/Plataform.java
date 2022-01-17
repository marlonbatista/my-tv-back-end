package br.com.mytv.appbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class Plataform {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPlataform;
	
	@NotEmpty
	@NotNull
	private String name;
	
	private String posterBrandLocate;
	

	public Plataform(@NotEmpty String name, String posterBrandLocate) {
		this.name = name;
		this.posterBrandLocate = posterBrandLocate;
	}

	public long getIdPlataform() {
		return idPlataform;
	}

	public void setIdPlataform(int idPlataform) {
		this.idPlataform = idPlataform;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosterBrandLocate() {
		return posterBrandLocate;
	}

	public void setPosterBrandLocate(String posterBrandLocate) {
		this.posterBrandLocate = posterBrandLocate;
	}
		
}
