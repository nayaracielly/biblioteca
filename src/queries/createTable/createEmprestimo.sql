USE biblioteca;

CREATE TABLE IF NOT EXISTS `Emprestimo` (
  `usuario` VARCHAR(8) NULL,
  `colecao` INT NULL,
  INDEX `usuario_idx` (`usuario` ASC),
  INDEX `colecao_idx` (`colecao` ASC),
  CONSTRAINT `usuario`
    FOREIGN KEY (`usuario`)
    REFERENCES `Usuario` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `colecao`
    FOREIGN KEY (`colecao`)
    REFERENCES `Livro` (`idLivro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB