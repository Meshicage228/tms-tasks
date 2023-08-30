CREATE TABLE IF NOT EXISTS human(
    human_id     INT PRIMARY KEY,
    name         VARCHAR,
    sex          VARCHAR,
    birthdayDate DATE
);
CREATE TABLE IF NOT EXISTS hobby(
    hobby_id     INT PRIMARY KEY,
    title        VARCHAR
);
CREATE TABLE IF NOT EXISTS type_hobby(
    type_hobby_id INT PRIMARY KEY REFERENCES hobby (hobby_id),
    active        VARCHAR
    );
CREATE TABLE IF NOT EXISTS human_hobby(
    idHum INT REFERENCES human (human_id),
    idHob INT REFERENCES hobby (hobby_id),
    CONSTRAINT human_hobby_pkey PRIMARY KEY (idHum, idHob)
);

DROP TABLE IF EXISTS human;
DROP TABLE IF EXISTS hobby;
DROP TABLE IF EXISTS type_hobby;
DROP TABLE IF EXISTS human_hobby;

INSERT INTO human (human_id, name, sex, birthdayDate)
VALUES (1, 'Vlad', 'male', '2004-03-03'),
       (2, 'Kseni', 'fmale', '2012-03-21'),
       (3, 'Egor', 'male', '2001-05-17'),
       (4, 'Polina', 'fmale', '2007-09-12'),
       (5, 'Marina', 'fmale', '2001-12-12'),
       (6, 'Lesha', 'male', '2012-11-13'),
       (7, 'Sergey', 'male', '2011-03-03'),
       (8, 'Tonya', 'fmale', '2016-05-12'),
       (9, 'Zhrozh', 'male', '2017-08-29'),
       (10, 'King', 'male', '2018-09-01');

INSERT INTO hobby (hobby_id, title)
VALUES (1, 'footbal'),
       (3, 'reading'),
       (4, 'walking'),
       (5, 'basketball'),
       (6, 'hobbyHoursing');

INSERT INTO human_hobby (idHum, idHob)
VALUES (1, 3),
       (1, 1),
       (2, 3),
       (4, 6),
       (3, 5),
       (3, 4),
       (9, 1);

INSERT INTO type_hobby (type_hobby_id, active)
VALUES (1, 'active'),
       (3, 'passive'),
       (4, 'passive'),
       (5, 'active'),
       (6, 'active');

-- Info who is older
SELECT *
FROM human
WHERE birthdayDate <= '2012-11-12';

-- Sex - count
SELECT sex, count(*)
FROM human
GROUP BY sex;

-- Info about human and hobby
SELECT hum.name, hum.sex, hum.birthdayDate, h.title AS hobby
FROM human hum
         JOIN human_hobby hh ON hum.human_id = hh.idHum
         JOIN hobby h ON h.hobby_id = hh.idHob;

-- count Active/Passive hobbies
SELECT active, count(*)
FROM hobby
         JOIN type_hobby t_h ON t_h.type_hobby_id = hobby.hobby_id
GROUP BY active;

-- More than one hobby
SELECT human.name, count(*)
FROM human
         JOIN human_hobby hh ON human.human_id = hh.idHum
GROUP BY human.name, hh.idHum
HAVING count(human_id) > 1;

--Humans with only PASSIVE hobbies
SELECT human.name
FROM human
         JOIN human_hobby hh ON human.human_id = hh.idHum
         JOIN hobby h ON h.hobby_id = hh.idHob
         JOIN type_hobby th ON h.hobby_id = th.type_hobby_id
WHERE th.active LIKE 'passive';

-- Active/Passive hobbies
SELECT hobby.title AS hobby, t_h.active
FROM hobby
         JOIN type_hobby t_h ON t_h.type_hobby_id = hobby.hobby_id

