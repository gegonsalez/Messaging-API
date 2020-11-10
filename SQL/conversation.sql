-- -------------------------------------------------------------
-- TablePlus 2.8.2(256)
--
-- https://tableplus.com/
--
-- Database: postgres
-- Generation Time: 2019-08-30 13:48:48.5570
-- -------------------------------------------------------------


-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS conversation_conversation_id_seq;

-- Table Definition
CREATE TABLE "public"."conversation" (
    "conversation_id" int4 NOT NULL DEFAULT nextval('conversation_conversation_id_seq'::regclass),
    "user_one" int4 NOT NULL,
    "user_two" int4 NOT NULL,
    CONSTRAINT "conversation_user_one_fkey" FOREIGN KEY ("user_one") REFERENCES "public"."users"("user_id"),
    CONSTRAINT "conversation_user_two_fkey" FOREIGN KEY ("user_two") REFERENCES "public"."users"("user_id"),
    PRIMARY KEY ("conversation_id")
);

INSERT INTO "public"."conversation" ("conversation_id", "user_one", "user_two") VALUES ('1', '1', '2');
