CREATE TABLE simulacao (
    id SERIAL PRIMARY KEY,
    valor_total DOUBLE PRECISION NOT NULL
);

CREATE TABLE divida (
    id SERIAL PRIMARY KEY,
    valor DOUBLE PRECISION NOT NULL,
    simulacao_id BIGINT NULL,
    CONSTRAINT fk_divida_simulacao FOREIGN KEY (simulacao_id) REFERENCES simulacao(id) ON DELETE CASCADE
);

CREATE TABLE renegociacao (
    id SERIAL PRIMARY KEY,
    simulacao_id BIGINT UNIQUE NOT NULL,
    status VARCHAR(255) NOT NULL,
    CONSTRAINT fk_renegociacao_simulacao FOREIGN KEY (simulacao_id) REFERENCES simulacao(id) ON DELETE CASCADE
);
