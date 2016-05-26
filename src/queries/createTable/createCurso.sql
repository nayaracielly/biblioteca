USE biblioteca;

CREATE TABLE IF NOT EXISTS `Curso` (
  `idCurso` INT NOT NULL,
  `nomeCurso` VARCHAR(45) NULL,
  PRIMARY KEY (`idCurso`))
ENGINE = InnoDB