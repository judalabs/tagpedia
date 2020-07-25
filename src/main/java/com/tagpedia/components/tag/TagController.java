package com.tagpedia.components.tag;

import static com.tagpedia.utils.TypeTagpediaUtil.getListType;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
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

@RequestMapping("/api/tags")
@ResponseBody
@RestController
class TagController {

	private final TagService service;
	private final ModelMapper modelMapper;

	public TagController(TagService service, @Qualifier("strictModelMapper") ModelMapper modelMapper) {
		this.service = service;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	public Response<TagDTO> save(@RequestBody @Valid TagDTO entityDTO) {

		final Tag entity = modelMapper.map(entityDTO, Tag.class);

		final Tag saved = service.save(entity);

		final TagDTO responseDTO = modelMapper.map(saved, TagDTO.class);

		return Response.<TagDTO>builder()
				.content(responseDTO).success(true)
				.message(HttpStatus.OK.toString())
				.build();
	}

	@PutMapping
	public Response<TagDTO> update(@RequestBody @Valid TagDTO entityDTO) {

		final Tag entity = modelMapper.map(entityDTO, Tag.class);

		final Tag updated = service.update(entity);

		final TagDTO responseDTO = modelMapper.map(updated, TagDTO.class);

		return Response.<TagDTO>builder().content(responseDTO)
				.success(true)
				.message(HttpStatus.OK.toString())
				.build();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@GetMapping("/term/{term}")
	public Response<List<TagDTO>> get(@PathVariable String term) {
		
		List<Tag> result = service.findByTerm(term);
		
		List<TagDTO> resultDTO = modelMapper.map(result, getListType(TagDTO.class));
		
		return Response.<List<TagDTO>>builder()
			.content(resultDTO)
			.message(HttpStatus.OK.toString())
			.success(true)
			.build();
	}
}