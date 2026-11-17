
-- Crear nuestra base de datos
CREATE DATABASE IF NOT EXISTS smash_bros_db;

-- Seleccionar la base de datos
USE smash_bros_db;

-- Verificar la base de datos seleccionada
SELECT DATABASE();



SELECT * FROM personaje;

SELECT * FROM torneo;

SELECT * FROM participacion;

SELECT
    p.id,
    per.nombre AS personaje,
    t.nombre AS torneo,
    p.posicion,
    p.puntos
FROM participacion p
INNER JOIN personaje per
    ON p.personaje_id = per.id
INNER JOIN torneo t
    ON p.torneo_id = t.id;




    