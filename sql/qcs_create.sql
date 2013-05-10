SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `QCS` ;
CREATE SCHEMA IF NOT EXISTS `QCS` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `QCS` ;

-- -----------------------------------------------------
-- Table `QCS`.`user_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCS`.`user_info` ;

CREATE  TABLE IF NOT EXISTS `QCS`.`user_info` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NULL COMMENT '用户名' ,
  `password` VARCHAR(32) NULL COMMENT '密码' ,
  `state` VARCHAR(2) NULL COMMENT '状态\n0：正常\n1：冻结' ,
  `type` VARCHAR(2) NULL COMMENT '类型\n0：教师\n1：学生\n2：管理员' ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCS`.`teacher_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCS`.`teacher_info` ;

CREATE  TABLE IF NOT EXISTS `QCS`.`teacher_info` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NOT NULL ,
  `teacher_no` VARCHAR(45) NULL COMMENT '教工号' ,
  `email` VARCHAR(50) NULL COMMENT '邮箱' ,
  `name` VARCHAR(45) NULL COMMENT '姓名' ,
  `gender` VARCHAR(2) NULL COMMENT '性别\n0：女\n1：男' ,
  `birth_date` VARCHAR(20) NULL COMMENT '出生日期' ,
  `department` VARCHAR(50) NULL COMMENT '部门(院校)' ,
  `education` VARCHAR(20) NULL COMMENT '学历' ,
  `degree` VARCHAR(20) NULL COMMENT '学位' ,
  `job` VARCHAR(50) NULL COMMENT '职务' ,
  `job_title` VARCHAR(50) NULL COMMENT '职称' ,
  `major` VARCHAR(50) NULL COMMENT '专业' ,
  `graduated` VARCHAR(50) NULL COMMENT '毕业院校' ,
  `teacher_cert` VARCHAR(2) NULL COMMENT '教师资格' ,
  `remark` VARCHAR(50) NULL COMMENT '备注' ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_teacher_info_user_info1_idx` (`user_id` ASC) ,
  UNIQUE INDEX `teacher_no_UNIQUE` (`teacher_no` ASC) ,
  CONSTRAINT `fk_teacher_info_user_info1`
    FOREIGN KEY (`user_id` )
    REFERENCES `QCS`.`user_info` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCS`.`question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCS`.`question` ;

CREATE  TABLE IF NOT EXISTS `QCS`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `teacher_id` INT NOT NULL COMMENT '出题教师id' ,
  `title` VARCHAR(100) NULL ,
  `content` VARCHAR(500) NULL ,
  `remark` VARCHAR(100) NULL ,
  `state` VARCHAR(45) NULL COMMENT '状态\n0：审核中\n1：通过\n2：不通过' ,
  `live` TINYINT(1) NOT NULL DEFAULT true COMMENT '是否存活（未被选中）' ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_question_teacher_info_idx` (`teacher_id` ASC) ,
  CONSTRAINT `fk_question_teacher_info`
    FOREIGN KEY (`teacher_id` )
    REFERENCES `QCS`.`teacher_info` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCS`.`job`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCS`.`job` ;

CREATE  TABLE IF NOT EXISTS `QCS`.`job` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `job` VARCHAR(45) NULL COMMENT '职务\n当与教室表的job字段匹配时候\n教师可以出题并且有数量限制' ,
  `question_num` INT NULL COMMENT '出题数量' ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `job_UNIQUE` (`job` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCS`.`student_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCS`.`student_info` ;

CREATE  TABLE IF NOT EXISTS `QCS`.`student_info` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NOT NULL ,
  `student_no` VARCHAR(45) NULL COMMENT '学号' ,
  `email` VARCHAR(50) NULL COMMENT '邮箱' ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_student_info_user_info2_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_student_info_user_info2`
    FOREIGN KEY (`user_id` )
    REFERENCES `QCS`.`user_info` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCS`.`student_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCS`.`student_info` ;

CREATE  TABLE IF NOT EXISTS `QCS`.`student_info` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NOT NULL ,
  `student_no` VARCHAR(45) NULL COMMENT '学号' ,
  `email` VARCHAR(50) NULL COMMENT '邮箱' ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_student_info_user_info2_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_student_info_user_info2`
    FOREIGN KEY (`user_id` )
    REFERENCES `QCS`.`user_info` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCS`.`student_question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCS`.`student_question` ;

CREATE  TABLE IF NOT EXISTS `QCS`.`student_question` (
  `question_id` INT NOT NULL ,
  `student_id` INT NOT NULL ,
  INDEX `fk_student_question_question1_idx` (`question_id` ASC) ,
  INDEX `fk_student_question_student_info1_idx` (`student_id` ASC) ,
  PRIMARY KEY (`question_id`, `student_id`) ,
  CONSTRAINT `fk_student_question_question1`
    FOREIGN KEY (`question_id` )
    REFERENCES `QCS`.`question` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_question_student_info1`
    FOREIGN KEY (`student_id` )
    REFERENCES `QCS`.`student_info` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QCS`.`menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `QCS`.`menu` ;

CREATE  TABLE IF NOT EXISTS `QCS`.`menu` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `parent_id` VARCHAR(5) NULL COMMENT '父菜单id' ,
  `seq` VARCHAR(10) NULL COMMENT '排序序列' ,
  `title` VARCHAR(45) NULL COMMENT '标题' ,
  `uri` VARCHAR(100) NULL COMMENT 'uri\n' ,
  `type` VARCHAR(2) NULL COMMENT '类型\n0：教师\n1：学生\n2：管理员' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

USE `QCS` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
