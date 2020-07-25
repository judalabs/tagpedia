package com.tagpedia.components.tagrelation;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tagpedia.components.tag.Tag;

@Service
public class TagRelationService {

	private final TagRelationRepository repository;

	public TagRelationService(TagRelationRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public TagAndRelations update(TagAndRelations request) {
		final Tag tagOrigin = request.getTag();
		Set<TagRelation> relationsDB = this.findByTagOrigin( tagOrigin );
		
		final List<TagRelation> newRelations = request.getRelations().stream()
			.map( this.getNewRelationAndUpdateSet( tagOrigin, relationsDB ) )
			.filter( Objects::nonNull )
			.map( newRelation -> new TagRelation( tagOrigin, newRelation ) )
			.collect( toList() );
		
		repository.save(newRelations);
		repository.delete(relationsDB);
		return new TagAndRelations(tagOrigin, findByTagOrigin(tagOrigin));
	}

	private UnaryOperator<Tag> getNewRelationAndUpdateSet(final Tag tagOrigin, Set<TagRelation> relationsDB) {
		return itemRequest-> {
			TagRelation search = new TagRelation(tagOrigin, itemRequest);
			boolean contains = relationsDB.contains(search);
			if(contains) {
				relationsDB.remove(search);
				return null;
			}
			return itemRequest;
		};
	}
	
	@Transactional
	public void delete(Long id) {
		repository.delete(new TagRelation());
	}

	public Set<TagRelation> findByTagOrigin(Tag tagOrigin) {
		return repository.findByTagOrigin(tagOrigin);
	}
	
	public Set<Tag> findOnlyTagsFromRelation(Tag tagOrigin) {
		return findByTagOrigin(tagOrigin).stream()
				.map(TagRelation::getTagResult)
				.collect(Collectors.toSet());
	}
}