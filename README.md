# Teste_Sefaz
Teste de Aplicação Java



Obs 01 - Scripts de criação de Banco e Tabelas (MySQL):

    CREATE DATABASE `teste_sefaz` /*!40100 DEFAULT CHARACTER SET utf8 */;

    CREATE TABLE `usuario` (
      `id_usuario` int(10) unsigned NOT NULL AUTO_INCREMENT,
      `nm_usuario` varchar(45) NOT NULL,
      `email_usuario` varchar(45) NOT NULL,
      `senha_usuario` varchar(45) NOT NULL,
      `tel_usuario` varchar(45) NOT NULL,
      PRIMARY KEY (`id_usuario`),
      UNIQUE KEY `email_usuario_UNIQUE` (`email_usuario`)
    ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
