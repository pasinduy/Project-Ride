-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema project_ride
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema project_ride
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `project_ride` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `project_ride` ;

-- -----------------------------------------------------
-- Table `project_ride`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_ride`.`user` (
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project_ride`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_ride`.`employee` (
  `empId` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `age` INT NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `address` VARCHAR(20) NOT NULL,
  `contact` VARCHAR(20) NOT NULL,
  `username` VARCHAR(20) NULL,
  `user_username` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`empId`, `user_username`),
  INDEX `fk_employee_user1_idx` (`user_username` ASC) VISIBLE,
  CONSTRAINT `fk_employee_user1`
    FOREIGN KEY (`user_username`)
    REFERENCES `project_ride`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project_ride`.`attendance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_ride`.`attendance` (
  `attId` VARCHAR(20) NOT NULL,
  `time` TIME NOT NULL,
  `date` DATE NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  `empId` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`attId`),
  INDEX `empId` (`empId` ASC) VISIBLE,
  CONSTRAINT `attendance_ibfk_1`
    FOREIGN KEY (`empId`)
    REFERENCES `project_ride`.`employee` (`empId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project_ride`.`trains`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_ride`.`trains` (
  `trainId` VARCHAR(20) NOT NULL,
  `type` VARCHAR(20) NULL DEFAULT NULL,
  `noOfSeats` INT NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`trainId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project_ride`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_ride`.`delivery` (
  `deliveryId` VARCHAR(20) NOT NULL,
  `trainId` VARCHAR(20) NOT NULL,
  `date` DATE NOT NULL,
  `time` TIME NOT NULL,
  `weight` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`deliveryId`),
  INDEX `trainId` (`trainId` ASC) VISIBLE,
  CONSTRAINT `delivery_ibfk_1`
    FOREIGN KEY (`trainId`)
    REFERENCES `project_ride`.`trains` (`trainId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project_ride`.`driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_ride`.`driver` (
  `driverId` VARCHAR(20) NOT NULL,
  `empId` VARCHAR(20) NOT NULL,
  `trainId` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`driverId`),
  INDEX `empId` (`empId` ASC) VISIBLE,
  INDEX `trainId` (`trainId` ASC) VISIBLE,
  CONSTRAINT `driver_ibfk_1`
    FOREIGN KEY (`empId`)
    REFERENCES `project_ride`.`employee` (`empId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `driver_ibfk_2`
    FOREIGN KEY (`trainId`)
    REFERENCES `project_ride`.`trains` (`trainId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project_ride`.`passenger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_ride`.`passenger` (
  `passengerId` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `age` INT NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `address` VARCHAR(20) NOT NULL,
  `contact` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`passengerId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project_ride`.`payroll`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_ride`.`payroll` (
  `salaryId` VARCHAR(20) NOT NULL,
  `amount` VARCHAR(20) NOT NULL,
  `date` INT NOT NULL,
  `month` INT NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  `empId` VARCHAR(20) NULL,
  `employee_empId` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`salaryId`, `employee_empId`),
  INDEX `fk_payroll_employee1_idx` (`employee_empId` ASC) VISIBLE,
  CONSTRAINT `fk_payroll_employee1`
    FOREIGN KEY (`employee_empId`)
    REFERENCES `project_ride`.`employee` (`empId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project_ride`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_ride`.`reservation` (
  `reservationId` VARCHAR(20) NOT NULL,
  `trainId` VARCHAR(20) NOT NULL,
  `passengerId` VARCHAR(20) NOT NULL,
  `noOfSeats` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`reservationId`),
  INDEX `trainId` (`trainId` ASC) VISIBLE,
  INDEX `fk_reservation_passenger1_idx` (`passengerId` ASC) VISIBLE,
  CONSTRAINT `reservation_ibfk_1`
    FOREIGN KEY (`trainId`)
    REFERENCES `project_ride`.`trains` (`trainId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_reservation_passenger1`
    FOREIGN KEY (`passengerId`)
    REFERENCES `project_ride`.`passenger` (`passengerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `project_ride`.`trainschedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_ride`.`trainschedule` (
  `scheduleId` VARCHAR(20) NOT NULL,
  `trainId` VARCHAR(20) NOT NULL,
  `fromStation` VARCHAR(20) NOT NULL,
  `toStation` VARCHAR(20) NOT NULL,
  `date` DATE NOT NULL,
  `time` TIME NOT NULL,
  `timeperiod` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`scheduleId`),
  INDEX `trainId` (`trainId` ASC) VISIBLE,
  CONSTRAINT `trainschedule_ibfk_1`
    FOREIGN KEY (`trainId`)
    REFERENCES `project_ride`.`trains` (`trainId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
