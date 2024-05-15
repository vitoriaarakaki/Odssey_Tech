CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
	cpf VARCHAR(14) UNIQUE NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(20) NOT NULL,
    data_nascimento DATE,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    telefone VARCHAR(20),
    endereco VARCHAR(200),
    cidade VARCHAR(100),
    estado VARCHAR(100),
    pais VARCHAR(100),
    cep VARCHAR(20),
    sexo VARCHAR(10),
    preferencias TEXT,
    documento_identidade VARCHAR(50),
    nacionalidade VARCHAR(50),
    foto_perfil VARCHAR(255),
    notificacoes_ativadas BOOLEAN DEFAULT TRUE
);

SELECT * FROM planetas;


CREATE TABLE planetas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    distancia_sol FLOAT, -- em milhões de km
    massa FLOAT, -- em relação à Terra
    diametro FLOAT, -- em km
    gravidade FLOAT, -- em m/s²
    clima VARCHAR(100), -- Descrição geral do clima do planeta
    numero_luas INTEGER,
    tipo VARCHAR(50), -- (rochosos, gasosos, etc.)
    descoberta_em DATE,
    descoberto_por VARCHAR(100),
    foto VARCHAR(255), -- URL ou imagem?
    habitavel BOOLEAN DEFAULT FALSE,
    preco_viagem DECIMAL(10, 2),
    duracao_viagem INTEGER, -- em dias
    curiosidades_especiais TEXT
);




