CREATE TABLE produto (id_produto SERIAL PRIMARY KEY,
nome varchar(30) NOT NULL,
descricao varchar(100),
qtd_estoque INTEGER NOT NULL,
data_cadastro DATE,
valor_unitario FLOAT NOT NULL, 
urlImagem NOT NULL,
id_categoria INTEGER, FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria));