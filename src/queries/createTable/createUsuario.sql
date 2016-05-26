USE biblioteca;

CREATE TABLE IF NOT EXISTS `Usuario` (
  `matricula` VARCHAR(8) NOT NULL,
  `nomeUsuario` VARCHAR(45) NULL,
  `curso` INT NULL,
  `login` VARCHAR(15) NULL,
  `senha` VARCHAR(15) NULL,
  PRIMARY KEY (`matricula`),
  INDEX `curso_idx` (`curso` ASC),
  CONSTRAINT `curso`
    FOREIGN KEY (`curso`)
    REFERENCES `Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB