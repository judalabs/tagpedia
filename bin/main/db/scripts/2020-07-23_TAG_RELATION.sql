--liquibase formatted sql
--changeset rodrigo:2020-07-23_1

CREATE TABLE IF NOT EXISTS tag(
	id bigint primary key,
	name VARCHAR(128) NOT NULL,
	description VARCHAR(512),
	knowledge_type VARCHAR(32) NOT NULL,
	created_at timestamp without time zone not null
);
CREATE UNIQUE INDEX IF NOT EXISTS tag_idx ON tag (name);
CREATE SEQUENCE IF NOT EXISTS tag_seq;

CREATE TABLE IF NOT EXISTS tag_relation(
	id bigint primary key, 
	id_tag_origin bigint NOT NULL,
	id_tag_result bigint not NULL,
    CONSTRAINT tag_relation_fk_tag_origin FOREIGN KEY (id_tag_origin)
	REFERENCES tag(id) MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT tag_relation_fk_tag_result FOREIGN KEY (id_tag_result)
	REFERENCES tag(id) MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE UNIQUE INDEX IF NOT EXISTS tag_relation_idx ON tag_relation (id_tag_origin, id_tag_result);
CREATE SEQUENCE IF NOT EXISTS tag_relation_seq;

--rollback DROP TABLE IF EXISTS tag_relation;
--rollback DROP TABLE IF EXISTS tag;
--rollback DROP INDEX IF EXISTS tag_idx;
--rollback DROP INDEX IF EXISTS tag_relation_idx;
--rollback DROP SEQUENCE IF EXISTS tag_seq;
--rollback DROP SEQUENCE IF EXISTS tag_relation_seq;
