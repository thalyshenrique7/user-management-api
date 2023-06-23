create table users(
                      id bigint not null auto_increment,
                      firstName varchar(50) not null,
                      secondName varchar(50) not null,
                      age int not null,
                      address varchar(60) not null,
                      cpf varchar(14) unique not null,
                      rg varchar(20) unique not null,
                      email varchar(50) unique not null,
                      primary key (id)
) engine=InnoDB default charset=utf8;