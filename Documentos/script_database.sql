-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bluebank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS bluebank DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE bluebank ;

-- -----------------------------------------------------
-- Table 'bluebank'.'cliente'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS bluebank.cliente (
  id BIGINT NOT NULL AUTO_INCREMENT,
  apelido VARCHAR(20) NOT NULL,
  cpf_cnpj VARCHAR(14) NOT NULL,
  data_nascimento DATE NULL DEFAULT NULL,
  genero VARCHAR(15) NULL DEFAULT NULL,
  nome VARCHAR(50) NOT NULL,
  rg_ie VARCHAR(14) NOT NULL,
  senha VARCHAR(20) NOT NULL,
  tipo INT NOT NULL,
  topico VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX UK_cpf_cnpj (cpf_cnpj ASC) VISIBLE,
  UNIQUE INDEX UK_rg_ie (rg_ie ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table bluebank.conta
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS bluebank.conta (
  id BIGINT NOT NULL AUTO_INCREMENT,
  agencia INT NOT NULL,
  codigo_banco INT NOT NULL,
  data_abertura DATE NOT NULL,
  data_fechamento DATE NULL DEFAULT NULL,
  digito_conta INT NOT NULL,
  numero_conta INT NOT NULL,
  status INT NOT NULL,
  cliente_id BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX UK_numero_conta (numero_conta ASC) VISIBLE,
  INDEX FK_cliente_id (cliente_id ASC) VISIBLE
  )
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table bluebank.contato
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS bluebank.contato (
  id BIGINT NOT NULL AUTO_INCREMENT,
  contato_tel VARCHAR(25) NULL DEFAULT NULL,
  descricao VARCHAR(10) NOT NULL,
  email VARCHAR(50) NOT NULL,
  status_contato INT NULL DEFAULT NULL,
  telefone VARCHAR(11) NOT NULL,
  cliente_id BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX FK_cliente_id (cliente_id ASC) VISIBLE
 )
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table bluebank.endereco
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS bluebank.endereco (
  id BIGINT NOT NULL AUTO_INCREMENT,
  bairro VARCHAR(30) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  cidade VARCHAR(50) NOT NULL,
  complemento VARCHAR(50) NULL DEFAULT NULL,
  estado VARCHAR(2) NOT NULL,
  logradouro VARCHAR(120) NOT NULL,
  pais VARCHAR(30) NOT NULL,
  status_end INT NULL DEFAULT NULL,
  cliente_id BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX FK_cliente_id (cliente_id ASC) VISIBLE
 )
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table bluebank.movimentacao
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS bluebank.movimentacao (
  id BIGINT NOT NULL AUTO_INCREMENT,
  credito_debito INT NOT NULL,
  data_transacao DATE NOT NULL,
  descricao VARCHAR(20) NOT NULL,
  id_transacao BIGINT NOT NULL,
  tipo INT NOT NULL,
  valor DOUBLE NOT NULL,
  conta_id BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  INDEX FK_conta_id (conta_id ASC) VISIBLE
)
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table bluebank.saldo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS bluebank.saldo (
  data DATE NOT NULL,
  saldo DOUBLE NOT NULL,
  conta_id BIGINT NOT NULL,
  PRIMARY KEY (conta_id, data),
  INDEX fk_saldo_conta1_id (conta_id ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
