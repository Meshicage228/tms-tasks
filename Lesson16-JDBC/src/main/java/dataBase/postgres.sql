CREATE TABLE IF NOT EXISTS students(
   stud_id    INT PRIMARY KEY ,
   name       VARCHAR,
   surname    VARCHAR,
   town       INT CONSTRAINT town_key REFERENCES towns(towns_id)
);
CREATE TABLE IF NOT EXISTS towns(
   towns_id INT PRIMARY KEY,
   name VARCHAR UNIQUE
);

DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS towns;

INSERT INTO students (stud_id, name, surname, town)
VALUES (1, 'Vlad', 'Zherko', 1),
       (2, 'Chel', 'Chell1', 2),
       (3, 'Olga', 'Hmur', 2),
       (4, 'Pootis', 'Heavy', 3),
       (5, 'Doctor', 'Gerin', 4);

INSERT INTO towns (towns_id, name)
VALUES (1, 'Minsk'),
       (2, 'Baranovichi'),
       (3, 'Rechitsa'),
       (4, 'Vitebsk');
