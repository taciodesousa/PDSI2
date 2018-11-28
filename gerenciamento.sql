-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: gerenciamento
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alunos`
--

DROP TABLE IF EXISTS `alunos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alunos` (
  `Nome` varchar(50) DEFAULT NULL,
  `Sexo` varchar(9) DEFAULT NULL,
  `DataNascimento` varchar(10) DEFAULT NULL,
  `RG` varchar(9) DEFAULT NULL,
  `CPF` varchar(14) DEFAULT NULL,
  `Matricula` varchar(11) NOT NULL,
  `Curso` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Matricula`),
  UNIQUE KEY `RG` (`RG`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `Matricula` (`Matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alunos`
--

LOCK TABLES `alunos` WRITE;
/*!40000 ALTER TABLE `alunos` DISABLE KEYS */;
INSERT INTO `alunos` VALUES ('João Marcos','Masculino',NULL,'123456',NULL,'111111111','Sistemas de Informação'),('João Marcos','Masculino','10/02/2002','12345677','23434567723424','1111111111','Sistemas'),('João Marcos','Masculino','10/10/1994','123416','12345678987','111111211','Sistemas de Informação'),('João Marcos','Masculino','10/02/2002','1137967','24836567724524','1210511111','Sistemas'),('João Marcos','Masculino','10/02/2002','1234567','23434567722424','1211111111','Sistemas'),('João Marcos','Masculino','10/02/2002','1232567','23436567722424','1211511111','Sistemas'),('João Marcos','Masculino','10/02/2002','1237967','23436567724524','1287511111','Sistemas'),('João Marcos','Masculino','10/02/2002','1132567','24836562424524','1510511111','Sistemas'),('João Marcos','Masculino','10/02/2002','1132307','24836562424535','15577511111','Sistemas');
/*!40000 ALTER TABLE `alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `em_uso`
--

DROP TABLE IF EXISTS `em_uso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `em_uso` (
  `nome_aluno` varchar(40) DEFAULT NULL,
  `maquina` varchar(15) DEFAULT NULL,
  `hora_entrada` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `em_uso`
--

LOCK TABLES `em_uso` WRITE;
/*!40000 ALTER TABLE `em_uso` DISABLE KEYS */;
INSERT INTO `em_uso` VALUES ('111116','Máquina 03','10/03/2018'),('111236','Máquina 01','18/03/2018');
/*!40000 ALTER TABLE `em_uso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `Cod_Login` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(15) DEFAULT NULL,
  `Senha` varchar(15) DEFAULT NULL,
  `Curso` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Cod_Login`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'admsi','geek','Sistemas de Informação'),(2,'joao','jmarcos000','Sistemas de Informação'),(3,'admsi','geek','Sistemas de Informação'),(4,'admsi','geek','Sistemas de Informação'),(5,'admsi','geek','Sistemas de Informação'),(6,'admsi','geek','Sistemas de Informação');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relatorio`
--

DROP TABLE IF EXISTS `relatorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relatorio` (
  `nome_aluno` varchar(40) DEFAULT NULL,
  `maquina` varchar(15) DEFAULT NULL,
  `horario_entrada` varchar(50) DEFAULT NULL,
  `horario_saida` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relatorio`
--

LOCK TABLES `relatorio` WRITE;
/*!40000 ALTER TABLE `relatorio` DISABLE KEYS */;
INSERT INTO `relatorio` VALUES ('111122','Máquina 01','23/10/2018 10:29','23/10/2018 18:00'),('123122','Máquina 02','21/11/2018 10:20','23/11/2018 12:00');
/*!40000 ALTER TABLE `relatorio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-28 20:47:12
