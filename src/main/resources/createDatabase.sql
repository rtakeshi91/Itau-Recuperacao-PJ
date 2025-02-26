CREATE DATABASE recuperacao_credito;
USE recuperacao_credito;

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin123';
GRANT ALL PRIVILEGES ON recuperacao_credito.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;
