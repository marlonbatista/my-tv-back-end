package br.com.mytv.appbackend.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mytv.appbackend.controller.dto.Input.TitleForm;
import br.com.mytv.appbackend.controller.dto.Output.TitleDto;
import br.com.mytv.appbackend.model.Title;
import br.com.mytv.appbackend.model.enums.Category;
import br.com.mytv.appbackend.repository.TitleRepository;
import br.com.mytv.appbackend.service.TitleService;

@CrossOrigin
@RestController
@RequestMapping("/title")
public class TitleController {

	@Autowired
	private TitleRepository repository;

	@Autowired
	private TitleService service;

	@GetMapping
	public List<TitleDto> listar(
			// @RequestParam(required=false) String titleName,
			@RequestParam(required = false) Category category) throws Exception {

		if (category != null) {
			List<Title> titles = repository.findByCategory(category);
			return TitleDto.convert(titles);
		} else {
			List<Title> titles = repository.getTopFourTitlesByCategoList();
			return TitleDto.convert(titles);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<TitleDto> getById(@PathVariable Long id) {
		Title title = repository.getById(id);
		if(title != null) {
			return ResponseEntity.ok(new TitleDto(title));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<TitleDto> save(@RequestBody @Valid TitleForm form, UriComponentsBuilder uriBuilder) {

		Title title = this.service.save(form);

		URI uri = uriBuilder.path("title/{id}").buildAndExpand(title.getIdTitle()).toUri();
		return ResponseEntity.created(uri).body(new TitleDto(title));
	}
}
