-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_de_control_de_biblioteca
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `administrador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'principal@mysql.com','Usuario01','Principal'),(2,'gloria@mysql.com','User02','Gloria'),(3,'jhonny@mysql.com','User03','Jhonny');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_autores_detalles`
--

DROP TABLE IF EXISTS `tabla_autores_detalles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tabla_autores_detalles` (
  `id_autor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fecha_de_nacimiento` varchar(15) NOT NULL,
  `nacionalidad` varchar(45) NOT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Referente a detalles personales de cada uno de los autores de literatura presentada en esta biblioteca.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_autores_detalles`
--

LOCK TABLES `tabla_autores_detalles` WRITE;
/*!40000 ALTER TABLE `tabla_autores_detalles` DISABLE KEYS */;
INSERT INTO `tabla_autores_detalles` VALUES (3,'Steven Nil','14/02/1974','Ingles'),(4,'Gloria Sevilla','14/02/1974','Britanica'),(5,'J. L. James','14/02/1974','Britanica'),(6,'J. L. James','14/02/1974','Britanica'),(7,'Michael','14/02/1974','Britanica');
/*!40000 ALTER TABLE `tabla_autores_detalles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_autores_llave`
--

DROP TABLE IF EXISTS `tabla_autores_llave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tabla_autores_llave` (
  `id_autor_libro` int(11) NOT NULL AUTO_INCREMENT,
  `id_autor` int(11) NOT NULL,
  `id_libro` int(11) NOT NULL,
  PRIMARY KEY (`id_autor_libro`),
  KEY `id_libro_idx` (`id_autor`),
  KEY `id_autor_idx` (`id_autor`,`id_autor_libro`),
  KEY `id_autor_idx1` (`id_autor_libro`),
  KEY `id_libros_idx` (`id_libro`,`id_autor`),
  CONSTRAINT `id_autor` FOREIGN KEY (`id_autor`) REFERENCES `tabla_autores_detalles` (`id_autor`),
  CONSTRAINT `id_libro` FOREIGN KEY (`id_libro`) REFERENCES `tabla_libros` (`id_libro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='En la presente se hace referencia a libros en especifico y su autor con sus respectivas llaves foraneas.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_autores_llave`
--

LOCK TABLES `tabla_autores_llave` WRITE;
/*!40000 ALTER TABLE `tabla_autores_llave` DISABLE KEYS */;
INSERT INTO `tabla_autores_llave` VALUES (1,3,14),(2,3,14);
/*!40000 ALTER TABLE `tabla_autores_llave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_inventario`
--

DROP TABLE IF EXISTS `tabla_inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tabla_inventario` (
  `id_inventario` int(11) NOT NULL AUTO_INCREMENT,
  `id_proveedor` int(11) NOT NULL,
  `id_libro` int(11) NOT NULL,
  `estado_libro` varchar(45) NOT NULL,
  `existencia_libro` int(11) NOT NULL,
  `stock_minimo_libro` int(11) NOT NULL,
  PRIMARY KEY (`id_inventario`),
  KEY `id_proveedor` (`id_proveedor`),
  KEY `id_libro` (`id_libro`),
  CONSTRAINT `tabla_inventario_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `tabla_proveedor` (`id_proveedor`),
  CONSTRAINT `tabla_inventario_ibfk_2` FOREIGN KEY (`id_libro`) REFERENCES `tabla_libros` (`id_libro`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Contiene los detalles referentes al inventario entrante, existente y movimientos del mismo.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_inventario`
--

LOCK TABLES `tabla_inventario` WRITE;
/*!40000 ALTER TABLE `tabla_inventario` DISABLE KEYS */;
INSERT INTO `tabla_inventario` VALUES (8,2,2,'Disponible',100,22),(9,2,6,'Disponible',25,1),(10,2,6,'Disponible',12,10);
/*!40000 ALTER TABLE `tabla_inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_inventario_llaves`
--

DROP TABLE IF EXISTS `tabla_inventario_llaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tabla_inventario_llaves` (
  `id_inventario_llaves` int(11) NOT NULL AUTO_INCREMENT,
  `id_proveedor` int(11) NOT NULL,
  `id_libro` int(11) NOT NULL,
  PRIMARY KEY (`id_inventario_llaves`),
  KEY `id_proveedor_idx` (`id_proveedor`),
  KEY `id_libro` (`id_libro`),
  CONSTRAINT `tabla_inventario_llaves_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `tabla_libros` (`id_libro`),
  CONSTRAINT `tabla_inventario_llaves_ibfk_2` FOREIGN KEY (`id_proveedor`) REFERENCES `tabla_proveedor` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='La presente tabla se ha creado para el almacenamiento de "muchos a muchos".';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_inventario_llaves`
--

LOCK TABLES `tabla_inventario_llaves` WRITE;
/*!40000 ALTER TABLE `tabla_inventario_llaves` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_inventario_llaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_lectores`
--

DROP TABLE IF EXISTS `tabla_lectores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tabla_lectores` (
  `id_lector` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_lector` varchar(45) NOT NULL,
  `direccion_lector` varchar(45) NOT NULL,
  `telefono_lector` int(30) NOT NULL,
  PRIMARY KEY (`id_lector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_lectores`
--

LOCK TABLES `tabla_lectores` WRITE;
/*!40000 ALTER TABLE `tabla_lectores` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_lectores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_libros`
--

DROP TABLE IF EXISTS `tabla_libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tabla_libros` (
  `id_libro` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fecha_de_publicacion` varchar(15) NOT NULL,
  `tomo` int(11) NOT NULL,
  `edicion` varchar(45) NOT NULL,
  `paginas` int(11) NOT NULL,
  `genero` varchar(45) NOT NULL,
  PRIMARY KEY (`id_libro`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='En la presente se encuentra la información referente unicamente a libros.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_libros`
--

LOCK TABLES `tabla_libros` WRITE;
/*!40000 ALTER TABLE `tabla_libros` DISABLE KEYS */;
INSERT INTO `tabla_libros` VALUES (2,'Agua, tierra y fuego','2',1,'Caja marciana',76,'Misterio'),(6,'Miau','28/01/1995',3,'12',3000,'Accion'),(14,'Examen 1','27/07/2018',1,'Primera',53,'Educacion');
/*!40000 ALTER TABLE `tabla_libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_mora_llave`
--

DROP TABLE IF EXISTS `tabla_mora_llave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tabla_mora_llave` (
  `idtabla_mora_llave` int(11) NOT NULL AUTO_INCREMENT,
  `id_libro` int(11) NOT NULL,
  `id_lector` int(11) NOT NULL,
  `id_prestamo` int(11) NOT NULL,
  PRIMARY KEY (`idtabla_mora_llave`),
  KEY `id_libro_idx` (`id_libro`),
  KEY `id_lector_idx` (`id_lector`),
  KEY `id_prestamo_idx` (`id_prestamo`),
  CONSTRAINT `tabla_mora_llave_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `tabla_libros` (`id_libro`),
  CONSTRAINT `tabla_mora_llave_ibfk_2` FOREIGN KEY (`id_lector`) REFERENCES `tabla_lectores` (`id_lector`),
  CONSTRAINT `tabla_mora_llave_ibfk_3` FOREIGN KEY (`id_prestamo`) REFERENCES `tabla_prestamos_bibliotecarios` (`id_prestamo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_mora_llave`
--

LOCK TABLES `tabla_mora_llave` WRITE;
/*!40000 ALTER TABLE `tabla_mora_llave` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_mora_llave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_mora_por_prestamos`
--

DROP TABLE IF EXISTS `tabla_mora_por_prestamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tabla_mora_por_prestamos` (
  `id_mora` int(11) NOT NULL,
  `fecha_de_emision` varchar(15) NOT NULL,
  `dias_retrasados` int(11) NOT NULL,
  PRIMARY KEY (`id_mora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_mora_por_prestamos`
--

LOCK TABLES `tabla_mora_por_prestamos` WRITE;
/*!40000 ALTER TABLE `tabla_mora_por_prestamos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_mora_por_prestamos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_prestamo_llave`
--

DROP TABLE IF EXISTS `tabla_prestamo_llave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tabla_prestamo_llave` (
  `id_tpb` int(11) NOT NULL AUTO_INCREMENT,
  `id_libro` int(11) NOT NULL,
  `id_lector` int(11) NOT NULL,
  PRIMARY KEY (`id_tpb`),
  KEY `id_libro_idx` (`id_libro`),
  KEY `id_lector_idx` (`id_lector`),
  CONSTRAINT `tabla_prestamo_llave_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `tabla_libros` (`id_libro`),
  CONSTRAINT `tabla_prestamo_llave_ibfk_2` FOREIGN KEY (`id_lector`) REFERENCES `tabla_lectores` (`id_lector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_prestamo_llave`
--

LOCK TABLES `tabla_prestamo_llave` WRITE;
/*!40000 ALTER TABLE `tabla_prestamo_llave` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_prestamo_llave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_prestamos_bibliotecarios`
--

DROP TABLE IF EXISTS `tabla_prestamos_bibliotecarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tabla_prestamos_bibliotecarios` (
  `id_prestamo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_de_emision` varchar(15) NOT NULL,
  `fecha_de_retorno_asignada` varchar(15) NOT NULL,
  PRIMARY KEY (`id_prestamo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='En la presente se registran los libros que estan fuera de la institución en calidad de prestamo. ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_prestamos_bibliotecarios`
--

LOCK TABLES `tabla_prestamos_bibliotecarios` WRITE;
/*!40000 ALTER TABLE `tabla_prestamos_bibliotecarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_prestamos_bibliotecarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_proveedor`
--

DROP TABLE IF EXISTS `tabla_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tabla_proveedor` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `rubro` varchar(45) NOT NULL,
  `personeria_juridica` varchar(45) NOT NULL,
  `telefono` int(30) NOT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Dedicada al registro de los proveedores.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_proveedor`
--

LOCK TABLES `tabla_proveedor` WRITE;
/*!40000 ALTER TABLE `tabla_proveedor` DISABLE KEYS */;
INSERT INTO `tabla_proveedor` VALUES (1,'Nuevo Mundo Inc.','Venta de literatura academica','Juridica',22569871),(2,'Michelle Zavaleta','Literatura comercial','Juridica',22949596);
/*!40000 ALTER TABLE `tabla_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'principal@mysql.com','Usuario01','Principal'),(2,'principal@mysql.com','Usuario01','Principal');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sistema_de_control_de_biblioteca'
--

--
-- Dumping routines for database 'sistema_de_control_de_biblioteca'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-07 11:42:01
