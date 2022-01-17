package br.com.mytv.appbackend.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Portfolio {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPortfolio;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Title title;
	
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar dateCreate;

	public long getIdPortfolio() {
		return idPortfolio;
	}

	protected void setIdPortfolio(long idPortfolio) {
		this.idPortfolio = idPortfolio;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Calendar getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Calendar dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Portfolio(User user, Title title, Calendar dateCreate) {
		this.user = user;
		this.title = title;
		this.dateCreate = dateCreate;
	}
		
}
