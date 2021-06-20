--------------------------------------------------------
--  ÉtÉ@ÉCÉãÇçÏê¨ÇµÇ‹ÇµÇΩ - ì˙ójì˙-6åé-06-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BORAD
--------------------------------------------------------

  CREATE TABLE "AIMAX"."BORAD" 
   (	"RES_NAME" VARCHAR2(40 BYTE), 
	"SESSION_ID" VARCHAR2(40 BYTE), 
	"RES_WRITE" VARCHAR2(1000 BYTE), 
	"RES_DATE" VARCHAR2(21 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
