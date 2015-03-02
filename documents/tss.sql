SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `tss` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `tss` ;

-- -----------------------------------------------------
-- Table `tss`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tss`.`user` (
  `username` VARCHAR(255) NOT NULL COMMENT '	',
  `password` VARCHAR(255) NOT NULL,
  `realName` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `gender` INT NULL,
  `role` INT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tss`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tss`.`student` (
  `studentName` VARCHAR(255) NOT NULL,
  `grade` VARCHAR(255) NULL,
  PRIMARY KEY (`studentName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tss`.`teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tss`.`teacher` (
  `teacherName` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`teacherName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tss`.`teachingAssistant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tss`.`teachingAssistant` (
  `id` VARCHAR(255) NOT NULL,
  `teachingAssistantName` VARCHAR(255) NOT NULL,
  `courseId` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tss`.`teachingManager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tss`.`teachingManager` (
  `teachingManagerName` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`teachingManagerName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tss`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tss`.`course` (
  `courseId` VARCHAR(255) NULL,
  `courseName` VARCHAR(255) NULL,
  `description` TEXT NULL,
  `semester` VARCHAR(255) NULL,
  `teacherName` VARCHAR(255) NULL,
  `initializationDeadline` DATETIME NULL,
  PRIMARY KEY (`courseId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tss`.`studentCourseSelection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tss`.`studentCourseSelection` (
  `id` INT NOT NULL COMMENT '	',
  `courseId` VARCHAR(255) NOT NULL,
  `studentName` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tss`.`teacherCourseSelection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tss`.`teacherCourseSelection` (
  `id` INT NOT NULL,
  `courseId` VARCHAR(255) NOT NULL,
  `teacherName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tss`.`assignment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tss`.`assignment` (
  `number` INT NULL,
  `description` TEXT NULL,
  `submissionDeadline` DATETIME NULL,
  `gradeDeadline` DATETIME NULL,
  `format` VARCHAR(255) NULL,
  `score` INT NULL,
  `level` VARCHAR(255) NULL,
  `sample` VARCHAR(255) NULL,
  `generalGrade` TEXT NULL,
  `assignmentId` INT NOT NULL,
  `courseId` VARCHAR(255) NULL,
  PRIMARY KEY (`assignmentId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tss`.`studentSubmission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tss`.`studentSubmission` (
  `id` INT NOT NULL,
  `assignmentId` INT NULL,
  `submission` VARCHAR(255) NULL,
  `submitDate` DATETIME NULL,
  `grader` VARCHAR(255) NULL,
  `grade` INT NULL,
  `evaluation` TEXT NULL,
  `isGraded` INT NULL,
  `isPassed` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
