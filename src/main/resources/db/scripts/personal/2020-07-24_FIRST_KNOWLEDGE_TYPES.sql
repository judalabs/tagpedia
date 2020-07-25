--liquibase formatted sql
--changeset rodrigo:2020-07-24_2
INSERT INTO knowledge_type values(nextval('knowledge_type_seq'), 'Person', now());
INSERT INTO knowledge_type values(nextval('knowledge_type_seq'), 'Spirit', now());
INSERT INTO knowledge_type values(nextval('knowledge_type_seq'), 'Concept', now());
INSERT INTO knowledge_type values(nextval('knowledge_type_seq'), 'Technique', now());
INSERT INTO knowledge_type values(nextval('knowledge_type_seq'), 'Book', now());
INSERT INTO knowledge_type values(nextval('knowledge_type_seq'), 'Undefined', now());