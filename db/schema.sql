CREATE TABLE accident (
    id serial primary key,
    name varchar(2000),
    text varchar (2000),
    address varchar(1000)
);

create table type (
    id serial primary key,
    name varchar (500)
);

create table rule (
    id serial primary key,
    name varchar (500)
);