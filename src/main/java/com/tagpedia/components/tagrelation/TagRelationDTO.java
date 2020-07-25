package com.tagpedia.components.tagrelation;

import com.tagpedia.components.tag.TagDTO;

public class TagRelationDTO {

	private Long id;

	private TagDTO tagOrigin;
	
	private TagDTO tagResult;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TagDTO getTagOrigin() {
		return this.tagOrigin;
	}

	public void setTagOrigin(TagDTO tagOrigin) {
		this.tagOrigin = tagOrigin;
	}

	public TagDTO getTagResult() {
		return this.tagResult;
	}

	public void setTagResult(TagDTO tagResult) {
		this.tagResult = tagResult;
	}

}