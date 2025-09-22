create table funcionario (
    id_funcionario serial primary key,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    data_nascimento date not null,
    salario_bruto float8 not null);

CREATE TABLE dependente (
    id_dependente serial primary key,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    data_nascimento date not null,
    parentesco varchar(50) not null,
    id_funcionario int not null references funcionario (id_funcionario));

create table folha_pagamento (
    id_folha serial primary key,
    id_funcionario int not null references funcionario (id_funcionario),
    data_pagamento date not null,
    desconto_inss float8 not null,
    desconto_ir float8 not null,
    salario_liquido float8 not null);


INSERT INTO funcionario (nome, cpf, data_nascimento, salario_bruto) VALUES
('João Silva', '12345678900', '1985-03-15', 3500.00),
('Maria Santos', '98765432100', '1990-07-22', 4200.50),
('Pedro Oliveira', '45678912300', '1988-11-30', 2850.75),
('Ana Costa', '32165498700', '1992-05-14', 3800.00),
('Carlos Pereira', '78912345600', '1983-12-03', 5200.25),
('Juliana Rodrigues', '65498732100', '1995-02-18', 3100.00),
('Ricardo Almeida', '15975348600', '1987-09-10', 4500.80),
('Fernanda Lima', '35795182400', '1991-06-25', 3950.40),
('Marcos Souza', '25836914700', '1980-08-12', 6800.00),
('Patrícia Martins', '74185296300', '1993-04-05', 3650.90);


select * from funcionario;
select * from dependente;
select * from folha_pagamento;