CREATE DATABASE  IF NOT EXISTS `aeropuerto` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `aeropuerto`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: aeropuerto
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `NOMBRE` varchar(25) NOT NULL,
  `APELLIDOS` varchar(45) NOT NULL,
  `IDENTIFICACION` varchar(45) NOT NULL,
  `CORREO` varchar(45) NOT NULL,
  `CONTRASENNA` varchar(45) NOT NULL,
  `DIRECCION` varchar(45) NOT NULL,
  `NACIONALIDAD` varchar(45) NOT NULL,
  `FECHANACIMIENTO` date NOT NULL,
  `EDAD` int NOT NULL,
  `GENERO` varchar(45) NOT NULL,
  PRIMARY KEY (`IDENTIFICACION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES ('Jason','Corrales','222','Jason@cenfotec.com','123','123 cenfotec','CR','1985-04-19',37,'Masculino'),('Marco','Ramirez','504270962','1','1','El coyol','Costarricense','1999-06-09',23,'Masculino');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aeropuerto`
--

DROP TABLE IF EXISTS `aeropuerto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aeropuerto` (
  `NOMBREAEROPUERTO` varchar(25) NOT NULL,
  `CODIGOAEROPUERTO` varchar(45) NOT NULL,
  `CODIGOPAIS` varchar(45) NOT NULL,
  `IDENTIFICACIONADMINISTRADOR` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CODIGOAEROPUERTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aeropuerto`
--

LOCK TABLES `aeropuerto` WRITE;
/*!40000 ALTER TABLE `aeropuerto` DISABLE KEYS */;
INSERT INTO `aeropuerto` VALUES ('Aeropuerto Orotina','123','CR','321');
/*!40000 ALTER TABLE `aeropuerto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avion`
--

DROP TABLE IF EXISTS `avion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avion` (
  `PLACA` varchar(45) NOT NULL,
  `MARCA` varchar(45) NOT NULL,
  `MODELO` varchar(45) NOT NULL,
  `CAPACIDAD` varchar(45) NOT NULL,
  PRIMARY KEY (`PLACA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avion`
--

LOCK TABLES `avion` WRITE;
/*!40000 ALTER TABLE `avion` DISABLE KEYS */;
INSERT INTO `avion` VALUES ('444','jet','Yei yei','150');
/*!40000 ALTER TABLE `avion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gate`
--

DROP TABLE IF EXISTS `gate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gate` (
  `NOMBRE` varchar(25) NOT NULL,
  `CODIGO` varchar(45) NOT NULL,
  `UBICACION` varchar(45) NOT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gate`
--

LOCK TABLES `gate` WRITE;
/*!40000 ALTER TABLE `gate` DISABLE KEYS */;
INSERT INTO `gate` VALUES ('Vip','999','Orotina');
/*!40000 ALTER TABLE `gate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineaaerea`
--

DROP TABLE IF EXISTS `lineaaerea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineaaerea` (
  `NOMBRECOMERCIAL` varchar(45) NOT NULL,
  `CEDULAJURIDICA` varchar(45) NOT NULL,
  `NOMBREEMPRESADUENNA` varchar(45) NOT NULL,
  `CODIGOPAIS` varchar(45) NOT NULL,
  PRIMARY KEY (`CEDULAJURIDICA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineaaerea`
--

LOCK TABLES `lineaaerea` WRITE;
/*!40000 ALTER TABLE `lineaaerea` DISABLE KEYS */;
INSERT INTO `lineaaerea` VALUES ('Cenfotec Airlines','456','Cenfotec','CR');
/*!40000 ALTER TABLE `lineaaerea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `NOMBRE` varchar(45) NOT NULL,
  `ABREVIATURA` varchar(45) NOT NULL,
  PRIMARY KEY (`ABREVIATURA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES ('Costa Rica','CR'),('Puerto Rico','PR');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiquete`
--

DROP TABLE IF EXISTS `tiquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tiquete` (
  `FECHA` varchar(45) NOT NULL,
  `PAISORIGEN` varchar(45) NOT NULL,
  `AEROPUERTOORIGEN` varchar(45) NOT NULL,
  `PAISDESTINO` varchar(45) NOT NULL,
  `AEROPUERTODESTINO` varchar(45) NOT NULL,
  `NUMEROASIENTO` int NOT NULL,
  `PRECIO` varchar(45) NOT NULL,
  `NUMEROVUELO` varchar(45) NOT NULL,
  `TIPOASIENTO` varchar(45) NOT NULL,
  PRIMARY KEY (`NUMEROASIENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiquete`
--

LOCK TABLES `tiquete` WRITE;
/*!40000 ALTER TABLE `tiquete` DISABLE KEYS */;
INSERT INTO `tiquete` VALUES ('9 Junio 2023','Orotina','Orotina','PR','San Juan',23,'1000000','435','Primera clase');
/*!40000 ALTER TABLE `tiquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tripulante`
--

DROP TABLE IF EXISTS `tripulante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tripulante` (
  `NOMBRE` varchar(20) NOT NULL,
  `APELLIDOS` varchar(45) NOT NULL,
  `IDENTIFICACION` varchar(45) NOT NULL,
  `CORREO` varchar(45) NOT NULL,
  `CONTRASENNA` varchar(45) NOT NULL,
  `DIRECCION` varchar(45) NOT NULL,
  `NACIONALIDAD` varchar(45) NOT NULL,
  `GENERO` varchar(45) NOT NULL,
  `ANNOSEXPERIENCIA` int NOT NULL,
  `FECHAGRADUACION` varchar(45) NOT NULL,
  `NUMEROLICENCIA` varchar(45) NOT NULL,
  `PUESTO` varchar(45) NOT NULL,
  `TELEFONO` varchar(45) NOT NULL,
  PRIMARY KEY (`NUMEROLICENCIA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tripulante`
--

LOCK TABLES `tripulante` WRITE;
/*!40000 ALTER TABLE `tripulante` DISABLE KEYS */;
INSERT INTO `tripulante` VALUES ('123','123','123','1','1','123','123','123',123,'1999-01-01','123','123','123'),('Charlie','Ramirez','123','charlie@charlie.com','1','Coyol','CR','Masculino',20,'2020-10-11','352412','Piloto','44442222');
/*!40000 ALTER TABLE `tripulante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariofinal`
--

DROP TABLE IF EXISTS `usuariofinal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuariofinal` (
  `NOMBRE` varchar(20) NOT NULL,
  `APELLIDOS` varchar(45) NOT NULL,
  `IDENTIFICACION` varchar(45) NOT NULL,
  `CORREO` varchar(45) NOT NULL,
  `CONTRASENNA` varchar(45) NOT NULL,
  `DIRECCION` varchar(45) NOT NULL,
  `NACIONALIDAD` varchar(45) NOT NULL,
  `FECHANACIMIENTO` date NOT NULL,
  `EDAD` int NOT NULL,
  `PROVINCIA` varchar(45) NOT NULL,
  `CANTON` varchar(45) NOT NULL,
  `DISTRITO` varchar(45) NOT NULL,
  PRIMARY KEY (`IDENTIFICACION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariofinal`
--

LOCK TABLES `usuariofinal` WRITE;
/*!40000 ALTER TABLE `usuariofinal` DISABLE KEYS */;
INSERT INTO `usuariofinal` VALUES ('Marco','Ramirez','123','1','1','123','123','1999-01-01',23,'123','123','123'),('Isabela','Gonzalez','453','katt@gonzalez.com','1','Coyol','CR','1999-08-07',23,'Alajuela','Alajuela ','San Jose');
/*!40000 ALTER TABLE `usuariofinal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelo`
--

DROP TABLE IF EXISTS `vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelo` (
  `CEDULAJURIDICA` varchar(45) NOT NULL,
  `AEROPUERTOORIGEN` varchar(45) NOT NULL,
  `PAISORIGEN` varchar(45) NOT NULL,
  `HORALLEGADA` varchar(45) NOT NULL,
  `HORASALIDA` varchar(45) NOT NULL,
  `ESTADO` varchar(45) NOT NULL,
  `AEROPUERTODESTINO` varchar(45) NOT NULL,
  `PAISDESTINO` varchar(45) NOT NULL,
  `TIPOVUELO` varchar(45) NOT NULL,
  `AVION` varchar(45) NOT NULL,
  `GATESALIDA` varchar(45) NOT NULL,
  `GATELLEGADA` varchar(45) NOT NULL,
  `TRIPULACION` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelo`
--

LOCK TABLES `vuelo` WRITE;
/*!40000 ALTER TABLE `vuelo` DISABLE KEYS */;
INSERT INTO `vuelo` VALUES ('DHL','CR1','CR','17:00','5:00','Atrasado','LA1','USA','Carga','123123','01CHA','01CAR','o12ks1');
/*!40000 ALTER TABLE `vuelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'aeropuerto'
--

--
-- Dumping routines for database 'aeropuerto'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-19 22:53:51
