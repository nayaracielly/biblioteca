use biblioteca;

CREATE TABLE IF NOT EXISTS `Livro` (
  `isbn` VARCHAR(13) NULL,
  `editora` INT NULL,
  `autor` INT NULL,
  `edicao` VARCHAR(45) NULL,
  `areaConhecimento` INT NULL,
  `idLivro` INT NOT NULL,
  INDEX `editora_idx` (`editora` ASC),
  INDEX `autor_idx` (`autor` ASC),
  INDEX `areaConhecimento_idx` (`areaConhecimento` ASC),
  PRIMARY KEY (`idLivro`),
  CONSTRAINT `editora`
    FOREIGN KEY (`editora`)
    REFERENCES `Editora` (`idEditora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `autor`
    FOREIGN KEY (`autor`)
    REFERENCES `Autor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `areaConhecimento`
    FOREIGN KEY (`areaConhecimento`)
    REFERENCES `AreaConhecimento` (`idAreaConhecimento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB