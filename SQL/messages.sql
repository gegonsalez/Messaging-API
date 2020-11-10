-- -------------------------------------------------------------
-- TablePlus 2.8.2(256)
--
-- https://tableplus.com/
--
-- Database: postgres
-- Generation Time: 2019-08-30 13:48:59.5150
-- -------------------------------------------------------------


-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS messages_message_id_seq;

-- Table Definition
CREATE TABLE "public"."messages" (
    "message_id" int4 NOT NULL DEFAULT nextval('messages_message_id_seq'::regclass),
    "conversation_id" int4 NOT NULL,
    "message_content" text NOT NULL,
    "user_id" int4 NOT NULL,
    CONSTRAINT "messages_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "public"."users"("user_id") ON DELETE CASCADE,
    CONSTRAINT "messages_conversation_id_fkey" FOREIGN KEY ("conversation_id") REFERENCES "public"."conversation"("conversation_id") ON DELETE CASCADE,
    PRIMARY KEY ("message_id")
);

INSERT INTO "public"."messages" ("message_id", "conversation_id", "message_content", "user_id") VALUES ('1', '1', '"Message 1"', '1'),
('2', '1', '"Message 2"', '2'),
('3', '1', '"Message 3"', '1'),
('4', '1', '"Message 4"', '2');
