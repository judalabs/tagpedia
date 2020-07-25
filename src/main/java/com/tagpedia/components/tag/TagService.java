package com.tagpedia.components.tag;

import java.time.YearMonth;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagService {

	private final TagRepository repository;

	public TagService(TagRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public Tag save(Tag entity) {
		entity.setCreated(YearMonth.now());
		return repository.save(entity);
	}

	@Transactional
	public Tag update(Tag entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(Long id) {
		repository.delete(new Tag());
	}

	public List<Tag> findByTerm(String term) {
		PageRequest max10Records = new PageRequest(0,10);
		return repository.findLike(term, max10Records);
	}

}
