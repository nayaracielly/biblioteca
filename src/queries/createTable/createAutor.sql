USE biblioteca;

CREATE TABLE IF NOT EXISTS `Autor` (
  `idAutor` INT NOT NULL,
  `nomeAutor` VARCHAR(45) NULL,
  `livrosDoAutor` VARCHAR(13) NULL,
  PRIMARY KEY (`idAutor`),
  INDEX `livrosDoAutor_idx` (`livrosDoAutor` ASC),
  CONSTRAINT `livrosDoAutor`
    FOREIGN KEY (`livrosDoAutor`)
    REFERENCES `model`.`Livro` (`isbn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB