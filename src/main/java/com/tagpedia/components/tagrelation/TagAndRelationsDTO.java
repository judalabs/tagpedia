package com.tagpedia.components.tagrelation;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.tagpedia.components.tag.TagDTO;

public class TagAndRelationsDTO {

	@NotNull
	private TagDTO tag;
	
	private List<TagDTO> relations;

	public TagDTO getTag() {
		return this.tag;
	}

	public void setTag(TagDTO tag) {
		this.tag = tag;
	}

	public List<TagDTO> getRelations() {
		return this.relations;
	}

	public void setRelations(List<TagDTO> relations) {
		this.relations = relations;
	}

}
