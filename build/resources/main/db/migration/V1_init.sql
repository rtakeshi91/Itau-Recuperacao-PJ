CREATE TABLE divida (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor DOUBLE NOT NULL,
    simulacao_id BIGINT,
    FOREIGN KEY (simulacao_id) REFERENCES simulacao(id) ON DELETE CASCADE
);

CREATE TABLE simulacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor_total DOUBLE NOT NULL
);

CREATE TABLE renegociacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    simulacao_id BIGINT UNIQUE,
    status VARCHAR(255) NOT NULL,
    FOREIGN KEY (simulacao_id) REFERENCES simulacao(id) ON DELETE CASCADE
);
