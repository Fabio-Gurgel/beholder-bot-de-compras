CREATE TABLE solicitacao_de_busca (
    id SERIAL PRIMARY KEY,
    nome_produto VARCHAR(255) NOT NULL,
    preco_esperado NUMERIC(15,2) NOT NULL
);

CREATE TABLE produto_encontrado (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco NUMERIC(15,2) NOT NULL,
    link_para_compra VARCHAR(1000) NOT NULL
);

CREATE TABLE relatorio_de_produtos (
    id SERIAL PRIMARY KEY,
    solicitacao_id BIGINT NOT NULL REFERENCES solicitacao_de_busca(id) ON DELETE CASCADE,
    total_encontrados INT NOT NULL,
    produto_menor_preco_id BIGINT REFERENCES produto_encontrado(id),
    produto_maior_preco_id BIGINT REFERENCES produto_encontrado(id),
    preco_medio NUMERIC(15,2) NOT NULL
);

CREATE TABLE relatorio_produtos_abaixo_preco (
    relatorio_id BIGINT NOT NULL REFERENCES relatorio_de_produtos(id) ON DELETE CASCADE,
    produto_id BIGINT NOT NULL REFERENCES produto_encontrado(id) ON DELETE CASCADE,
    PRIMARY KEY (relatorio_id, produto_id)
);

CREATE TABLE relatorio_produtos_acima_preco (
    relatorio_id BIGINT NOT NULL REFERENCES relatorio_de_produtos(id) ON DELETE CASCADE,
    produto_id BIGINT NOT NULL REFERENCES produto_encontrado(id) ON DELETE CASCADE,
    PRIMARY KEY (relatorio_id, produto_id)
);
