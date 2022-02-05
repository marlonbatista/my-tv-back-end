package br.com.mytv.appbackend.controller.dto.Output;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.mytv.appbackend.model.Title;
import br.com.mytv.appbackend.model.enums.Category;

public class TitleDto {

	private Long idTitle;
	private String name;
	private String secondName;
	private Calendar dateRegister;
	private String poster;
	private Category category;
	private String producer;
	private Calendar releaseDate;

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Calendar getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	public Long getIdTitle() {
		return idTitle;
	}
	
	public void setIdTitle(Long idTitle) {
		this.idTitle = idTitle;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	public Calendar getDateRegister() {
		return dateRegister;
	}
	
	public void setDateRegister(Calendar dateRegister) {
		this.dateRegister = dateRegister;
	}
	
	public String getPoster() {
		return poster;
	}
	
	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public TitleDto(Title title) {
		this.idTitle = title.getIdTitle();
		this.name = title.getName();
		this.secondName = title.getSecondName();
		this.dateRegister = title.getDateRegister();
		this.poster = title.getPoster();
		this.category = title.getCategory();
		this.producer = title.getProducer();
		this.releaseDate = title.getReleaseDate();

	}

	
	public static List<TitleDto> convert(List<Title> titles) throws Exception {
		try {
			List<TitleDto> list = new ArrayList<TitleDto>();
			for (Title title : titles) {
				list.add(new TitleDto(title));
			}
			return list;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
