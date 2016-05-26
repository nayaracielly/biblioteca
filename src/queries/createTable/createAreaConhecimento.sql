USE biblioteca;

CREATE TABLE IF NOT EXISTS `AreaConhecimento` (
  `idAreaConhecimento` INT NOT NULL,
  `nomeArea` VARCHAR(45) NULL,
  PRIMARY KEY (`idAreaConhecimento`))
ENGINE = InnoDB
