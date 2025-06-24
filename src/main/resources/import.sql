-- Cursos
INSERT INTO cursos (nombre, creditos) VALUES ('Programmer', 5);
INSERT INTO cursos (nombre, creditos) VALUES ('Developer', 5);
INSERT INTO cursos (nombre, creditos) VALUES ('Expert', 5);

-- Usuarios
INSERT INTO users (id, username, password, enabled) VALUES (1, 'rcoello', '$2a$10$uSrNaB4XMjVhRoEi/lESD./UVa8Gmvo1fEH.ecIOTE/pINxA.Liqe', true);
INSERT INTO users (id, username, password, enabled) VALUES (2, 'admin', '$2a$10$YBGqUhqhEKES/fincckKUe4lI/w/iiOFmtjcEfvr13MGP9qMzEd/i', true);

-- Roles (authorities)
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_USER');

-- Alumnos
INSERT INTO alumnos (nombres, apellidos, fecha_nacimiento, correo, telefono, carrera) VALUES ('Juan', 'Pérez', '2000-05-15', 'juan.perez@example.com', '987654321', 'Ingeniería de Sistemas');
INSERT INTO alumnos (nombres, apellidos, fecha_nacimiento, correo, telefono, carrera) VALUES ('María', 'González', '1998-03-22', 'maria.gonzalez@example.com', '912345678', 'Ingeniería Industrial');
INSERT INTO alumnos (nombres, apellidos, fecha_nacimiento, correo, telefono, carrera) VALUES ('Carlos', 'Ramírez', '1995-11-30', 'carlos.ramirez@example.com', '123456789', 'Ingeniería Mecatrónica');
