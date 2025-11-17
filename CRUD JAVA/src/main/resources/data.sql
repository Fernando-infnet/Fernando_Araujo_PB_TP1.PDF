
CREATE TABLE conta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    saldo DECIMAL(10,2)
);

INSERT INTO conta (nome, saldo) VALUES ('LP', 100.0);
INSERT INTO conta (nome, saldo) VALUES ('FM', 200.0);
INSERT INTO conta (nome, saldo) VALUES ('ML', 300.0);