CREATE TABLE IF NOT EXISTS PURCHASE
(
  ID         INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  CUSTOMER   INTEGER,
  PRODUCT    VARCHAR(50),
  PRODUCT_ID INT,
  KASS       INT,
  STORE      INT,
  DATE       DATETIME
);

CREATE TABLE IF NOT EXISTS ITEMS
(
  ID      INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  PRODUCT VARCHAR(50),
  SOLD    VARCHAR(7),
  DATE    DATETIME
);


CREATE TABLE IF NOT EXISTS ITEM_TYPES
(
  ID       INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  PRODUCT  VARCHAR(50),
  PRICE    INT,
  QUANTITY INT

);

CREATE TABLE IF NOT EXISTS CUSTOMERS
(
  ID    INT NOT NULL,
  MONEY INT,
  PK    INT AUTO_INCREMENT PRIMARY KEY NOT NULL
);

CREATE TABLE IF NOT EXISTS STORES
(
  ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL
);


INSERT INTO ITEM_TYPES (PRODUCT, QUANTITY, PRICE) VALUES ('date', 3, 1);

INSERT INTO ITEM_TYPES (PRODUCT, QUANTITY, PRICE) VALUES ('apple', 3, 2);

INSERT INTO ITEM_TYPES (PRODUCT, QUANTITY, PRICE) VALUES ('orange', 3, 3);

INSERT INTO ITEM_TYPES (PRODUCT, QUANTITY, PRICE) VALUES ('pineapple', 3, 4);

INSERT INTO ITEM_TYPES (PRODUCT, QUANTITY, PRICE) VALUES ('strawberry', 3, 5);

