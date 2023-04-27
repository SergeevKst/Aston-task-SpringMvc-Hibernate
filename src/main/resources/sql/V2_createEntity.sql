CREATE TABLE Aston_application.address
(
id_address INT AUTO_INCREMENT NOT NULL,
city       VARCHAR(45)        NOT NULL,
street     VARCHAR(45)        NOT NULL,
CONSTRAINT pk_address PRIMARY KEY (id_address)
);

CREATE TABLE Aston_application.employee
(
id_employee INT AUTO_INCREMENT NOT NULL,
name        VARCHAR(45)        NOT NULL,
id_address  INT                NULL,
CONSTRAINT pk_employee PRIMARY KEY (id_employee)
);

ALTER TABLE Aston_application.employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_ID_ADDRESS FOREIGN KEY (id_address) REFERENCES Aston_application.address (id_address);


