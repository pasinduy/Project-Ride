CREATE TABLE IF NOT EXISTS user (
        Email VARCHAR(40) NOT NULL,
        username VARCHAR(20) NOT NULL,
        password VARCHAR(20) NOT NULL,
        PRIMARY KEY (`username`)
);

CREATE TABLE IF NOT EXISTS employee (
    empId VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    address VARCHAR(20) NOT NULL,
    contact VARCHAR(20) NOT NULL,
    username VARCHAR(20) NOT NULL,
    PRIMARY KEY (empId, username),
    FOREIGN KEY (username) REFERENCES user (username) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS attendance(
    attId VARCHAR(20) NOT NULL,
    time TIME NOT NULL,
    date DATE NOT NULL,
    status VARCHAR(10) NOT NULL,
    empId VARCHAR(20) NULL DEFAULT NULL,
    PRIMARY KEY (attId),
    FOREIGN KEY (empId) REFERENCES employee (empId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS trains (
    `trainId` VARCHAR(20) NOT NULL,
    `type` VARCHAR(20) NULL DEFAULT NULL,
    `noOfSeats` INT NOT NULL,
    `status` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`trainId`)
);

CREATE TABLE IF NOT EXISTS driver (
    driverId VARCHAR(20) NOT NULL,
    trainId VARCHAR(20) NOT NULL,
    username VARCHAR(20) NOT NULL,
    PRIMARY KEY (driverId),
    FOREIGN KEY (trainId) REFERENCES trains (trainId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (username) REFERENCES user (username) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS passenger (
    passengerId VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    address VARCHAR(20) NOT NULL,
    contact VARCHAR(20) NOT NULL,
    PRIMARY KEY (passengerId)
);

CREATE TABLE IF NOT EXISTS payroll (
    salaryId VARCHAR(20) NOT NULL,
    amount VARCHAR(20) NOT NULL,
    date INT NOT NULL,
    month INT NOT NULL,
    status VARCHAR(10) NOT NULL,
    empId VARCHAR(20) NULL,
    PRIMARY KEY (salaryId),
    FOREIGN KEY (empId) REFERENCES employee (empId) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS reservation (
    reservationId VARCHAR(20) NOT NULL,
    trainId VARCHAR(20) NOT NULL,
    passengerId VARCHAR(20) NOT NULL,
    noOfSeats VARCHAR(45) NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (reservationId),
    FOREIGN KEY (trainId) REFERENCES trains (trainId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (passengerId) REFERENCES passenger (passengerId) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS trainschedule (
    scheduleId VARCHAR(20) NOT NULL,
    trainId VARCHAR(20) NOT NULL,
    fromStation VARCHAR(20) NOT NULL,
    toStation VARCHAR(20) NOT NULL,
    date DATE NOT NULL,
    time TIME NOT NULL,
    timeperiod VARCHAR(10) NOT NULL,
    PRIMARY KEY (scheduleId),
    FOREIGN KEY (trainId) REFERENCES trains (trainId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS delivery (
                                        deliveryId VARCHAR(20) NOT NULL,
                                        trainId VARCHAR(20) NOT NULL,
                                        date DATE NOT NULL,
                                        time TIME NOT NULL,
                                        weight INT NOT NULL,
                                        price DOUBLE NOT NULL,
                                        passengerId VARCHAR(20) NOT NULL,
                                        PRIMARY KEY (deliveryId),
                                        FOREIGN KEY (passengerId) REFERENCES passenger (passengerId) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                        FOREIGN KEY (trainId) REFERENCES trains (trainId) ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE reservation add column date DATE NOT NULL;

ALTER TABLE trains add column ticketPrice DOUBLE NOT NULL;

CREATE TABLE reservation_detail(
    reservationId VARCHAR(20) NOT NULL,
    trainId VARCHAR(20) NOT NULL,
    noOfSeats VARCHAR(45) NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (reservationId),
    FOREIGN KEY (trainId) REFERENCES trains (trainId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (reservationId) REFERENCES reservation (reservationId) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO user (Email,username, password) VALUES
('Pasindu@example.com', 'U001', '1234'),
('Yapa@example.com', 'U002', '1234');

