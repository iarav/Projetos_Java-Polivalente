-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.30-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para agenda
CREATE DATABASE IF NOT EXISTS `agenda` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `agenda`;

-- Copiando estrutura para tabela agenda.cidade
CREATE TABLE IF NOT EXISTS `cidade` (
  `CodCidade` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(20) DEFAULT NULL,
  `CodEstado` int(11) NOT NULL,
  PRIMARY KEY (`CodCidade`),
  KEY `CodEstado` (`CodEstado`),
  CONSTRAINT `cidade_ibfk_1` FOREIGN KEY (`CodEstado`) REFERENCES `estado` (`CodEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela agenda.cidade: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;

-- Copiando estrutura para tabela agenda.estado
CREATE TABLE IF NOT EXISTS `estado` (
  `CodEstado` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CodEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela agenda.estado: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;

-- Copiando estrutura para tabela agenda.pessoa
CREATE TABLE IF NOT EXISTS `pessoa` (
  `CodPessoa` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(20) DEFAULT NULL,
  `Fone` varchar(10) DEFAULT NULL,
  `CodCidade` int(11) NOT NULL,
  `CodEstado` int(11) NOT NULL,
  PRIMARY KEY (`CodPessoa`),
  KEY `CodCidade` (`CodCidade`),
  KEY `CodEstado` (`CodEstado`),
  CONSTRAINT `pessoa_ibfk_1` FOREIGN KEY (`CodCidade`) REFERENCES `cidade` (`CodCidade`),
  CONSTRAINT `pessoa_ibfk_2` FOREIGN KEY (`CodEstado`) REFERENCES `estado` (`CodEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela agenda.pessoa: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
