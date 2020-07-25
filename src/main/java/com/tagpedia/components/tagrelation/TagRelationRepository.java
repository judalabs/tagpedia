package com.tagpedia.components.tagrelation;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tagpedia.components.tag.Tag;

interface TagRelationRepository extends JpaRepository<TagRelation, Long> {

	Set<TagRelation> findByTagOrigin(Tag tag);

}