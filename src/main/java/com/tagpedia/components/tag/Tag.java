package com.tagpedia.components.tag;

import java.time.YearMonth;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tagpedia.components.knowledgetype.KnowledgeType;
import com.tagpedia.utils.YearMonthDateAttributeConverter;

@Entity
@Table(name = "tag")
public class Tag {

	private static final String SEQ = "tag_seq";

	@Id
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_knowledge_type", nullable = false)
	private KnowledgeType knowledgeType;
	
	@Column(name = "name", nullable = false, length = 128)
	private String name;

	@Column(name = "description", length = 512)
	private String description;
	

	@Column(name = "created_at", nullable = false, columnDefinition = "date")
	@Convert(converter = YearMonthDateAttributeConverter.class)
	private YearMonth created;

	@Override
	public String toString() {
		return "Tag [id=" + this.id + ", knowledgeType=" + this.knowledgeType + ", name=" + this.name + "]";
	}

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

	public KnowledgeType getKnowledgeType() {
		return this.knowledgeType;
	}

	public void setKnowledgeType(KnowledgeType knowledgeType) {
		this.knowledgeType = knowledgeType;
	}

	public YearMonth getCreated() {
		return this.created;
	}

	public void setCreated(YearMonth created) {
		this.created = created;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Tag)) {
			return false;
		}
		Tag other = (Tag) obj;
		return Objects.equals(id, other.id);
	}
	
}