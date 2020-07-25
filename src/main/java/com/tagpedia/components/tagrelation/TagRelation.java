package com.tagpedia.components.tagrelation;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tagpedia.components.tag.Tag;

@Entity
@Table(name = "tag_relation")
public class TagRelation {

	private static final String SEQ = "tag_relation_seq";

	@Id
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tag_origin", nullable = false)
	private Tag tagOrigin;
	
	@JoinColumn(name = "id_tag_result", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Tag tagResult;

	public TagRelation() {
		super();
	}

	public TagRelation(Tag tagOrigin, Tag newRelation) {
		this.tagOrigin = tagOrigin;
		this.tagResult = newRelation;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tag getTagOrigin() {
		return this.tagOrigin;
	}

	public void setTagOrigin(Tag tagOrigin) {
		this.tagOrigin = tagOrigin;
	}

	public Tag getTagResult() {
		return this.tagResult;
	}

	public void setTagResult(Tag tagResult) {
		this.tagResult = tagResult;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tagOrigin, tagResult);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TagRelation)) {
			return false;
		}
		TagRelation other = (TagRelation) obj;
		return Objects.equals(tagOrigin, other.tagOrigin) && Objects.equals(tagResult, other.tagResult);
	}
}