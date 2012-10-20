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
-- Table `bd_bolsatrabajo`.`rol`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`rol` (
  `idROL` INT(11) NOT NULL AUTO_INCREMENT ,
  `tipoRol` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idROL`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombreUsuario` VARCHAR(45) NOT NULL ,
  `passwordUsuario` VARCHAR(45) NOT NULL ,
  `idROL` INT(11) NOT NULL ,
  PRIMARY KEY (`idUsuario`) ,
  INDEX `fk_usuario_rol1` (`idROL` ASC) ,
  CONSTRAINT `fk_usuario_rol1`
    FOREIGN KEY (`idROL` )
    REFERENCES `bd_bolsatrabajo`.`rol` (`idROL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`ofertante`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`ofertante` (
  `idOFERTANTE` INT(11) NOT NULL AUTO_INCREMENT ,
  `ruc` VARCHAR(45) NOT NULL ,
  `razonSocial` VARCHAR(45) NOT NULL ,
  `correo` VARCHAR(45) NOT NULL ,
  `descEmpresa` VARCHAR(45) NOT NULL ,
  `usuarioOf` VARCHAR(45) NOT NULL ,
  `idUsuario` INT(11) NOT NULL ,
  PRIMARY KEY (`idOFERTANTE`) ,
  INDEX `fk_ofertante_usuario1` (`idUsuario` ASC) ,
  CONSTRAINT `fk_ofertante_usuario1`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `bd_bolsatrabajo`.`usuario` (`idUsuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `ofertante_idOFERTANTE` INT(11) NOT NULL ,
  PRIMARY KEY (`idAVISO`, `AVI_idOFERTANTE`, `AVI_idPUESTO_LABORAL`) ,
  INDEX `fk_aviso_ofertante1` (`ofertante_idOFERTANTE` ASC) ,
  CONSTRAINT `fk_aviso_ofertante1`
    FOREIGN KEY (`ofertante_idOFERTANTE` )
    REFERENCES `bd_bolsatrabajo`.`ofertante` (`idOFERTANTE` )
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
  `idUsuario` INT(11) NOT NULL ,
  `presentacion_idPRESENTACION` INT(11) NOT NULL ,
  `preferencia_salarial_idPREFERENCIA_SALARIAL` INT(11) NOT NULL ,
  PRIMARY KEY (`idPERSONA`, `PER_idPRESENTACION`, `PER_idPREFERENCIAS_SALARIALES`) ,
  INDEX `fk_persona_usuario1` (`idUsuario` ASC) ,
  INDEX `fk_persona_presentacion1` (`presentacion_idPRESENTACION` ASC) ,
  INDEX `fk_persona_preferencia_salarial1` (`preferencia_salarial_idPREFERENCIA_SALARIAL` ASC) ,
  CONSTRAINT `fk_persona_usuario1`
    FOREIGN KEY (`idUsuario` )
    REFERENCES `bd_bolsatrabajo`.`usuario` (`idUsuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_persona_presentacion1`
    FOREIGN KEY (`presentacion_idPRESENTACION` )
    REFERENCES `bd_bolsatrabajo`.`presentacion` (`idPRESENTACION` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_persona_preferencia_salarial1`
    FOREIGN KEY (`preferencia_salarial_idPREFERENCIA_SALARIAL` )
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
  `AVI_PER_idPERSONA` INT(11) NOT NULL ,
  `aviso_idAVISO` INT(11) NOT NULL ,
  `aviso_AVI_idOFERTANTE` INT(11) NOT NULL ,
  `aviso_AVI_idPUESTO_LABORAL` INT(11) NOT NULL ,
  INDEX `fk_AVISO_has_PERSONA_PERSONA1` (`AVI_PER_idPERSONA` ASC) ,
  INDEX `fk_aviso_persona_aviso1` (`aviso_idAVISO` ASC, `aviso_AVI_idOFERTANTE` ASC, `aviso_AVI_idPUESTO_LABORAL` ASC) ,
  CONSTRAINT `fk_AVISO_has_PERSONA_PERSONA1`
    FOREIGN KEY (`AVI_PER_idPERSONA` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aviso_persona_aviso1`
    FOREIGN KEY (`aviso_idAVISO` , `aviso_AVI_idOFERTANTE` , `aviso_AVI_idPUESTO_LABORAL` )
    REFERENCES `bd_bolsatrabajo`.`aviso` (`idAVISO` , `AVI_idOFERTANTE` , `AVI_idPUESTO_LABORAL` )
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
  `persona_idPERSONA` INT(11) NOT NULL ,
  `persona_PER_idPRESENTACION` INT(11) NOT NULL ,
  `persona_PER_idPREFERENCIAS_SALARIALES` INT(11) NOT NULL ,
  PRIMARY KEY (`idCONOCIMIENTO_ADICIONAL`) ,
  INDEX `fk_conocimiento_adicional_persona1` (`persona_idPERSONA` ASC, `persona_PER_idPRESENTACION` ASC, `persona_PER_idPREFERENCIAS_SALARIALES` ASC) ,
  CONSTRAINT `fk_conocimiento_adicional_persona1`
    FOREIGN KEY (`persona_idPERSONA` , `persona_PER_idPRESENTACION` , `persona_PER_idPREFERENCIAS_SALARIALES` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` , `PER_idPRESENTACION` , `PER_idPREFERENCIAS_SALARIALES` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `persona_idPERSONA` INT(11) NOT NULL ,
  `persona_PER_idPRESENTACION` INT(11) NOT NULL ,
  `persona_PER_idPREFERENCIAS_SALARIALES` INT(11) NOT NULL ,
  PRIMARY KEY (`idESTUDIO`, `EST_idPERSONA`) ,
  INDEX `fk_ESTUDIOS_PERSONA1` (`EST_idPERSONA` ASC) ,
  INDEX `fk_estudio_persona1` (`persona_idPERSONA` ASC, `persona_PER_idPRESENTACION` ASC, `persona_PER_idPREFERENCIAS_SALARIALES` ASC) ,
  CONSTRAINT `fk_estudio_persona1`
    FOREIGN KEY (`persona_idPERSONA` , `persona_PER_idPRESENTACION` , `persona_PER_idPREFERENCIAS_SALARIALES` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` , `PER_idPRESENTACION` , `PER_idPREFERENCIAS_SALARIALES` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `persona_idPERSONA` INT(11) NOT NULL ,
  `persona_PER_idPRESENTACION` INT(11) NOT NULL ,
  `persona_PER_idPREFERENCIAS_SALARIALES` INT(11) NOT NULL ,
  PRIMARY KEY (`idEXPERIENCIA_LABORAL`, `EX_LAB_idPERSONA`) ,
  INDEX `fk_EXPERIENCIAS_LABORALES_PERSONA1` (`EX_LAB_idPERSONA` ASC) ,
  INDEX `fk_experiencia_laboral_persona1` (`persona_idPERSONA` ASC, `persona_PER_idPRESENTACION` ASC, `persona_PER_idPREFERENCIAS_SALARIALES` ASC) ,
  CONSTRAINT `fk_experiencia_laboral_persona1`
    FOREIGN KEY (`persona_idPERSONA` , `persona_PER_idPRESENTACION` , `persona_PER_idPREFERENCIAS_SALARIALES` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` , `PER_idPRESENTACION` , `PER_idPREFERENCIAS_SALARIALES` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Table `bd_bolsatrabajo`.`persona_idioma`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`persona_idioma` (
  `persona_idPERSONA` INT(11) NOT NULL ,
  `persona_PER_idPRESENTACION` INT(11) NOT NULL ,
  `persona_PER_idPREFERENCIAS_SALARIALES` INT(11) NOT NULL ,
  `idioma_idIDIOMA` INT(11) NOT NULL ,
  INDEX `fk_persona_idioma_persona1` (`persona_idPERSONA` ASC, `persona_PER_idPRESENTACION` ASC, `persona_PER_idPREFERENCIAS_SALARIALES` ASC) ,
  INDEX `fk_persona_idioma_idioma1` (`idioma_idIDIOMA` ASC) ,
  CONSTRAINT `fk_persona_idioma_persona1`
    FOREIGN KEY (`persona_idPERSONA` , `persona_PER_idPRESENTACION` , `persona_PER_idPREFERENCIAS_SALARIALES` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` , `PER_idPRESENTACION` , `PER_idPREFERENCIAS_SALARIALES` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_persona_idioma_idioma1`
    FOREIGN KEY (`idioma_idIDIOMA` )
    REFERENCES `bd_bolsatrabajo`.`idioma` (`idIDIOMA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`persona_informatica`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`persona_informatica` (
  `informatica_idINFORMATICA` INT(11) NOT NULL ,
  `persona_idPERSONA` INT(11) NOT NULL ,
  `persona_PER_idPRESENTACION` INT(11) NOT NULL ,
  `persona_PER_idPREFERENCIAS_SALARIALES` INT(11) NOT NULL ,
  INDEX `fk_persona_informatica_informatica1` (`informatica_idINFORMATICA` ASC) ,
  INDEX `fk_persona_informatica_persona1` (`persona_idPERSONA` ASC, `persona_PER_idPRESENTACION` ASC, `persona_PER_idPREFERENCIAS_SALARIALES` ASC) ,
  CONSTRAINT `fk_persona_informatica_informatica1`
    FOREIGN KEY (`informatica_idINFORMATICA` )
    REFERENCES `bd_bolsatrabajo`.`informatica` (`idINFORMATICA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_persona_informatica_persona1`
    FOREIGN KEY (`persona_idPERSONA` , `persona_PER_idPRESENTACION` , `persona_PER_idPREFERENCIAS_SALARIALES` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` , `PER_idPRESENTACION` , `PER_idPREFERENCIAS_SALARIALES` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`puesto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`puesto` (
  `idPUESTO` INT(11) NOT NULL ,
  `nombrePuesto` VARCHAR(45) NOT NULL ,
  `codArea` VARCHAR(45) NOT NULL ,
  `descPuesto` VARCHAR(45) NOT NULL ,
  `persona_idPERSONA` INT(11) NOT NULL ,
  `persona_PER_idPRESENTACION` INT(11) NOT NULL ,
  `persona_PER_idPREFERENCIAS_SALARIALES` INT(11) NOT NULL ,
  `area_idAREA` INT(11) NOT NULL ,
  PRIMARY KEY (`idPUESTO`) ,
  INDEX `fk_puesto_persona1` (`persona_idPERSONA` ASC, `persona_PER_idPRESENTACION` ASC, `persona_PER_idPREFERENCIAS_SALARIALES` ASC) ,
  INDEX `fk_puesto_area1` (`area_idAREA` ASC) ,
  CONSTRAINT `fk_puesto_persona1`
    FOREIGN KEY (`persona_idPERSONA` , `persona_PER_idPRESENTACION` , `persona_PER_idPREFERENCIAS_SALARIALES` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` , `PER_idPRESENTACION` , `PER_idPREFERENCIAS_SALARIALES` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_puesto_area1`
    FOREIGN KEY (`area_idAREA` )
    REFERENCES `bd_bolsatrabajo`.`area` (`idAREA` )
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
  `persona_idPERSONA` INT(11) NOT NULL ,
  `persona_PER_idPRESENTACION` INT(11) NOT NULL ,
  `persona_PER_idPREFERENCIAS_SALARIALES` INT(11) NOT NULL ,
  PRIMARY KEY (`idREFERENCIA`, `REF_idPERSONA`) ,
  INDEX `fk_REFERENCIAS_PERSONA1` (`REF_idPERSONA` ASC) ,
  INDEX `fk_referencia_persona1` (`persona_idPERSONA` ASC, `persona_PER_idPRESENTACION` ASC, `persona_PER_idPREFERENCIAS_SALARIALES` ASC) ,
  CONSTRAINT `fk_referencia_persona1`
    FOREIGN KEY (`persona_idPERSONA` , `persona_PER_idPRESENTACION` , `persona_PER_idPREFERENCIAS_SALARIALES` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` , `PER_idPRESENTACION` , `PER_idPREFERENCIAS_SALARIALES` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd_bolsatrabajo`.`seleccion_postulante`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_bolsatrabajo`.`seleccion_postulante` (
  `idSELECCIONPOSTULANTE` INT(11) NOT NULL ,
  `codSeleccion` VARCHAR(45) NOT NULL ,
  `codAviso` VARCHAR(45) NOT NULL ,
  `codPostulante` VARCHAR(45) NOT NULL ,
  `persona_idPERSONA` INT(11) NOT NULL ,
  `persona_PER_idPRESENTACION` INT(11) NOT NULL ,
  `persona_PER_idPREFERENCIAS_SALARIALES` INT(11) NOT NULL ,
  PRIMARY KEY (`idSELECCIONPOSTULANTE`) ,
  INDEX `fk_seleccion_postulante_persona1` (`persona_idPERSONA` ASC, `persona_PER_idPRESENTACION` ASC, `persona_PER_idPREFERENCIAS_SALARIALES` ASC) ,
  CONSTRAINT `fk_seleccion_postulante_persona1`
    FOREIGN KEY (`persona_idPERSONA` , `persona_PER_idPRESENTACION` , `persona_PER_idPREFERENCIAS_SALARIALES` )
    REFERENCES `bd_bolsatrabajo`.`persona` (`idPERSONA` , `PER_idPRESENTACION` , `PER_idPREFERENCIAS_SALARIALES` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
