package br.com.mytv.appbackend.controller.dto.Input;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.mytv.appbackend.model.PlataformTitle;
import br.com.mytv.appbackend.model.enums.Category;
import br.com.mytv.appbackend.model.enums.Genre;

public class TitleForm {

    @NotEmpty
    @NotNull
    private String name;

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar dateRegister;

    private String secondName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Genre genre;

    private List<PlataformTitle> plataforms;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotEmpty
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
