INSERT INTO tb_genero(nome)
VALUES
('Aventura'),
('RPG'),
('Ação'),
('Simulador'),
('Esporte');

INSERT INTO tb_plataforma(nome, valor, ano_lancamento)
VALUES('Xbox Series S', '2600', '2020'),
('Playstation 5', '4600', '2020'),
('Nintendo Switch', '2000', '2017');

INSERT INTO tb_jogo(nome, data_lancamento, descricao, valor, genero_id)
VALUES
('Rachet and Clank', '2021-03-03', 'Rachet em uma aventura', '200', '1'),
('Age of Empires IV', '2021-10-10', 'Simulador de guerra', '200', '4'),
('Zelda Breath of the Wild', '2017-03-03', 'Novo Zelda', '200', '1'),
('Fifa 21', '2021-03-03', 'Jogo de futebol', '200', '5');

INSERT INTO tb_jogo_plataforma(jogo_id, plataforma_id)
VALUES
('1' , '2'),
('2', '1'),
('3', '3'),
('4', '1'),
('4', '2'),
('4', '3');

