DROP TABLE IF EXISTS simulacao_divida;
DROP TABLE IF EXISTS renegociacao;
DROP TABLE IF EXISTS simulacao;
DROP TABLE IF EXISTS divida;

-- Tabela divida
CREATE TABLE divida (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor DOUBLE NOT NULL
);

-- Tabela simulacao
CREATE TABLE simulacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor_total DOUBLE NOT NULL
);

-- Tabela simulacao_divida (relacionamento muitos-para-muitos)
CREATE TABLE simulacao_divida (
    simulacao_id BIGINT,
    divida_id BIGINT,
    PRIMARY KEY (simulacao_id, divida_id),
    FOREIGN KEY (simulacao_id) REFERENCES simulacao(id) ON DELETE CASCADE,
    FOREIGN KEY (divida_id) REFERENCES divida(id) ON DELETE CASCADE
);

-- Tabela renegociacao
CREATE TABLE renegociacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    simulacao_id BIGINT UNIQUE,
    status VARCHAR(255) NOT NULL,
    FOREIGN KEY (simulacao_id) REFERENCES simulacao(id) ON DELETE CASCADE
);

-- Inserir dívidas
INSERT INTO divida (valor) VALUES
(1000.50),
(2500.75),
(500.00),
(7500.25),
(1200.00),
(3000.99),
(450.80),
(800.40),
(9999.99),
(150.75);

-- Inserir simulação (por exemplo, a simulação com id 1)
INSERT INTO simulacao (valor_total) VALUES (15000.00);

-- Associar dívidas à simulação (exemplo, associando dívidas com id 1, 2 e 3 à simulação com id 1)
INSERT INTO simulacao_divida (simulacao_id, divida_id) VALUES
(1, 1),
(1, 2),
(1, 3);