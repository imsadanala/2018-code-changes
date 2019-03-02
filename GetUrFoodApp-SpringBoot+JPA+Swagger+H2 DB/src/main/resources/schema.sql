--DROP SEQUENCE USER_ID_SEQ;
CREATE SEQUENCE USER_ID_SEQ
MINVALUE 1
MAXVALUE 999999999999
START WITH 1
INCREMENT BY 1
NOCACHE;

--DROP SEQUENCE ITEM_ID_SEQ;
CREATE SEQUENCE ITEM_ID_SEQ
MINVALUE 1
MAXVALUE 999999999999
START WITH 1
INCREMENT BY 1
NOCACHE;

--DROP SEQUENCE ORDER_ID_SEQ;
CREATE SEQUENCE ORDER_ID_SEQ
MINVALUE 1
MAXVALUE 999999999999
START WITH 1
INCREMENT BY 1
NOCACHE;

DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS ORDER_DETAILS;
DROP TABLE IF EXISTS FOOD_ITEMS;
CREATE TABLE USERS(
	USER_ID INT(20) NOT NULL,
	FIRST_NAME VARCHAR(50) NOT NULL,
	MIDDLE_NAME VARCHAR(50),
	LAST_NAME VARCHAR(50) NOT NULL,
	LOGIN_NAME VARCHAR(20) NOT NULL,
	PASSWORD VARCHAR(255) NOT NULL,
	EMAIL VARCHAR(50) NOT NULL,
	PHONE INT(11) NOT NULL,
	STATUS VARCHAR(4),
	ADDRESS VARCHAR(255) NOT NULL,
	CREATED_ON DATE NOT NULL,
	CONSTRAINT USER_ID_PK PRIMARY KEY (USER_ID),
	CONSTRAINT LOGIN_NAME_PK UNIQUE (LOGIN_NAME)
);
CREATE TABLE FOOD_ITEMS (
	ITEM_ID INT(12) NOT NULL,
	ITEM_NAME VARCHAR(20) NOT NULL,
	TYPE VARCHAR(20) NULL,
	DESCRIPTION VARCHAR(255),
	PRICE DOUBLE(20) NOT NULL,
	STATUS VARCHAR(4),
	CREATED_ON DATE NOT NULL,	
	CONSTRAINT ITEM_ID_PK PRIMARY KEY (ITEM_ID)
);

CREATE TABLE ORDER_DETAILS(
	ORDER_ID INT(12) NOT NULL,
	USER_ID INT(20) NOT NULL,
	ITEM_ID INT(12) NOT NULL,
	QUANTITY INT(5) NOT NULL,
	STATUS VARCHAR(4),
	DESCRIPTION VARCHAR(255),
	CREATED_ON DATE NOT NULL,
	CONSTRAINT ORDER_ID_PK PRIMARY KEY (ORDER_ID)
);


DELETE FROM USERS;
COMMIT;
INSERT INTO USERS VALUES(USER_ID_SEQ.NEXTVAL, 'AdminFirst', '', 'AdminLast', 'Admin', 'Admin', 'admin.@ss.com', 1234567890, '1', 'AP', SYSDATE);
INSERT INTO USERS VALUES(USER_ID_SEQ.NEXTVAL, 'AFirst', '', 'ALast', 'AA', 'password', 'aa.@ss.com', 1234567890, '1', 'TN', SYSDATE);
INSERT INTO USERS VALUES(USER_ID_SEQ.NEXTVAL, 'BFirst', '', 'BLast', 'BB', 'password', 'aa.@ss.com', 1234567890, '1', 'AP', SYSDATE);
INSERT INTO USERS VALUES(USER_ID_SEQ.NEXTVAL, 'CFirst', '', 'CLast', 'CC', 'password', 'cc.@ss.com', 1234567890, '1', 'KA', SYSDATE);
INSERT INTO USERS VALUES(USER_ID_SEQ.NEXTVAL, 'DFirst', '', 'DLast', 'DD', 'password', 'dd.@ss.com', 1234567890, '1', 'KL', SYSDATE);
INSERT INTO USERS VALUES(USER_ID_SEQ.NEXTVAL, 'EFirst', '', 'ELast', 'EE', 'password', 'ee.@ss.com', 1234567890, '1', 'AP', SYSDATE);
INSERT INTO USERS VALUES(USER_ID_SEQ.NEXTVAL, 'FFirst', '', 'FLast', 'FF', 'password', 'ff.@ss.com', 1234567890, '1', 'TN', SYSDATE);
INSERT INTO USERS VALUES(USER_ID_SEQ.NEXTVAL, 'GFirst', '', 'GLast', 'GG', 'password', 'gg.@ss.com', 1234567890, '1', 'KL', SYSDATE);
INSERT INTO USERS VALUES(USER_ID_SEQ.NEXTVAL, 'HFirst', '', 'HLast', 'HH', 'password', 'hh.@ss.com', 1234567890, '1', 'AP', SYSDATE);
INSERT INTO USERS VALUES(USER_ID_SEQ.NEXTVAL, 'IFirst', '', 'ILast', 'II', 'password', 'ii.@ss.com', 1234567890, '1', 'KA', SYSDATE);
COMMIT;

DELETE FROM FOOD_ITEMS;
COMMIT;
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Biryanis', 'Chiken', ' This is special biryani prepared with ghee', 200, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Biryanis', 'Mutton', ' This is special biryani prepared with ghee', 200, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Biryanis', 'Prawn', ' This is special biryani prepared with ghee', 200, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Biryanis', 'ChikenMogalai', ' This is special biryani prepared with ghee', 200, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Biryanis', 'MixedMogalai', ' This is special biryani prepared with ghee', 200, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Biryanis', 'Crab', ' This is special biryani prepared with ghee', 200, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Biryanis', 'Chiken65', ' This is special biryani prepared with ghee', 200, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Biryanis', 'HyderabadChiken', ' This is special biryani prepared with ghee', 200, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Biryanis', 'Panner', ' This is special biryani prepared with ghee', 155, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Biryanis', 'Ghobi', ' This is special biryani prepared with ghee', 170, 0, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Biryanis', 'MixedVeg', ' This is special biryani prepared with ghee', 135, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Pizza', 'Panner', ' This is special pizza prepared with ghee with extra topins', 200, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Pizza', 'Mexican Green Wave', 'This is special pizza prepared with ghee with extra topins', 200, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Pizza', 'Deluxe Veggie', 'This is special pizza prepared with ghee with extra topins', 250, 1, SYSDATE);
INSERT INTO FOOD_ITEMS VALUES (ITEM_ID_SEQ.NEXTVAL, 'Pizza', 'PepperPanner', 'This is special pizza prepared with ghee with extra topins', 220, 1, SYSDATE);
COMMIT;

DELETE From ORDER_DETAILS;
COMMIT;
DELETE FROM ORDER_DETAILS;
COMMIT;

