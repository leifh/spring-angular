INSERT INTO ROLE (ROLE) VALUES ('ROLE_USER');
INSERT INTO ROLE (ROLE) VALUES ('ROLE_ADMIN');
INSERT INTO USER (USERNAME, PASSWORD) VALUES ('user', '{noop}password1');
INSERT INTO USER (USERNAME, PASSWORD) VALUES ('admin', '{noop}password2');
INSERT INTO USER_ROLES (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO USER_ROLES (USER_ID, ROLE_ID) VALUES (2, 2);
