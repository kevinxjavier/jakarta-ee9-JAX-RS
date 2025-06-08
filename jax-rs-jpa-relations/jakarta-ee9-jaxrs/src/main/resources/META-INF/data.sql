-- Execute this on MySQL Database

CREATE DATABASE enterprise;
USE enterprise;

CREATE TABLE course (
                        id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                        name VARCHAR(45) NULL,
                        instructor VARCHAR(45) NULL,
                        duration DOUBLE NULL
);

INSERT INTO course (name, instructor, duration) VALUES ('Java', 'kevin', 4);
INSERT INTO course (name, instructor, duration) VALUES ('Servlet', 'kevin', 2);
INSERT INTO course (name, instructor, duration) VALUES ('JSP', 'javier', 1);
INSERT INTO course (name, instructor, duration) VALUES ('JSF', 'pina', 1);

CREATE TABLE instructor (
                        id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                        name VARCHAR(45) NULL,
                        surname VARCHAR(45) NULL
);

INSERT INTO instructor (name, surname) VALUES ('kevin', 'pina'), ('javier', 'calatrava');

UPDATE course SET instructor = 1;

ALTER TABLE course MODIFY COLUMN instructor INT NULL;

ALTER TABLE course CHANGE instructor instructor_id int NULL;

ALTER TABLE course ADD CONSTRAINT fk_course_instructor FOREIGN KEY (instructor_id) REFERENCES instructor(id);
