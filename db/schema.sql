CREATE TABLE accidents (
    id serial primary key;
    name varchar(2000),
    text varchar (2000),
    address varchar(1000),
    type_id int references types(id),
    rule_id int references rules(id)
);

create table types (
    id serial primary key,
    name varchar (500)
);

create table rules (
    id serial primary key,
    name varchar (500)
);