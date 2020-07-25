package com.tagpedia.components.tagrelation;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tagpedia.component.rest.Response;

@RequestMapping("/api/tag-relations")
@ResponseBody
@RestController
class TagRelationController {

	private final TagRelationService service;
	private final ModelMapper modelMapper;

	public TagRelationController(TagRelationService service, ModelMapper modelMapper) {
		this.service = service;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	public Response<TagAndRelationsDTO> update(
			@RequestBody @Valid TagAndRelationsDTO entityDTO) {

		final TagAndRelations entity = modelMapper.map(entityDTO, TagAndRelations.class);

		final TagAndRelations saved = service.update(entity);

		final TagAndRelationsDTO responseDTO = modelMapper.map(saved, TagAndRelationsDTO.class);

		return Response.<TagAndRelationsDTO>builder()
				.content(responseDTO)
				.success(true)
				.message(HttpStatus.OK.toString())
				.build();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@GetMapping("/{id}")
	public void get(@PathVariable Long id) {

	}
}
