INSERT INTO "tb_user" ("name", "email", "password") VALUES ('Eduardo', 'eduardo@gmail.com', '123');
INSERT INTO "tb_user" ("name", "email", "password") VALUES ('Camila', 'camila@gmail.com', '123');
INSERT INTO "tb_user" ("name", "email", "password") VALUES ('Leonardo', 'leonardo@gmail.com', '123');
INSERT INTO "tb_user" ("name", "email", "password") VALUES ('Rafael', 'rafael@gmail.com', '123');

INSERT INTO "tb_role" ("authority") VALUES ('ROLE_ADMIN');
INSERT INTO "tb_role" ("authority") VALUES ('ROLE_VISITOR');

INSERT INTO "tb_user_role" ("user_id", "role_id") VALUES (1, 1);
INSERT INTO "tb_user_role" ("user_id", "role_id") VALUES (2, 2);