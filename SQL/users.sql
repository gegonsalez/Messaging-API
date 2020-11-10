-- -------------------------------------------------------------
-- TablePlus 2.8.2(256)
--
-- https://tableplus.com/
--
-- Database: postgres
-- Generation Time: 2019-08-30 13:49:08.9470
-- -------------------------------------------------------------


-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS users_id_seq;

-- Table Definition
CREATE TABLE "public"."users" (
    "user_id" int4 NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    "firstname" varchar(40) NOT NULL,
    "lastname" varchar(40) NOT NULL,
    "email" varchar(40) NOT NULL,
    PRIMARY KEY ("user_id")
);

INSERT INTO "public"."users" ("user_id", "firstname", "lastname", "email") VALUES ('1', 'Gerardo', 'Gonsalez', 'gerardo@mail.com'),
('2', 'Elon', 'Musk', 'elonm@email.com');
