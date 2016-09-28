-- MySQL Script generated by MySQL Workbench
-- 04/27/16 21:00:39
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema adc
-- -----------------------------------------------------
-- this is the database that receiving the adc value send from an android telephone.

-- -----------------------------------------------------
-- Table `adc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adc` (
  `adc` INT NOT NULL,
  PRIMARY KEY (`adc`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `adc`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `adc` (`adc`) VALUES (123);
INSERT INTO `adc` (`adc`) VALUES (123);
INSERT INTO `adc` (`adc`) VALUES (321);
INSERT INTO `adc` (`adc`) VALUES (1234);
INSERT INTO `adc` (`adc`) VALUES (4321);

COMMIT;

