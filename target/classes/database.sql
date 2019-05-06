CREATE DATABASE restapi;
USE restapi;

-- CREATE TABLE blog (
--  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
--   title VARCHAR(500) NOT NULL,
--   content VARCHAR(5000) NOT NULL
-- );

CREATE TABLE cards (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    card VARCHAR(500) NOT NULL,
    amt DOUBLE NOT NULL
);

INSERT into cards (id, card, amt) VALUES ('1', '123456789', 20.0)

CREATE TABLE users (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR (20) NOT NULL,
    password VARCHAR(20) NOT NULL
);