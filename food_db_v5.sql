--------------------------------------------------------
--  File created - Wednesday-April-21-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence request_seq
--------------------------------------------------------

   CREATE SEQUENCE  "request_seq"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence manager_seq
--------------------------------------------------------

   CREATE SEQUENCE  "manager_seq"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence item_seq
--------------------------------------------------------

   CREATE SEQUENCE  "item_seq"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence customer_seq
--------------------------------------------------------

   CREATE SEQUENCE  "customer_seq"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence coupon_seq
--------------------------------------------------------

   CREATE SEQUENCE  "coupon_seq"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table REQUEST
--------------------------------------------------------

  CREATE TABLE "REQUEST" 
   (	"ID" NUMBER(19,0), 
	"DETAIL" VARCHAR2(2000 BYTE), 
	"STATUS" NUMBER(1,0) DEFAULT 1, 
	"REQUEST_TIME" TIMESTAMP (6), 
	"RECYCLE" NUMBER(1,0),
	"TOTAL_PRICE" NUMBER(10,2),
	"DELIVER_ADDRESS" VARCHAR2(250 BYTE),
	"CUSTOMER_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ITEM
--------------------------------------------------------

  CREATE TABLE "ITEM" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(250 BYTE), 
	"DESCRIPTION" VARCHAR2(250 BYTE), 
	"IMAGE" BLOB, 
	"PRICE" NUMBER(8,2), 
	"IN_STOCK" NUMBER(1,0) DEFAULT 1, 
	"IMAGEBASE" VARCHAR2(255 BYTE), 
	"UNIT" VARCHAR2(15)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 LOB ("IMAGE") STORE AS BASICFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;

 INSERT INTO ITEM(ID, NAME, DESCRIPTION, IMAGE, PRICE, IN_STOCK, IMAGEBASE, UNIT) VALUES 
 (1, 'Chicken Tikka Masala', 'Delicious, buttery chicken', utl_raw.cast_to_raw('ASFIPNOIFA631S'), 50, 1, null, 'kg');
  INSERT INTO ITEM(ID, NAME, DESCRIPTION, IMAGE, PRICE, IN_STOCK, IMAGEBASE, UNIT) VALUES 
 (2, 'Naan', 'Fresh from the oven', utl_raw.cast_to_raw('ASFIPNOIFA631S'), 5, 1, null, 'pcs');
  INSERT INTO ITEM(ID, NAME, DESCRIPTION, IMAGE, PRICE, IN_STOCK, IMAGEBASE, UNIT) VALUES 
 (3, 'Cooked Basmati Rice', 'Traditionally cooked with no additives', utl_raw.cast_to_raw('ASFIPNOIFA631S'), 36.5, 1, null, 'kg');
  INSERT INTO ITEM(ID, NAME, DESCRIPTION, IMAGE, PRICE, IN_STOCK, IMAGEBASE, UNIT) VALUES 
 (4, 'Sprite', 'Classic lemon taste', utl_raw.cast_to_raw('ASFIPNOIFA631S'), 7.7, 1, null, 'l');
 INSERT INTO ITEM(ID, NAME, DESCRIPTION, IMAGE, PRICE, IN_STOCK, IMAGEBASE, UNIT) VALUES 
 (5, 'Sprite But Not Available', 'Classic lemon taste', utl_raw.cast_to_raw('ASFIPNOIFA631S'), 7.7, 0, null, 'l');
--------------------------------------------------------
--  DDL for Table CUSTOMER
--------------------------------------------------------

  CREATE TABLE "CUSTOMER" 
   (	"ID" NUMBER(19,0), 
	"NAME" VARCHAR2(45 BYTE), 
	"EMAIL" VARCHAR2(45 BYTE), 
	"ADDRESS" VARCHAR2(255 BYTE), 
	"IS_BANNED" NUMBER(3,0), 
	"USERNAME" VARCHAR2(45 BYTE), 
	"PASSWORD" VARCHAR2(255 BYTE), 
	"PHONE_NUMBER" VARCHAR2(255 BYTE), 
	"DOB" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table COUPON
--------------------------------------------------------

  CREATE TABLE "COUPON" 
   (	"ID" NUMBER, 
	"CODE" CHAR(6 BYTE), 
	"DESCRIPTION" VARCHAR2(250 BYTE), 
	"RATE" NUMBER(5,2), 
	"MIN_ORDER_PRICE" NUMBER(8,0), 
	"MAX_REDUCTION_PRICE" NUMBER(8,0), 
	"EXPIRED_DATE" DATE, 
	"CURRENT_USAGE_COUNT" NUMBER, 
	"MAX_USAGE_COUNT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

  INSERT INTO COUPON(ID, CODE, DESCRIPTION, RATE, MIN_ORDER_PRICE, MAX_REDUCTION_PRICE, EXPIRED_DATE, CURRENT_USAGE_COUNT, MAX_USAGE_COUNT) 
  VALUES(1, 'ORCL30', 'Oracle Coupon To Test', 30, 100, 1000, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 0, 10);
  INSERT INTO COUPON(ID, CODE, DESCRIPTION, RATE, MIN_ORDER_PRICE, MAX_REDUCTION_PRICE, EXPIRED_DATE, CURRENT_USAGE_COUNT, MAX_USAGE_COUNT) 
  VALUES(2, 'ORCL10', 'Oracle Coupon To Test', 10, 100, 7, TO_DATE('2029/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 0, 10);
--------------------------------------------------------
--  DDL for Table MANAGER
--------------------------------------------------------

  CREATE TABLE "MANAGER" 
   (	"ID" NUMBER, 
	"USERNAME" VARCHAR2(250 BYTE), 
	"PASSWORD" VARCHAR2(250 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
-- REM INSERTING into REQUEST
-- SET DEFINE OFF;
-- Insert into REQUEST (ID,DETAIL,STATUS,REQUEST_TIME,CUSTOMER_ID) values (21,'order1',1,to_timestamp('13-NOV-12 10.13.18.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),1);
-- Insert into REQUEST (ID,DETAIL,STATUS,REQUEST_TIME,CUSTOMER_ID) values (22,'order1',1,to_timestamp('13-NOV-20 10.12.18.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),1);
-- Insert into REQUEST (ID,DETAIL,STATUS,REQUEST_TIME,CUSTOMER_ID) values (1,'order',0,to_timestamp('13-DEC-03 10.13.18.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),1);



REM INSERTING into CUSTOMER
SET DEFINE OFF;
Insert into CUSTOMER (ID,NAME,EMAIL,ADDRESS,IS_BANNED,USERNAME,PASSWORD,PHONE_NUMBER,DOB) values (111,'Vuong Linh','linhlike@gmail.com','HCM City',0,'linh','63183882683118731158998011453284076468335966576048951949743124536273742459924','12345678',to_date('23-APR-26','DD-MON-RR'));
Insert into CUSTOMER (ID,NAME,EMAIL,ADDRESS,IS_BANNED,USERNAME,PASSWORD,PHONE_NUMBER,DOB) values (1,'Duong Quan','quan@gmail.com','Ha noi',0,'quan','64042235640975155117310274771932083755136637533499687061408327255432019864722','1234567',to_date('21-NOV-99','DD-MON-RR'));
Insert into CUSTOMER (ID,NAME,EMAIL,ADDRESS,IS_BANNED,USERNAME,PASSWORD,PHONE_NUMBER,DOB) values (103,'Do Minh Ha','ha@gmail.com','Ha Noi',0,'ha','123456','12345678',to_date('12-APR-00','DD-MON-RR'));
REM INSERTING into COUPON
SET DEFINE OFF;
Insert into COUPON (ID,CODE,DESCRIPTION,RATE,MIN_ORDER_PRICE,MAX_REDUCTION_PRICE,EXPIRED_DATE,CURRENT_USAGE_COUNT,MAX_USAGE_COUNT) values (1,'vnc234    ','new year coupon',0.4,1,100,to_date('12-MAR-21','DD-MON-RR'),1,50);
REM INSERTING into MANAGER
SET DEFINE OFF;
Insert into MANAGER (ID,USERNAME,PASSWORD) values (1,'quan','64042235640975155117310274771932083755136637533499687061408327255432019864722');
--------------------------------------------------------
--  DDL for Index SYS_C007847
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007847" ON "REQUEST" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007853
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007853" ON "ITEM" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007842
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007842" ON "CUSTOMER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007860
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007860" ON "COUPON" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007865
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007865" ON "MANAGER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger coupon_seq_tr
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "coupon_seq_tr" 
 BEFORE INSERT ON Coupon FOR EACH ROW
  WHEN (NEW.id IS NULL) BEGIN
 SELECT "coupon_seq".NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
ALTER TRIGGER "coupon_seq_tr" ENABLE;
--------------------------------------------------------
--  DDL for Trigger request_seq_tr
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "request_seq_tr" 
 BEFORE INSERT ON Request FOR EACH ROW
  WHEN (NEW.id IS NULL) BEGIN
 SELECT "request_seq".NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
ALTER TRIGGER "request_seq_tr" ENABLE;
--------------------------------------------------------
--  DDL for Trigger manager_seq_tr
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "manager_seq_tr" 
 BEFORE INSERT ON Manager FOR EACH ROW
  WHEN (NEW.id IS NULL) BEGIN
 SELECT "manager_seq".NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
ALTER TRIGGER "manager_seq_tr" ENABLE;
--------------------------------------------------------
--  DDL for Trigger item_seq_tr
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "item_seq_tr" 
 BEFORE INSERT ON Item FOR EACH ROW
  WHEN (NEW.id IS NULL) BEGIN
 SELECT "item_seq".NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
ALTER TRIGGER "item_seq_tr" ENABLE;
--------------------------------------------------------
--  DDL for Trigger customer_seq_tr
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "customer_seq_tr" 
 BEFORE INSERT ON customer FOR EACH ROW
  WHEN (NEW.id IS NULL) BEGIN
 SELECT "customer_seq".NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
ALTER TRIGGER "customer_seq_tr" ENABLE;
--------------------------------------------------------
--  DDL for Trigger request_seq_tr
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "request_seq_tr" 
 BEFORE INSERT ON Request FOR EACH ROW
  WHEN (NEW.id IS NULL) BEGIN
 SELECT "request_seq".NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
ALTER TRIGGER "request_seq_tr" ENABLE;
--------------------------------------------------------
--  DDL for Trigger item_seq_tr
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "item_seq_tr" 
 BEFORE INSERT ON Item FOR EACH ROW
  WHEN (NEW.id IS NULL) BEGIN
 SELECT "item_seq".NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
ALTER TRIGGER "item_seq_tr" ENABLE;
--------------------------------------------------------
--  DDL for Trigger customer_seq_tr
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "customer_seq_tr" 
 BEFORE INSERT ON customer FOR EACH ROW
  WHEN (NEW.id IS NULL) BEGIN
 SELECT "customer_seq".NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
ALTER TRIGGER "customer_seq_tr" ENABLE;
--------------------------------------------------------
--  DDL for Trigger coupon_seq_tr
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "coupon_seq_tr" 
 BEFORE INSERT ON Coupon FOR EACH ROW
  WHEN (NEW.id IS NULL) BEGIN
 SELECT "coupon_seq".NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
ALTER TRIGGER "coupon_seq_tr" ENABLE;
--------------------------------------------------------
--  DDL for Trigger manager_seq_tr
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "manager_seq_tr" 
 BEFORE INSERT ON Manager FOR EACH ROW
  WHEN (NEW.id IS NULL) BEGIN
 SELECT "manager_seq".NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
ALTER TRIGGER "manager_seq_tr" ENABLE;
--------------------------------------------------------
--  DDL for Function CUSTOM_AUTH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "CUSTOM_AUTH" (p_username in VARCHAR2, p_password in VARCHAR2)
return BOOLEAN
is
  l_password varchar2(4000);
  l_stored_password varchar2(4000);
  l_expires_on date;
  l_count number;
begin
-- First, check to see if the user is in the user table
select count(*) into l_count from demo_users where user_name = p_username;
if l_count > 0 then
  -- First, we fetch the stored hashed password & expire date
  select password, expires_on into l_stored_password, l_expires_on
   from demo_users where user_name = p_username;

  -- Next, we check to see if the user's account is expired
  -- If it is, return FALSE
  if l_expires_on > sysdate or l_expires_on is null then

    -- If the account is not expired, we have to apply the custom hash
    -- function to the password
    l_password := custom_hash(p_username, p_password);

    -- Finally, we compare them to see if they are the same and return
    -- either TRUE or FALSE
    if l_password = l_stored_password then
      return true;
    else
      return false;
    end if;
  else
    return false;
  end if;
else
  -- The username provided is not in the DEMO_USERS table
  return false;
end if;
end;

/
--------------------------------------------------------
--  DDL for Function CUSTOM_HASH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "CUSTOM_HASH" (p_username in varchar2, p_password in varchar2)
return varchar2
is
  l_password varchar2(4000);
  l_salt varchar2(4000) := 'QPTWJ9THR4Y7YRKB7S8QWLJWRUG96R';
begin

-- This function should be wrapped, as the hash algorhythm is exposed here.
-- You can change the value of l_salt or the method of which to call the
-- DBMS_OBFUSCATOIN toolkit, but you much reset all of your passwords
-- if you choose to do this.

l_password := utl_raw.cast_to_raw(dbms_obfuscation_toolkit.md5
  (input_string => p_password || substr(l_salt,10,13) || p_username ||
    substr(l_salt, 4,10)));
return l_password;
end;

/
--------------------------------------------------------
--  Constraints for Table REQUEST
--------------------------------------------------------

  ALTER TABLE "REQUEST" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "REQUEST" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE);
  ALTER TABLE "REQUEST" MODIFY ("REQUEST_TIME" NOT NULL ENABLE);
  ALTER TABLE "REQUEST" MODIFY ("DETAIL" NOT NULL ENABLE);
  ALTER TABLE "REQUEST" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ITEM
--------------------------------------------------------

  ALTER TABLE "ITEM" MODIFY ("UNIT" NOT NULL ENABLE);
  ALTER TABLE "ITEM" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ITEM" MODIFY ("IN_STOCK" NOT NULL ENABLE);
  ALTER TABLE "ITEM" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "ITEM" MODIFY ("NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CUSTOMER
--------------------------------------------------------

  ALTER TABLE "CUSTOMER" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "CUSTOMER" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "CUSTOMER" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "CUSTOMER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "CUSTOMER" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table COUPON
--------------------------------------------------------

  ALTER TABLE "COUPON" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "COUPON" MODIFY ("EXPIRED_DATE" NOT NULL ENABLE);
  ALTER TABLE "COUPON" MODIFY ("MAX_REDUCTION_PRICE" NOT NULL ENABLE);
  ALTER TABLE "COUPON" MODIFY ("MIN_ORDER_PRICE" NOT NULL ENABLE);
  ALTER TABLE "COUPON" MODIFY ("RATE" NOT NULL ENABLE);
  ALTER TABLE "COUPON" MODIFY ("CODE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MANAGER
--------------------------------------------------------

  ALTER TABLE "MANAGER" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MANAGER" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "MANAGER" MODIFY ("USERNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table REQUEST
--------------------------------------------------------

  ALTER TABLE "REQUEST" ADD CONSTRAINT "FK_CUSTOMER_REQUEST" FOREIGN KEY ("CUSTOMER_ID")
	  REFERENCES "CUSTOMER" ("ID") ON DELETE CASCADE ENABLE;
