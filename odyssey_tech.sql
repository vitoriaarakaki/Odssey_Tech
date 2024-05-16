CREATE TABLE viagens (
    id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL REFERENCES clientes(id),
    planeta_id INTEGER NOT NULL REFERENCES planetas(id),
    data_viagem DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    numero_passageiros INTEGER NOT NULL,
    observacoes TEXT
);

SELECT * FROM viagens;

CREATE TABLE reservas (
    id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL REFERENCES clientes(id),
    viagem_id INTEGER NOT NULL REFERENCES viagens(id),
    data_reserva DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    quantidade_passageiros INTEGER NOT NULL,
    observacoes TEXT
);

SELECT * FROM reservas;

CREATE TABLE promocoes (
    id SERIAL PRIMARY KEY,
    viagem_id INTEGER NOT NULL REFERENCES viagens(id),
    descricao TEXT NOT NULL,
    desconto DECIMAL(5, 2) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    condicoes TEXT
);

SELECT * FROM promocoes;