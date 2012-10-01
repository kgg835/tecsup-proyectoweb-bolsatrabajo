SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `bd_bolsatrabajo` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `bd_bolsatrabajo` ;

-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`AREA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`AREA` (
  `idAREA` INT NOT NULL ,
  `descripcionArea` VARCHAR(45) NOT NULL ,
  `codArea` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idAREA`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`PREFERENCIA_SALARIAL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`PREFERENCIA_SALARIAL` (
  `idPREFERENCIA_SALARIAL` INT NOT NULL AUTO_INCREMENT ,
  `montoSoles` DECIMAL(10,0)  NULL ,
  `montoDolares` DECIMAL(10,0)  NULL ,
  PRIMARY KEY (`idPREFERENCIA_SALARIAL`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`PERSONA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`PERSONA` (
  `idPERSONA` INT NOT NULL AUTO_INCREMENT ,
  `tipo_persona` VARCHAR(45) NULL ,
  `nombrePersona` VARCHAR(45) NOT NULL ,
  `apPellidos` VARCHAR(45) NOT NULL ,
  `dni` VARCHAR(45) NOT NULL ,
  `codPersona` VARCHAR(45) NOT NULL ,
  `passwordPe` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `pais` VARCHAR(45) NOT NULL ,
  `provincia` VARCHAR(45) NOT NULL ,
  `ciudad` VARCHAR(45) NOT NULL ,
  `direccion` VARCHAR(45) NOT NULL ,
  `telefonoFijo` VARCHAR(45) NULL ,
  `numeroCelular` VARCHAR(45) NULL ,
  `fechaNacimiento` DATE NOT NULL ,
  `sexo` CHAR NOT NULL ,
  `estadoCivil` VARCHAR(45) NOT NULL ,
  `PER_idPRESENTACION` INT NOT NULL ,
  `PER_idPREFERENCIAS_SALARIALES` INT NOT NULL ,
  PRIMARY KEY (`idPERSONA`, `PER_idPRESENTACION`, `PER_idPREFERENCIAS_SALARIALES`) ,
  INDEX `fk_PERSONA_PREFERENCIAS_SALARIALE1` (`PER_idPREFERENCIAS_SALARIALES` ASC) ,
  CONSTRAINT `fk_PERSONA_PREFERENCIAS_SALARIALE1`
    FOREIGN KEY (`PER_idPREFERENCIAS_SALARIALES` )
    REFERENCES `bd_bolsatrabajo`.`PREFERENCIA_SALARIAL` (`idPREFERENCIA_SALARIAL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`PUESTO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`PUESTO` (
  `idPUESTO` INT NOT NULL ,
  `PU_idAREA` INT NOT NULL ,
  `PU_idPERSONA` INT NOT NULL ,
  `nombrePuesto` VARCHAR(45) NOT NULL ,
  `codArea` VARCHAR(45) NOT NULL ,
  `descPuesto` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idPUESTO`, `PU_idAREA`, `PU_idPERSONA`) ,
  INDEX `fk_PUESTO_AREA1` (`PU_idAREA` ASC) ,
  INDEX `fk_PUESTO_PERSONA1` (`PU_idPERSONA` ASC) ,
  CONSTRAINT `fk_PUESTO_AREA1`
    FOREIGN KEY (`PU_idAREA` )
    REFERENCES `bd_bolsatrabajo`.`AREA` (`idAREA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PUESTO_PERSONA1`
    FOREIGN KEY (`PU_idPERSONA` )
    REFERENCES `bd_bolsatrabajo`.`PERSONA` (`idPERSONA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`OFERTANTE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`OFERTANTE` (
  `idOFERTANTE` INT NOT NULL ,
  `codOfertante` VARCHAR(45) NOT NULL ,
  `ruc` VARCHAR(45) NOT NULL ,
  `razonSocial` VARCHAR(45) NOT NULL ,
  `correo` VARCHAR(45) NOT NULL ,
  `descEmpresa` VARCHAR(45) NOT NULL ,
  `usuarioOf` VARCHAR(45) NOT NULL ,
  `passwordOf` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idOFERTANTE`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`AVISO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`AVISO` (
  `idAVISO` INT NOT NULL AUTO_INCREMENT ,
  `AVI_idOFERTANTE` INT NOT NULL ,
  `AVI_idPUESTO_LABORAL` INT NOT NULL ,
  `tituloAviso` VARCHAR(45) NOT NULL ,
  `codAviso` VARCHAR(45) NOT NULL ,
  `fechaPublicacion` DATE NOT NULL ,
  `fechacaducidad` DATE NOT NULL ,
  `codOfertante` VARCHAR(45) NOT NULL ,
  `codArea` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idAVISO`, `AVI_idOFERTANTE`, `AVI_idPUESTO_LABORAL`) ,
  INDEX `fk_AVISO_OFERTANTE1` (`AVI_idOFERTANTE` ASC) ,
  CONSTRAINT `fk_AVISO_OFERTANTE1`
    FOREIGN KEY (`AVI_idOFERTANTE` )
    REFERENCES `bd_bolsatrabajo`.`OFERTANTE` (`idOFERTANTE` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`SELECCION_POSTULANTE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`SELECCION_POSTULANTE` (
  `idSELECCIONPOSTULANTE` INT NOT NULL ,
  `SELE_POS_idAVISO` INT NOT NULL ,
  `SELE_POS_idOFERTANTE` INT NOT NULL ,
  `codSeleccion` VARCHAR(45) NOT NULL ,
  `codAviso` VARCHAR(45) NOT NULL ,
  `codPostulante` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idSELECCIONPOSTULANTE`, `SELE_POS_idAVISO`, `SELE_POS_idOFERTANTE`) ,
  INDEX `fk_SELECCION_POSTULANTE_AVISO1` (`SELE_POS_idAVISO` ASC, `SELE_POS_idOFERTANTE` ASC) ,
  CONSTRAINT `fk_SELECCION_POSTULANTE_AVISO1`
    FOREIGN KEY (`SELE_POS_idAVISO` , `SELE_POS_idOFERTANTE` )
    REFERENCES `bd_bolsatrabajo`.`AVISO` (`idAVISO` , `AVI_idOFERTANTE` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`AVISO_PERSONA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`AVISO_PERSONA` (
  `AVI_PER_idAVISO` INT NOT NULL ,
  `AVI_PER_idOFERTANTE` INT NOT NULL ,
  `AVI_PER_idPUESTO_LABORAL` INT NOT NULL ,
  `AVI_PER_idPERSONA` INT NOT NULL ,
  PRIMARY KEY (`AVI_PER_idAVISO`, `AVI_PER_idOFERTANTE`, `AVI_PER_idPUESTO_LABORAL`, `AVI_PER_idPERSONA`) ,
  INDEX `fk_AVISO_has_PERSONA_PERSONA1` (`AVI_PER_idPERSONA` ASC) ,
  CONSTRAINT `fk_AVISO_has_PERSONA_AVISO1`
    FOREIGN KEY (`AVI_PER_idAVISO` , `AVI_PER_idOFERTANTE` , `AVI_PER_idPUESTO_LABORAL` )
    REFERENCES `bd_bolsatrabajo`.`AVISO` (`idAVISO` , `AVI_idOFERTANTE` , `AVI_idPUESTO_LABORAL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AVISO_has_PERSONA_PERSONA1`
    FOREIGN KEY (`AVI_PER_idPERSONA` )
    REFERENCES `bd_bolsatrabajo`.`PERSONA` (`idPERSONA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`USUARIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`USUARIO` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT ,
  `nombreUsuario` VARCHAR(45) NOT NULL ,
  `codUsuario` VARCHAR(45) NOT NULL ,
  `passwordUsuario` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idUsuario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`ROL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`ROL` (
  `idROL` INT NOT NULL AUTO_INCREMENT ,
  `tipoRol` VARCHAR(45) NOT NULL ,
  `codRol` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idROL`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`USUARIO_ROL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`USUARIO_ROL` (
  `USU_RO_idUsuario` INT NOT NULL ,
  `USU_RO_idROL` INT NOT NULL ,
  PRIMARY KEY (`USU_RO_idUsuario`, `USU_RO_idROL`) ,
  INDEX `fk_USUARIO_has_ROL_ROL1` (`USU_RO_idROL` ASC) ,
  CONSTRAINT `fk_USUARIO_has_ROL_USUARIO1`
    FOREIGN KEY (`USU_RO_idUsuario` )
    REFERENCES `bd_bolsatrabajo`.`USUARIO` (`idUsuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USUARIO_has_ROL_ROL1`
    FOREIGN KEY (`USU_RO_idROL` )
    REFERENCES `bd_bolsatrabajo`.`ROL` (`idROL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`ESTUDIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`ESTUDIO` (
  `idESTUDIO` INT NOT NULL AUTO_INCREMENT ,
  `tituloEstudio` VARCHAR(45) NULL ,
  `fechaInicio` VARCHAR(45) NULL ,
  `fechaFin` VARCHAR(45) NULL ,
  `descrpcioninstitucion` VARCHAR(45) NULL ,
  `pais` VARCHAR(45) NULL ,
  `NivelEstudio` VARCHAR(45) NULL ,
  `estado` VARCHAR(45) NULL ,
  `areaEstudio` VARCHAR(45) NULL ,
  `promedio` DOUBLE NULL ,
  `materiasAprobadas` INT NULL ,
  `cantidadMaterias` INT NULL ,
  `EST_idPERSONA` INT NOT NULL ,
  `EST_idPRESENTACION` INT NOT NULL ,
  PRIMARY KEY (`idESTUDIO`, `EST_idPERSONA`, `EST_idPRESENTACION`) ,
  INDEX `fk_ESTUDIOS_PERSONA1` (`EST_idPERSONA` ASC, `EST_idPRESENTACION` ASC) ,
  CONSTRAINT `fk_ESTUDIOS_PERSONA1`
    FOREIGN KEY (`EST_idPERSONA` , `EST_idPRESENTACION` )
    REFERENCES `bd_bolsatrabajo`.`PERSONA` (`idPERSONA` , `PER_idPRESENTACION` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`IDIOMA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`IDIOMA` (
  `idIDIOMA` INT NOT NULL AUTO_INCREMENT ,
  `nombreIdioma` VARCHAR(45) NULL ,
  `nivelEscrito` VARCHAR(45) NULL ,
  `nivelOral` VARCHAR(45) NULL ,
  PRIMARY KEY (`idIDIOMA`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`INFORMATICA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`INFORMATICA` (
  `idINFORMATICA` INT NOT NULL AUTO_INCREMENT ,
  `tipoInformatica` VARCHAR(45) NULL ,
  `nivelInformatica` VARCHAR(45) NULL ,
  PRIMARY KEY (`idINFORMATICA`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`CONOCIMIENTO_ADICIONAL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`CONOCIMIENTO_ADICIONAL` (
  `idCONOCIMIENTO_ADICIONAL` INT NOT NULL AUTO_INCREMENT ,
  `nombreConocimiento` VARCHAR(45) NULL ,
  `descripcionConocimiento` VARCHAR(45) NULL ,
  PRIMARY KEY (`idCONOCIMIENTO_ADICIONAL`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`REFERENCIA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`REFERENCIA` (
  `idREFERENCIA` INT NOT NULL AUTO_INCREMENT ,
  `descrpcionRef` VARCHAR(45) NULL ,
  `REF_idPERSONA` INT NOT NULL ,
  `REF_idPRESENTACION` INT NOT NULL ,
  PRIMARY KEY (`idREFERENCIA`, `REF_idPERSONA`, `REF_idPRESENTACION`) ,
  INDEX `fk_REFERENCIAS_PERSONA1` (`REF_idPERSONA` ASC, `REF_idPRESENTACION` ASC) ,
  CONSTRAINT `fk_REFERENCIAS_PERSONA1`
    FOREIGN KEY (`REF_idPERSONA` , `REF_idPRESENTACION` )
    REFERENCES `bd_bolsatrabajo`.`PERSONA` (`idPERSONA` , `PER_idPRESENTACION` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`PRESENTACION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`PRESENTACION` (
  `idPRESENTACION` INT NULL AUTO_INCREMENT ,
  `descripcion_Pres` VARCHAR(45) NULL ,
  `PRE_idPERSONA` INT NOT NULL ,
  `PRE_idPRESENTACION` INT NOT NULL ,
  PRIMARY KEY (`idPRESENTACION`, `PRE_idPERSONA`, `PRE_idPRESENTACION`) ,
  INDEX `fk_PRESENTACION_PERSONA1` (`PRE_idPERSONA` ASC, `PRE_idPRESENTACION` ASC) ,
  CONSTRAINT `fk_PRESENTACION_PERSONA1`
    FOREIGN KEY (`PRE_idPERSONA` , `PRE_idPRESENTACION` )
    REFERENCES `bd_bolsatrabajo`.`PERSONA` (`idPERSONA` , `PER_idPRESENTACION` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`PERSONA_IDIOMA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`PERSONA_IDIOMA` (
  `PER_IDI_idPERSONA` INT NOT NULL ,
  `PER_IDI_idIDIOMA` INT NOT NULL ,
  PRIMARY KEY (`PER_IDI_idPERSONA`, `PER_IDI_idIDIOMA`) ,
  INDEX `fk_PERSONA_has_IDIOMAS_IDIOMAS1` (`PER_IDI_idIDIOMA` ASC) ,
  CONSTRAINT `fk_PERSONA_has_IDIOMAS_PERSONA1`
    FOREIGN KEY (`PER_IDI_idPERSONA` )
    REFERENCES `bd_bolsatrabajo`.`PERSONA` (`idPERSONA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PERSONA_has_IDIOMAS_IDIOMAS1`
    FOREIGN KEY (`PER_IDI_idIDIOMA` )
    REFERENCES `bd_bolsatrabajo`.`IDIOMA` (`idIDIOMA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`PERSONA_INFORMATICA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`PERSONA_INFORMATICA` (
  `PER_INF_idPERSONA` INT NOT NULL ,
  `PER_INF_idINFORMATICA` INT NOT NULL ,
  PRIMARY KEY (`PER_INF_idPERSONA`, `PER_INF_idINFORMATICA`) ,
  INDEX `fk_PERSONA_has_INFORMATICA_INFORMATICA1` (`PER_INF_idINFORMATICA` ASC) ,
  CONSTRAINT `fk_PERSONA_has_INFORMATICA_PERSONA1`
    FOREIGN KEY (`PER_INF_idPERSONA` )
    REFERENCES `bd_bolsatrabajo`.`PERSONA` (`idPERSONA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PERSONA_has_INFORMATICA_INFORMATICA1`
    FOREIGN KEY (`PER_INF_idINFORMATICA` )
    REFERENCES `bd_bolsatrabajo`.`INFORMATICA` (`idINFORMATICA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`PERSONA_CONOCIMIENTO_ADICIONAL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`PERSONA_CONOCIMIENTO_ADICIONAL` (
  `PER_CON_AD_idPERSONA` INT NOT NULL ,
  `PER_CON_AD_idCONOCIMIENTO_ADICIONAL` INT NOT NULL ,
  PRIMARY KEY (`PER_CON_AD_idPERSONA`, `PER_CON_AD_idCONOCIMIENTO_ADICIONAL`) ,
  INDEX `fk_PERSONA_CONOCIMIENTO_ADICIONAL_CONOCIMIENTO_ADICIONAL1` (`PER_CON_AD_idCONOCIMIENTO_ADICIONAL` ASC) ,
  CONSTRAINT `fk_PERSONA_has_CONOCIMIENTOS_ADICIONALES_PERSONA1`
    FOREIGN KEY (`PER_CON_AD_idPERSONA` )
    REFERENCES `bd_bolsatrabajo`.`PERSONA` (`idPERSONA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PERSONA_CONOCIMIENTO_ADICIONAL_CONOCIMIENTO_ADICIONAL1`
    FOREIGN KEY (`PER_CON_AD_idCONOCIMIENTO_ADICIONAL` )
    REFERENCES `bd_bolsatrabajo`.`CONOCIMIENTO_ADICIONAL` (`idCONOCIMIENTO_ADICIONAL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`EXPERIENCIA_LABORAL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`EXPERIENCIA_LABORAL` (
  `idEXPERIENCIA_LABORAL` INT NOT NULL AUTO_INCREMENT ,
  `titulo_Puesto` VARCHAR(45) NULL ,
  `empresa` VARCHAR(45) NULL ,
  `pais` VARCHAR(45) NULL ,
  `fechaInicio` VARCHAR(45) NULL ,
  `fechaFinal` VARCHAR(45) NULL ,
  `area` VARCHAR(45) NULL ,
  `subArea` VARCHAR(45) NULL ,
  `descripcionResponsabilidad` VARCHAR(45) NULL ,
  `numeroPersonasCargo` INT NULL ,
  `EX_LAB_idPERSONA` INT NOT NULL ,
  `EX_LAB_idPRESENTACION` INT NOT NULL ,
  PRIMARY KEY (`idEXPERIENCIA_LABORAL`, `EX_LAB_idPERSONA`, `EX_LAB_idPRESENTACION`) ,
  INDEX `fk_EXPERIENCIAS_LABORALES_PERSONA1` (`EX_LAB_idPERSONA` ASC, `EX_LAB_idPRESENTACION` ASC) ,
  CONSTRAINT `fk_EXPERIENCIAS_LABORALES_PERSONA1`
    FOREIGN KEY (`EX_LAB_idPERSONA` , `EX_LAB_idPRESENTACION` )
    REFERENCES `bd_bolsatrabajo`.`PERSONA` (`idPERSONA` , `PER_idPRESENTACION` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
