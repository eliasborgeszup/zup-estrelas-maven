CREATE DATABASE banco_mavem;

CREATE TABLE banco_mavem.carro (
	nome VARCHAR(45) NOT NULL,
    placa VARCHAR(45) NOT NULL PRIMARY KEY,
    marca VARCHAR(45) NOT NULL, 
    anoFabricacao INT NOT NULL
);

INSERT INTO banco_mavem.carro VALUES ("GOL G5", "HLJ-8513", "VW", 2010);

INSERT INTO banco_mavem.carro VALUES ("PALIO", "HLJ-8512", "FIAT", 2020);

INSERT INTO banco_mavem.carro VALUES ("FIAT UNO WAY", "HLJ-8514", "FIAT", 2013);

INSERT INTO banco_mavem.carro VALUES ("LANCER", "HLJ-8516", "MITSUCISHI", 2012);

INSERT INTO banco_mavem.carro VALUES ("COROLLA", "HLJ-8515", "TOYOTA", 2019);