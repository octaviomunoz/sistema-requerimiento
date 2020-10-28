INSERT INTO usuarios (rut, nombre, password) VALUES ('190086933', 'Octavio', '$2a$04$GJ85Ihcglhbqac2zc3z3A.C3v55FMmN8.qGQ8FlNBCuyLtQ5/TyMO');
INSERT INTO usuarios (rut, nombre, password) VALUES ('2', 'user2', '$2a$04$XWpgKkCQaVRuXjB5f1hzt.pDa2NAzntroH3bELICZy8R8Q0L0SShO');
INSERT INTO usuarios (rut, nombre, password) VALUES ('3', 'user3', '$2a$04$bmmWXec6YkFIesIxv2gx7.NbxRcMJ4UoRKT9Qoqk09pKegfcr3Zla');

INSERT INTO rol (descripcion, nombre) VALUES ('Rol Administrador', 'ADMIN');
INSERT INTO rol (descripcion, nombre) VALUES ('Rol Analista', 'ANALISTA');
INSERT INTO rol (descripcion, nombre) VALUES ('Rol Lider de Subproyecto', 'LIDER_SUBPROYECTO');
INSERT INTO rol (descripcion, nombre) VALUES ('Rol Jefe de Proyecto', 'JEFE_PROYECTO');
INSERT INTO rol (descripcion, nombre) VALUES ('Rol de Cliente', 'CLIENTE');
INSERT INTO rol (descripcion, nombre) VALUES ('Rol Usuario', 'USUARIO');

INSERT INTO usuario_roles (USER_ID, ROL_ID) VALUES (1, 1);
INSERT INTO usuario_roles (USER_ID, ROL_ID) VALUES (1, 2);
INSERT INTO usuario_roles (USER_ID, ROL_ID) VALUES (1, 3);
INSERT INTO usuario_roles (USER_ID, ROL_ID) VALUES (1, 4);
INSERT INTO usuario_roles (USER_ID, ROL_ID) VALUES (1, 5);
INSERT INTO usuario_roles (USER_ID, ROL_ID) VALUES (2, 2);

INSERT INTO proyectos (nombre, id_jefe_proyecto) VALUES ('Sistema de Tienda', 1);
