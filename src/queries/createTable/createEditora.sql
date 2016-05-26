USE biblioteca;

CREATE TABLE IF NOT EXISTS `Editora` (
  `idEditora` INT NOT NULL,
  `nomeEditora` VARCHAR(45) NULL,
  PRIMARY KEY (`idEditora`))
ENGINE = InnoDB