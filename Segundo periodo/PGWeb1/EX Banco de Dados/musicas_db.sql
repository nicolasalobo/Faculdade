CREATE DATABASE IF NOT EXISTS musicas_db CHARACTER
SET
    utf8mb4 COLLATE utf8mb4_unicode_ci;

USE musicas_db;

CREATE TABLE
    IF NOT EXISTS musica (
        id_musica INT AUTO_INCREMENT PRIMARY KEY,
        titulo VARCHAR(100) NOT NULL,
        duracao FLOAT,
        compositor VARCHAR(100),
        album VARCHAR(100)
    );