CREATE DATABASE IF NOT EXISTS financeiro;

CREATE TABLE `usuario` (
	`codigo` int(11) NOT NULL AUTO_INCREMENT,
	`nome` varchar(50) NOT NULL,
	`login` varchar(15) NOT NULL,
	`email` varchar(100) NOT NULL,
	`senha` varchar(10) NOT NULL,
	`nascimento` date NOT NULL,
	`celular` varchar(25),
	`idioma` varchar(5) NOT NULL,
	`ativo` tinyint(1) NOT NULL,
	PRIMARY KEY (`codigo`),
	UNIQUE KEY `login` (`login`)
);

CREATE TABLE `conta_bancaria` (
	`cod_conta` int(11) NOT NULL AUTO_INCREMENT,
	`cod_usuario` int(11) NOT NULL,
	`des_conta` varchar(255) DEFAULT NULL,
	`dat_cadastro` datetime NOT NULL,
	`saldo_inicial` float DEFAULT NULL,
	`favorita` bit(1) DEFAULT NULL,
	PRIMARY KEY (cod_conta),
	CONSTRAINT FK_conta_usuario
		FOREIGN KEY (cod_usuario)
			REFERENCES usuario (codigo) ON DELETE CASCADE
);
