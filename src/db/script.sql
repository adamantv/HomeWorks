CREATE SCHEMA IF NOT EXISTS otus_hw;


CREATE TABLE IF NOT EXISTS otus_hw.question (
	id UUID PRIMARY KEY,
	text VARCHAR ( 255 ) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS otus_hw.answer (
	id UUID PRIMARY KEY,
	text VARCHAR ( 255 ) NOT NULL,
	is_correct BOOLEAN,
	question UUID NOT NULL,
	FOREIGN KEY (question) REFERENCES otus_hw.question(id) ON DELETE CASCADE,
	position INT NOT NULL
);


CREATE TABLE IF NOT EXISTS otus_hw.test (
	id UUID PRIMARY KEY,
	create_date TIMESTAMP NOT NULL,
	correct_answer_count INT NOT NULL,
	incorrect_answer_count INT NOT NULL,
	username VARCHAR ( 255 ) NOT NULL
);

INSERT INTO otus_hw.question (id, text)
VALUES ('3e6977be-2505-11ec-9621-0242ac130002', 'Как называется наша планета?');

INSERT INTO otus_hw.answer (id, text, is_correct, question, position)
VALUES ('b6cb3608-2504-11ec-9621-0242ac130002', 'Земля', true, '3e6977be-2505-11ec-9621-0242ac130002', 1);
INSERT INTO otus_hw.answer (id, text, is_correct, question, position)
VALUES ('eed0c2d4-2504-11ec-9621-0242ac130002', 'Марс', false, '3e6977be-2505-11ec-9621-0242ac130002', 2);
INSERT INTO otus_hw.answer (id, text, is_correct, question, position)
VALUES ('07e0a7a8-2505-11ec-9621-0242ac130002', 'Венера', false, '3e6977be-2505-11ec-9621-0242ac130002', 3);

INSERT INTO otus_hw.question (id, text)
VALUES ('69f4c0a4-2506-11ec-9621-0242ac130002', 'Как называется планета с кольцами?');

INSERT INTO otus_hw.answer (id, text, is_correct, question, position)
VALUES ('4a904e4a-2506-11ec-9621-0242ac130002', 'Плутон', false, '69f4c0a4-2506-11ec-9621-0242ac130002', 1);
INSERT INTO otus_hw.answer (id, text, is_correct, question, position)
VALUES ('51f7f1ec-2506-11ec-9621-0242ac130002', 'Уран', false, '69f4c0a4-2506-11ec-9621-0242ac130002', 2);
INSERT INTO otus_hw.answer (id, text, is_correct, question, position)
VALUES ('56bfdbfe-2506-11ec-9621-0242ac130002', 'Нептун', false, '69f4c0a4-2506-11ec-9621-0242ac130002', 3);
INSERT INTO otus_hw.answer (id, text, is_correct, question, position)
VALUES ('6213f60c-2506-11ec-9621-0242ac130002', 'Сатурн', true, '69f4c0a4-2506-11ec-9621-0242ac130002', 4);

INSERT INTO otus_hw.test(id, create_date, correct_answer_count, incorrect_answer_count, username)
VALUES ('ea0e1df4-2505-11ec-9621-0242ac130002', now(), 3, 2, 'user1');
INSERT INTO otus_hw.test(id, create_date, correct_answer_count, incorrect_answer_count, username)
VALUES ('0c61caf4-2506-11ec-9621-0242ac130002', now(), 2, 3, 'user2');

--examples for looking all answers with questoins
SELECT q.text, a.text FROM otus_hw.answer a
JOIN otus_hw.question q ON
a.question = q.id;

--example for looking only correct answers with questoins
SELECT q.text, a.text FROM otus_hw.answer a
JOIN otus_hw.question q ON
a.question = q.id
WHERE a.is_correct = true;