create table usuarios(

                        id bigint not null GENERATED ALWAYS AS IDENTITY,
                        login varchar(100) not null,
                        senha varchar(255) not null,

                        primary key(id)

);