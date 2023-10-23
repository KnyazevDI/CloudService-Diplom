create schema Diplom;

create table Diplom.users (
            id int auto_increment not null primary key ,
            login varchar(255) not null,
            password varchar(255) not null ,
            token varchar(255) default null
);

insert into Diplom.users (login, password)
values ('Ivan@mail.ru', 'SXZhbjEyMw==');

insert into Diplom.users (login, password)
values ('Petr@mail.ru', 'UGV0cjIzNA==');

