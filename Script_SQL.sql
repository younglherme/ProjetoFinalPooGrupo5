create table funcionarios (
    id_funcionario serial primary key,
    cpf_funcionario varchar(11) not null unique,
    nome_funcionario varchar(100) not null,
    data_nascimento_funcionario date not null,
    salario_bruto_funcionario float8 not null);

create table dependentes (
    id_dependente serial primary key,
    cpf_dependente varchar(11) not null unique,
    nome_dependente varchar(100) not null,
    data_nascimento_dependente date not null,
    parentesco_dependente varchar(50) not null,
    funcionario int not null references funcionarios (id_funcionario));

create table folha_pagamentos (
    id_folha_pagamento serial primary key,
    id_funcionario int not null references funcionarios (id_funcionario),
    data_pagamento date not null,
    desconto_inss float8 not null,
    desconto_ir float8 not null,
    salario_liquido float8 not null);

select * from funcionarios;
select * from dependentes;
select * from folha_pagamentos;