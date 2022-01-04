CREATE TABLE tb_genero(
id BIGINT AUTO_INCREMENT PRIMARY KEY ,
nome VARCHAR(255) NOT NULL
);

CREATE TABLE tb_plataforma(
id BIGINT AUTO_INCREMENT PRIMARY KEY ,
nome VARCHAR(255) NOT NULL,
valor DECIMAL(19, 2),
ano_lancamento INTEGER
);

CREATE TABLE tb_jogo(
id BIGINT AUTO_INCREMENT PRIMARY KEY ,
nome VARCHAR(255) NOT NULL,
data_lancamento DATE,
descricao VARCHAR(255),
valor DECIMAL(19,2),
genero_id BIGINT NOT NULL,
FOREIGN KEY (genero_id) REFERENCES tb_genero(id)
);

CREATE TABLE tb_jogo_plataforma(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
jogo_id BIGINT,
plataforma_id BIGINT,
FOREIGN KEY(jogo_id) REFERENCES tb_jogo(id),
FOREIGN KEY(plataforma_id) REFERENCES tb_plataforma(id)
)

