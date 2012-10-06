SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `bd_bolsatrabajo` DEFAULT CHARACTER SET latin1 ;
USE `bd_bolsatrabajo` ;

-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`area`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`area` (
  `idAREA` INT(11) NOT NULL ,
  `descripcionArea` VARCHAR(45) NOT NULL ,
  `codArea` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idAREA`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`ofertante`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`ofertante` (
  `idOFERTANTE` INT(11) NOT NULL ,
  `codOfertante` VARCHAR(45) NOT NULL ,
  `ruc` VARCHAR(45) NOT NULL ,
  `razonSocial` VARCHAR(45) NOT NULL ,
  `correo` VARCHAR(45) NOT NULL ,
  `descEmpresa` VARCHAR(45) NOT NULL ,
  `usuarioOf` VARCHAR(45) NOT NULL ,
  `passwordOf` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idOFERTANTE`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`aviso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`aviso` (
  `idAVISO` INT(11) NOT NULL AUTO_INCREMENT ,
  `AVI_idOFERTANTE` INT(11) NOT NULL ,
  `AVI_idPUESTO_LABORAL` INT(11) NOT NULL ,
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
    REFERENCES `bd_bolsatrabajo`.`ofertante` (`idOFERTANTE` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`preferencia_salarial`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`preferencia_salarial` (
  `idPREFERENCIA_SALARIAL` INT(11) NOT NULL AUTO_INCREMENT ,
  `montoSoles` DECIMAL(10,0) NULL DEFAULT NULL ,
  `montoDolares` DECIMAL(10,0) NULL DEFAULT NULL ,
  PRIMARY KEY (`idPREFERENCIA_SALARIAL`) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`persona`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`persona` (
  `idPERSONA` INT(11) NOT NULL AUTO_INCREMENT ,
  `tipo_persona` VARCHAR(45) NULL DEFAULT NULL ,
  `nombrePersona` VARCHAR(60) NOT NULL ,
  `apellidosPersona` VARCHAR(60) NOT NULL ,
  `dni` VARCHAR(45) NOT NULL ,
  `codPersona` VARCHAR(60) NOT NULL ,
  `passwordPe` VARCHAR(60) NOT NULL ,
  `email` VARCHAR(80) NOT NULL ,
  `pais` VARCHAR(45) NOT NULL ,
  `provincia` VARCHAR(45) NOT NULL ,
  `ciudad` VARCHAR(45) NOT NULL ,
  `direccion` VARCHAR(80) NOT NULL ,
  `telefonoFijo` VARCHAR(45) NULL DEFAULT NULL ,
  `numeroCelular` VARCHAR(45) NULL DEFAULT NULL ,
  `fechaNacimiento` VARCHAR(20) NOT NULL ,
  `sexo` VARCHAR(1) NOT NULL ,
  `estadoCivil` VARCHAR(45) NOT NULL ,
  `PER_idPRESENTACION` INT(11) NOT NULL ,
  `PER_idPREFERENCIAS_SALARIALES` INT(11) NOT NULL ,
  PRIMARY KEY (`idPERSONA`, `PER_idPRESENTACION`, `PER_idPREFERENCIAS_SALARIALES`) ,
  INDEX `fk_PERSONA_PREFERENCIAS_SALARIALE1` (`PER_idPREFERENCIAS_SALARIALES` ASC) ,
  CONSTRAINT `fk_PERSONA_PREFERENCIAS_SALARIALE1`
    FOREIGN KEY (`PER_idPREFERENCIAS_SALARIALES` )
    REFERENCES `bd_bolsatrabajo`.`preferencia_salarial` (`idPREFERENCIA_SALARIAL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`aviso_persona`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`aviso_persona` (
  `AVI_PER_idAVISO` INT(11) NOT NULL ,
  `AVI_PER_idOFERTANTE` INT(11) NOT NULL ,
  `AVI_PER_idPUESTO_LABORAL` INT(11) NOT NULL ,
  `AVI_PER_idPERSONA` INT(11) NOT NULL ,
  PRIMARY KEY (`AVI_PER_idAVISO`, `AVI_PER_idOFERTANTE`, `AVI_PER_idPUESTO_LABORAL`, `AVI_PER_idPERSONA`) ,
  INDEX `fk_AVISO_has_PERSONA_PERSONA1` (`AVI_PER_idPERSONA` ASC) ,
  CONSTRAINT `fk_AVISO_has_PERSONA_AVISO1`
    FOREIGN KEY (`AVI_PER_idAVISO` , `AVI_PER_idOFERTANTE` , `AVI_PER_idPUESTO_LABORAL` )
    REFERENCES `bd_bolsatrabajo`.`aviso` (`idAVISO` , `AVI_idOFERTANTE` , `AVI_idPUESTO_LABORAL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AVISO_has_PERSONA_PERSONA1`
    FOREIGN KEY (`AVI_PER_idPERSONA` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`conocimiento_adicional`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`conocimiento_adicional` (
  `idCONOCIMIENTO_ADICIONAL` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombreConocimiento` VARCHAR(45) NULL DEFAULT NULL ,
  `descripcionConocimiento` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idCONOCIMIENTO_ADICIONAL`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`estudio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`estudio` (
  `idESTUDIO` INT(11) NOT NULL AUTO_INCREMENT ,
  `tituloEstudio` VARCHAR(45) NULL DEFAULT NULL ,
  `fechaInicio` VARCHAR(45) NULL DEFAULT NULL ,
  `fechaFin` VARCHAR(45) NULL DEFAULT NULL ,
  `descrpcioninstitucion` VARCHAR(45) NULL DEFAULT NULL ,
  `pais` VARCHAR(45) NULL DEFAULT NULL ,
  `NivelEstudio` VARCHAR(45) NULL DEFAULT NULL ,
  `estado` VARCHAR(45) NULL DEFAULT NULL ,
  `areaEstudio` VARCHAR(45) NULL DEFAULT NULL ,
  `promedio` DOUBLE NULL DEFAULT NULL ,
  `materiasAprobadas` INT(11) NULL DEFAULT NULL ,
  `cantidadMaterias` INT(11) NULL DEFAULT NULL ,
  `EST_idPERSONA` INT(11) NOT NULL ,
  PRIMARY KEY (`idESTUDIO`, `EST_idPERSONA`) ,
  INDEX `fk_ESTUDIOS_PERSONA1` (`EST_idPERSONA` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`experiencia_laboral`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`experiencia_laboral` (
  `idEXPERIENCIA_LABORAL` INT(11) NOT NULL AUTO_INCREMENT ,
  `titulo_Puesto` VARCHAR(45) NULL DEFAULT NULL ,
  `empresa` VARCHAR(45) NULL DEFAULT NULL ,
  `pais` VARCHAR(45) NULL DEFAULT NULL ,
  `fechaInicio` VARCHAR(45) NULL DEFAULT NULL ,
  `fechaFinal` VARCHAR(45) NULL DEFAULT NULL ,
  `area` VARCHAR(45) NULL DEFAULT NULL ,
  `subArea` VARCHAR(45) NULL DEFAULT NULL ,
  `descripcionResponsabilidad` VARCHAR(45) NULL DEFAULT NULL ,
  `numeroPersonasCargo` INT(11) NULL DEFAULT NULL ,
  `EX_LAB_idPERSONA` INT(11) NOT NULL ,
  PRIMARY KEY (`idEXPERIENCIA_LABORAL`, `EX_LAB_idPERSONA`) ,
  INDEX `fk_EXPERIENCIAS_LABORALES_PERSONA1` (`EX_LAB_idPERSONA` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`idioma`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`idioma` (
  `idIDIOMA` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombreIdioma` VARCHAR(45) NULL DEFAULT NULL ,
  `nivelEscrito` VARCHAR(45) NULL DEFAULT NULL ,
  `nivelOral` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idIDIOMA`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`informatica`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`informatica` (
  `idINFORMATICA` INT(11) NOT NULL AUTO_INCREMENT ,
  `tipoInformatica` VARCHAR(45) NULL DEFAULT NULL ,
  `nivelInformatica` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idINFORMATICA`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`persona_conocimiento_adicional`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`persona_conocimiento_adicional` (
  `PER_CON_AD_idPERSONA` INT(11) NOT NULL ,
  `PER_CON_AD_idCONOCIMIENTO_ADICIONAL` INT(11) NOT NULL ,
  PRIMARY KEY (`PER_CON_AD_idPERSONA`, `PER_CON_AD_idCONOCIMIENTO_ADICIONAL`) ,
  INDEX `fk_PERSONA_CONOCIMIENTO_ADICIONAL_CONOCIMIENTO_ADICIONAL1` (`PER_CON_AD_idCONOCIMIENTO_ADICIONAL` ASC) ,
  CONSTRAINT `fk_PERSONA_CONOCIMIENTO_ADICIONAL_CONOCIMIENTO_ADICIONAL1`
    FOREIGN KEY (`PER_CON_AD_idCONOCIMIENTO_ADICIONAL` )
    REFERENCES `bd_bolsatrabajo`.`conocimiento_adicional` (`idCONOCIMIENTO_ADICIONAL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PERSONA_has_CONOCIMIENTOS_ADICIONALES_PERSONA1`
    FOREIGN KEY (`PER_CON_AD_idPERSONA` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`persona_idioma`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`persona_idioma` (
  `PER_IDI_idPERSONA` INT(11) NOT NULL ,
  `PER_IDI_idIDIOMA` INT(11) NOT NULL ,
  PRIMARY KEY (`PER_IDI_idPERSONA`, `PER_IDI_idIDIOMA`) ,
  INDEX `fk_PERSONA_has_IDIOMAS_IDIOMAS1` (`PER_IDI_idIDIOMA` ASC) ,
  CONSTRAINT `fk_PERSONA_has_IDIOMAS_IDIOMAS1`
    FOREIGN KEY (`PER_IDI_idIDIOMA` )
    REFERENCES `bd_bolsatrabajo`.`idioma` (`idIDIOMA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PERSONA_has_IDIOMAS_PERSONA1`
    FOREIGN KEY (`PER_IDI_idPERSONA` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`persona_informatica`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`persona_informatica` (
  `PER_INF_idPERSONA` INT(11) NOT NULL ,
  `PER_INF_idINFORMATICA` INT(11) NOT NULL ,
  PRIMARY KEY (`PER_INF_idPERSONA`, `PER_INF_idINFORMATICA`) ,
  INDEX `fk_PERSONA_has_INFORMATICA_INFORMATICA1` (`PER_INF_idINFORMATICA` ASC) ,
  CONSTRAINT `fk_PERSONA_has_INFORMATICA_INFORMATICA1`
    FOREIGN KEY (`PER_INF_idINFORMATICA` )
    REFERENCES `bd_bolsatrabajo`.`informatica` (`idINFORMATICA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PERSONA_has_INFORMATICA_PERSONA1`
    FOREIGN KEY (`PER_INF_idPERSONA` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`presentacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`presentacion` (
  `idPRESENTACION` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion_Pres` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idPRESENTACION`) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`puesto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`puesto` (
  `idPUESTO` INT(11) NOT NULL ,
  `PU_idAREA` INT(11) NOT NULL ,
  `PU_idPERSONA` INT(11) NOT NULL ,
  `nombrePuesto` VARCHAR(45) NOT NULL ,
  `codArea` VARCHAR(45) NOT NULL ,
  `descPuesto` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idPUESTO`, `PU_idAREA`, `PU_idPERSONA`) ,
  INDEX `fk_PUESTO_AREA1` (`PU_idAREA` ASC) ,
  INDEX `fk_PUESTO_PERSONA1` (`PU_idPERSONA` ASC) ,
  CONSTRAINT `fk_PUESTO_AREA1`
    FOREIGN KEY (`PU_idAREA` )
    REFERENCES `bd_bolsatrabajo`.`area` (`idAREA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PUESTO_PERSONA1`
    FOREIGN KEY (`PU_idPERSONA` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`referencia`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`referencia` (
  `idREFERENCIA` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombreRef` VARCHAR(45) NULL DEFAULT NULL ,
  `REF_idPERSONA` INT(11) NOT NULL ,
  `apellidosRefer` VARCHAR(45) NULL DEFAULT NULL ,
  `emailRef` VARCHAR(45) NULL DEFAULT NULL ,
  `telefonoRef` VARCHAR(30) NULL DEFAULT NULL ,
  `relacionRef` VARCHAR(40) NULL DEFAULT NULL ,
  `puestoEmpresaRef` VARCHAR(40) NULL DEFAULT NULL ,
  `experienciaRelacionadaRef` VARCHAR(40) NULL DEFAULT NULL ,
  PRIMARY KEY (`idREFERENCIA`, `REF_idPERSONA`) ,
  INDEX `fk_REFERENCIAS_PERSONA1` (`REF_idPERSONA` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`rol`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`rol` (
  `idROL` INT(11) NOT NULL AUTO_INCREMENT ,
  `tipoRol` VARCHAR(45) NOT NULL ,
  `codRol` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idROL`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`seleccion_postulante`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`seleccion_postulante` (
  `idSELECCIONPOSTULANTE` INT(11) NOT NULL ,
  `SELE_POS_idAVISO` INT(11) NOT NULL ,
  `SELE_POS_idOFERTANTE` INT(11) NOT NULL ,
  `codSeleccion` VARCHAR(45) NOT NULL ,
  `codAviso` VARCHAR(45) NOT NULL ,
  `codPostulante` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idSELECCIONPOSTULANTE`, `SELE_POS_idAVISO`, `SELE_POS_idOFERTANTE`) ,
  INDEX `fk_SELECCION_POSTULANTE_AVISO1` (`SELE_POS_idAVISO` ASC, `SELE_POS_idOFERTANTE` ASC) ,
  CONSTRAINT `fk_SELECCION_POSTULANTE_AVISO1`
    FOREIGN KEY (`SELE_POS_idAVISO` , `SELE_POS_idOFERTANTE` )
    REFERENCES `bd_bolsatrabajo`.`aviso` (`idAVISO` , `AVI_idOFERTANTE` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombreUsuario` VARCHAR(45) NOT NULL ,
  `codUsuario` VARCHAR(45) NOT NULL ,
  `passwordUsuario` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idUsuario`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`usuario_rol`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`usuario_rol` (
  `USU_RO_idUsuario` INT(11) NOT NULL ,
  `USU_RO_idROL` INT(11) NOT NULL ,
  PRIMARY KEY (`USU_RO_idUsuario`, `USU_RO_idROL`) ,
  INDEX `fk_USUARIO_has_ROL_ROL1` (`USU_RO_idROL` ASC) ,
  CONSTRAINT `fk_USUARIO_has_ROL_ROL1`
    FOREIGN KEY (`USU_RO_idROL` )
    REFERENCES `bd_bolsatrabajo`.`rol` (`idROL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USUARIO_has_ROL_USUARIO1`
    FOREIGN KEY (`USU_RO_idUsuario` )
    REFERENCES `bd_bolsatrabajo`.`usuario` (`idUsuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
