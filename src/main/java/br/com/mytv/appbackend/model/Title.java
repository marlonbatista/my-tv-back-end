package br.com.mytv.appbackend.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import br.com.mytv.appbackend.model.enums.Category;
import br.com.mytv.appbackend.model.enums.Genre;

@Entity
public class Title {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTitle;

	@NotEmpty
	@NotNull
	private String name;

	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar dateRegister;

	private String secondName;

	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar dateChange;

	@Enumerated(EnumType.STRING)
	private Genre genre;

	@OneToMany
	private List<PlataformTitle> plataforms;

	@Enumerated(EnumType.STRING)
	private Category category;

	@NotEmpty
	@NotNull
	private String poster;

	@NotEmpty
	@NotNull
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Calendar dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Calendar getDateChange() {
		return dateChange;
	}

	public void setDateChange(Calendar dateChange) {
		this.dateChange = dateChange;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<PlataformTitle> getPlataforms() {
		return plataforms;
	}

	public void setPlataforms(List<PlataformTitle> plataforms) {
		this.plataforms = plataforms;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public long getIdTitle() {
		return idTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Title() {

	}

	public Title(@NotEmpty String name, Calendar dateRegister, String secondName, Genre genre,
			List<PlataformTitle> plataforms, Category category, @NotEmpty String poster, @NotEmpty String description) {
		this.name = name;
		this.dateRegister = dateRegister;
		this.secondName = secondName;
		this.dateChange = Calendar.getInstance();
		this.genre = genre;
		this.plataforms = plataforms;
		this.category = category;
		this.poster = poster;
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTitle == null) ? 0 : idTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		if (idTitle == null) {
			if (other.idTitle != null)
				return false;
		} else if (!idTitle.equals(other.idTitle))
			return false;
		return true;
	}
}
