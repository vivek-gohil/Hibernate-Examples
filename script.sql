DROP DATABASE msedcldb;

CREATE DATABASE msedcldb;

USE msedcldb;


-- Hibernate One To Many Mapping Example 
CREATE TABLE department_details(
	department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL
);

CREATE TABLE employee_details(
	employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    department_id INT NOT NULL,
    CONSTRAINT department_id_fk FOREIGN KEY(department_id) REFERENCES department_details(department_id)
);

SELECT * FROM department_details;
SELECT * FROM employee_details;

-- Hibernate One To One Mapping Example and One To Many Example and Cascade Type example 
CREATE TABLE address_details (
	address_id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    pincode VARCHAR(10) NOT NULL
);

CREATE TABLE user_details (
	user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    address_id INT NOT NULL,
    CONSTRAINT address_id_fk FOREIGN KEY(address_id) REFERENCES address_details(address_id)
);
SELECT * FROM address_details;
SELECT * FROM user_details;

DROP TABLE address_details;
DROP TABLE user_details;

INSERT INTO address_details(city,pincode) VALUES('Thane', 400065);
INSERT INTO address_details(city,pincode) VALUES('Mumbai', 400012);
INSERT INTO user_details(name,address_id) VALUES('Vivek Gohil',1);
INSERT INTO user_details(name,address_id) VALUES('Advaot Gohil',2);

-- Hibernate Many To Many Example
CREATE TABLE address_details (
	address_id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    pincode VARCHAR(10) NOT NULL
);

CREATE TABLE user_details (
	user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE user_address (
	user_id INT,
    address_id INT,
    CONSTRAINT user_id_fk FOREIGN KEY(address_id) REFERENCES user_details(user_id),
    CONSTRAINT address_id_fk FOREIGN KEY(user_id) REFERENCES address_details(address_id)
);

SELECT * FROM user_details;
SELECT * FROM address_details;
SELECT * FROM user_address;

DROP TABLE user_details;
DROP TABLE address_details;
DROP TABLE user_address;

SELECT * FROM user_details;

SELECT * FROM Vehicle;
SELECT * FROM Bike;
SELECT * FROM Car;

CREATE TABLE employee_details(
	employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    salary DOUBLE
);



