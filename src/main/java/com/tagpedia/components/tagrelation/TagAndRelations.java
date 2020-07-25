package com.tagpedia.components.tagrelation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.tagpedia.components.tag.Tag;

public class TagAndRelations {

	private Tag tag;
	
	private List<Tag> relations;

	public TagAndRelations() {
		super();
	}

	public TagAndRelations(Tag tagOrigin, Set<TagRelation> findByOrigin) {
		this.tag = tagOrigin;
		this.relations = findByOrigin.stream()
				.map(TagRelation::getTagResult)
				.collect(Collectors.toList());
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public List<Tag> getRelations() {
		return this.relations;
	}

	public void setRelations(List<Tag> relations) {
		this.relations = relations;
	}
	
}
