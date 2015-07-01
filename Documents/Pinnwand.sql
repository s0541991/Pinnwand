drop database if exists forum;

set foreign_key_checks = 0;
set foreign_key_checks = 1;
 
create database forum;
use forum;
 
create table benutzer(
id int not  null auto_increment,
nickname varchar(100)not null,
vorname varchar(100),
nachname varchar (100),
e_mail varchar(100)not null,
zeitstempel TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
primary key(id)
);

create table thread(
id int not  null auto_increment,
b_id int not null,
topic text not null,
datum TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
deadline date,
beschreibung text,
primary key (id),
foreign key (b_id) references benutzer (id) on update cascade on delete cascade
);
 
create table notiz(
id int not  null auto_increment,
b_id int not null,
t_id int not null,
kommentar text,
datum TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
primary key(id),
foreign key (b_id) references benutzer (id) on update cascade on delete cascade,
foreign key (t_id) references thread (id) on update cascade on delete cascade
);
 
select * from benutzer;
select * from notiz; 
select * from thread;