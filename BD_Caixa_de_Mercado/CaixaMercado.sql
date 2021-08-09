-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.8-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para caixamercado
CREATE DATABASE IF NOT EXISTS `caixamercado` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `caixamercado`;

-- Copiando estrutura para tabela caixamercado.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `CodProduto` varchar(13) NOT NULL,
  `Descricao` varchar(50) DEFAULT NULL,
  `PrecoVenda` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`CodProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela caixamercado.produto: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`CodProduto`, `Descricao`, `PrecoVenda`) VALUES
	('1', 'Caneta bic azul', 3.50),
	('2', 'Caneta bic preta', 4.00),
	('3', 'Chocolate Lacta', 8.00),
	('4', 'Queijo branco', 32.70),
	('5', 'Sorvete de flocos', 21.50);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;

-- Copiando estrutura para tabela caixamercado.venda
CREATE TABLE IF NOT EXISTS `venda` (
  `CodVenda` int(11) NOT NULL AUTO_INCREMENT,
  `Data` date DEFAULT NULL,
  `ValorTotal` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`CodVenda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela caixamercado.venda: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;

-- Copiando estrutura para tabela caixamercado.vendaitens
CREATE TABLE IF NOT EXISTS `vendaitens` (
  `CodVendaItem` int(11) NOT NULL AUTO_INCREMENT,
  `CodVenda` int(11) NOT NULL,
  `CodProduto` varchar(13) NOT NULL,
  `Quantidade` int(11) DEFAULT NULL,
  `ValorUnitario` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`CodVendaItem`),
  KEY `CodVenda` (`CodVenda`),
  KEY `CodProduto` (`CodProduto`),
  CONSTRAINT `vendaitens_ibfk_1` FOREIGN KEY (`CodVenda`) REFERENCES `venda` (`CodVenda`),
  CONSTRAINT `vendaitens_ibfk_2` FOREIGN KEY (`CodProduto`) REFERENCES `produto` (`CodProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela caixamercado.vendaitens: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `vendaitens` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendaitens` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
