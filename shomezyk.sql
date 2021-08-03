-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SHome
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SHome
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SHome` DEFAULT CHARACTER SET utf8 ;
USE `SHome` ;

-- -----------------------------------------------------
-- Table `SHome`.`family`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SHome`.`family` (
  `fID` VARCHAR(45) NOT NULL,
  `fName` VARCHAR(45) NULL,
  `isDelete` INT NOT NULL,
  PRIMARY KEY (`fID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SHome`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SHome`.`user` (
  `uID` VARCHAR(45) NOT NULL,
  `uName` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `isDelete` INT NOT NULL,
  `family_fID` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`uID`),
  INDEX `fk_user_family1_idx` (`family_fID` ASC) VISIBLE,
  CONSTRAINT `fk_user_family1`
    FOREIGN KEY (`family_fID`)
    REFERENCES `SHome`.`family` (`fID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SHome`.`administrator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SHome`.`administrator` (
  `aID` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(45) NULL,
  `isDelete` INT NOT NULL,
  PRIMARY KEY (`aID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SHome`.`manufacturer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SHome`.`manufacturer` (
  `mID` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(45) NULL,
  `mName` VARCHAR(45) NULL,
  `isDelete` INT NOT NULL,
  `manufacturercol` VARCHAR(45) NULL,
  PRIMARY KEY (`mID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SHome`.`class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SHome`.`class` (
  `cID` VARCHAR(45) NOT NULL,
  `cName` VARCHAR(45) NULL,
  `isDelete` INT NOT NULL,
  PRIMARY KEY (`cID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SHome`.`equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SHome`.`equipment` (
  `eId` VARCHAR(45) NOT NULL,
  `instruction` VARCHAR(45) NULL,
  `ename` VARCHAR(45) NULL,
  `isDelete` INT NOT NULL,
  `family_fID` VARCHAR(45) NULL,
  `class_cID` VARCHAR(45) NULL,
  `manufacturer_mID` VARCHAR(45) NULL,
  PRIMARY KEY (`eId`),
  INDEX `fk_equipment_family1_idx` (`family_fID` ASC) VISIBLE,
  INDEX `fk_equipment_class1_idx` (`class_cID` ASC) VISIBLE,
  INDEX `fk_equipment_manufacturer1_idx` (`manufacturer_mID` ASC) VISIBLE,
  CONSTRAINT `fk_equipment_family1`
    FOREIGN KEY (`family_fID`)
    REFERENCES `SHome`.`family` (`fID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipment_class1`
    FOREIGN KEY (`class_cID`)
    REFERENCES `SHome`.`class` (`cID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipment_manufacturer1`
    FOREIGN KEY (`manufacturer_mID`)
    REFERENCES `SHome`.`manufacturer` (`mID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SHome`.`data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SHome`.`data` (
  `dID` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NULL,
  `humidity` VARCHAR(45) NULL,
  `temperature` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `brightness` VARCHAR(45) NULL,
  `time` DATETIME NULL,
  `equipment_eId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dID`),
  INDEX `fk_data_equipment1_idx` (`equipment_eId` ASC) VISIBLE,
  CONSTRAINT `fk_data_equipment1`
    FOREIGN KEY (`equipment_eId`)
    REFERENCES `SHome`.`equipment` (`eId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `SHome`.`family`
-- -----------------------------------------------------
START TRANSACTION;
USE `SHome`;
INSERT INTO `SHome`.`family` (`fID`, `fName`, `isDelete`) VALUES ('f1', 'ff1', 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `SHome`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `SHome`;
INSERT INTO `SHome`.`user` (`uID`, `uName`, `pwd`, `email`, `phone`, `address`, `gender`, `isDelete`, `family_fID`) VALUES ('u1', '777', '666', '555', '444', '333', '222', 0, 'f1');

COMMIT;


-- -----------------------------------------------------
-- Data for table `SHome`.`administrator`
-- -----------------------------------------------------
START TRANSACTION;
USE `SHome`;
INSERT INTO `SHome`.`administrator` (`aID`, `pwd`, `isDelete`) VALUES ('a1', NULL, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `SHome`.`manufacturer`
-- -----------------------------------------------------
START TRANSACTION;
USE `SHome`;
INSERT INTO `SHome`.`manufacturer` (`mID`, `pwd`, `mName`, `isDelete`, `manufacturercol`) VALUES ('m1', NULL, NULL, 0, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `SHome`.`class`
-- -----------------------------------------------------
START TRANSACTION;
USE `SHome`;
INSERT INTO `SHome`.`class` (`cID`, `cName`, `isDelete`) VALUES ('c1', NULL, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `SHome`.`equipment`
-- -----------------------------------------------------
START TRANSACTION;
USE `SHome`;
INSERT INTO `SHome`.`equipment` (`eId`, `instruction`, `ename`, `isDelete`, `family_fID`, `class_cID`, `manufacturer_mID`) VALUES ('e1', NULL, NULL, 0, 'f1', 'c1', 'm1');

COMMIT;


-- -----------------------------------------------------
-- Data for table `SHome`.`data`
-- -----------------------------------------------------
START TRANSACTION;
USE `SHome`;
INSERT INTO `SHome`.`data` (`dID`, `type`, `humidity`, `temperature`, `state`, `brightness`, `time`, `equipment_eId`) VALUES ('d1', NULL, NULL, NULL, NULL, NULL, NULL, 'e1');

COMMIT;

