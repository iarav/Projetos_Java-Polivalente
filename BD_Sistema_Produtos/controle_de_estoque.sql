-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.8-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para controle_de_estoque
CREATE DATABASE IF NOT EXISTS `controle_de_estoque` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `controle_de_estoque`;

-- Copiando estrutura para tabela controle_de_estoque.movimento
CREATE TABLE IF NOT EXISTS `movimento` (
  `CodMovi` int(11) NOT NULL AUTO_INCREMENT,
  `CodProduto` varchar(13) DEFAULT NULL,
  `Operacao` varchar(1) DEFAULT NULL,
  `Qtde` int(11) DEFAULT NULL,
  `Data` date DEFAULT NULL,
  PRIMARY KEY (`CodMovi`),
  KEY `CodProduto` (`CodProduto`),
  CONSTRAINT `movimento_ibfk_1` FOREIGN KEY (`CodProduto`) REFERENCES `produto` (`CodProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela controle_de_estoque.movimento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `movimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimento` ENABLE KEYS */;

-- Copiando estrutura para tabela controle_de_estoque.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `CodProduto` varchar(13) NOT NULL,
  `Descricao` varchar(50) DEFAULT NULL,
  `Unidade` varchar(2) DEFAULT NULL,
  `Saldo` int(11) DEFAULT NULL,
  `VrCompra` decimal(6,2) DEFAULT NULL,
  `VrVenda` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`CodProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela controle_de_estoque.produto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
