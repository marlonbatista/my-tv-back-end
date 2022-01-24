package br.com.mytv.appbackend.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mytv.appbackend.controller.dto.Input.TitleForm;
import br.com.mytv.appbackend.model.Title;
import br.com.mytv.appbackend.repository.TitleRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TitleService {

    @Autowired
    private TitleRepository repository;

    public Title getTitle(Long id) {
        return this.repository.getById(id);
    }

    @Transactional
    public Title save(TitleForm form) {
        try {
            Title title = this.parseTitleFormToTitle(form);
            return this.repository.save(title);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public Title parseTitleFormToTitle(TitleForm form) {
        try {
            return new Title(
                    form.getName(),
                    form.getDateRegister(),
                    form.getSecondName(),
                    form.getGenre(),
                    form.getPlataforms(),
                    form.getCategory(),
                    form.getPoster(),
                    form.getDescription());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

}
