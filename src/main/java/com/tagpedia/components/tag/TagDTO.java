package com.tagpedia.components.tag;

import java.time.YearMonth;

import com.tagpedia.components.knowledgetype.KnowledgeTypeDTO;

public class TagDTO {

	private Long id;

	private String name;

	private String description;
	
	private KnowledgeTypeDTO knowledgeType;

	private YearMonth created;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public KnowledgeTypeDTO getKnowledgeType() {
		return this.knowledgeType;
	}

	public void setKnowledgeType(KnowledgeTypeDTO knowledgeType) {
		this.knowledgeType = knowledgeType;
	}

	public YearMonth getCreated() {
		return this.created;
	}

	public void setCreated(YearMonth created) {
		this.created = created;
	}
	
}