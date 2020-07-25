package com.tagpedia.components.tag;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface TagRepository extends JpaRepository<Tag, Long> {

	public static final String QUERY_LIKE = " SELECT T FROM Tag T "
									+ " WHERE T.name like :term%"
									+ " ORDER BY T.name";

	@Query(QUERY_LIKE)
	List<Tag> findLike(@Param("term") String term, Pageable pageable);

}
