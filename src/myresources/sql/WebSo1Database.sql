CREATE DATABASE webso1_database;
use webso1_database;

CREATE TABLE User (
    id int NOT NULL AUTO_INCREMENT,
    user_name varchar(255) NOT NULL,
    full_name varchar(255),
    password varchar(255) NOT NULL,
    dob DATE,
    phone_number varchar(255),
    role varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO User (user_name, full_name, password, dob, phone_number, role)
VALUES ('tuanluc', 'Nguyễn Tuấn Lực', 'admin', '1997-09-03', '0386891200', 'admin');