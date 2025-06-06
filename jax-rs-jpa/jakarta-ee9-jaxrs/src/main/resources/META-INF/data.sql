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
