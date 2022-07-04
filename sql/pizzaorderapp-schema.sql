USE pizzaorderapp;

DROP TABLE IF EXISTS pizzaPorder;
DROP TABLE IF EXISTS porder;
DROP TABLE IF EXISTS pizza;
DROP TABLE IF EXISTS customer;

CREATE TABLE pizza (
	pizzaId INT AUTO_INCREMENT,
    flavour VARCHAR(100) NOT NULL,
    price DECIMAL(6,2) NOT NULL,
    CONSTRAINT PK_pizzaId 
		PRIMARY KEY (pizzaId)
);
DESCRIBE pizza;

CREATE TABLE customer (
	customerId INT AUTO_INCREMENT,
    lastName VARCHAR(100) NOT NULL,
    contactNumber CHAR(15) NOT NULL,
    CONSTRAINT PK_customerId
		PRIMARY KEY (customerId)
);
DESCRIBE customer;

CREATE TABLE porder (
	porderId INT AUTO_INCREMENT,
    customerId INT,
    CONSTRAINT PK_porderId
		PRIMARY KEY (porderId),
	CONSTRAINT FK_porder_customer
		FOREIGN KEY (customerId)
		REFERENCES customer (customerId)
);
DESCRIBE porder;
SHOW TABLES;

CREATE TABLE pizzaPorder (
	pizzaId INT,
    porderId INT,
    quantity INT DEFAULT 0,
    CONSTRAINT PK_pizzaPorder
		PRIMARY KEY (pizzaId, porderId),
	CONSTRAINT FK_pizzaPorder_pizza
		FOREIGN KEY (pizzaId)
        REFERENCES pizza (pizzaId),
	CONSTRAINT FK_pizzaPorder_porder
		FOREIGN KEY (porderId)
        REFERENCES porder (porderId)
);
DESCRIBE pizzaPorder;

SHOW TABLES;