--liquibase formatted sql
--changeset rodrigo:2020-07-24_1

ALTER TABLE tag ADD COLUMN IF NOT EXISTS id_knowledge_type smallint NOT NULL;

CREATE TABLE IF NOT EXISTS knowledge_type(
	id smallint primary key,
	name VARCHAR(128) NOT NULL,
	created_at timestamp without time zone not null
);

CREATE UNIQUE INDEX IF NOT EXISTS knowledge_type_idx ON knowledge_type (name);
CREATE SEQUENCE IF NOT EXISTS knowledge_type_seq;

ALTER TABLE tag ADD CONSTRAINT tag_fk_knowledge_type FOREIGN KEY (id_knowledge_type) 
	REFERENCES knowledge_type(id) MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION;

--rollback ALTER TABLE tag DROP COLUMN IF EXISTS id_knowledge_type;
--rollback DROP SEQUENCE IF EXISTS knowledge_type_seq;
--rollback DROP INDEX IF EXISTS knowledge_type_idx;
--rollback DROP TABLE IF EXISTS knowledge_type;