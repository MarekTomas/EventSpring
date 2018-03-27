create database Event;
use Event;

create table event(
id bigint(20) AUTO_INCREMENT primary key,
title VARCHAR(250) not null,
content VARCHAR(250) not null,
term date,
tstart time not null,
tend time not null
);

create table user(
id int(11) AUTO_INCREMENT primary key,
active boolean default true,
email VARCHAR(250) not null,
name VARCHAR(250) not null,
surname VARCHAR(250) not null,
password VARCHAR(250) not null
);

create table role(
id int(11) primary key,
name VARCHAR(250) default 'user'
);

create table user_role(
user_id int(11) primary key,
roles_id int
);


#Drop table event;
#Drop table user;
#Drop table role;
#drop table user_role;


insert into Event (id,title,content,term,tstart,tend) values (1,'Wystawa','Samochody rajdowe','2018-05-24','10:00:00','19:00:15');
insert into Event (id,title,content,term,tstart,tend) values (2,'Wyścigi','Wyścigi konne','2018-05-26','10:00:00','15:00:00');
insert into Event (id,title,content,term,tstart,tend) values (3,'Koncert','Krzysztof Krawczyk śpiewa','2018-05-26','18:00:00','21:00:00');
insert into Event (id,title,content,term,tstart,tend) values (4,'Wystawa','Koty rasowe','2018-05-27','10:00:00','16:00:00');
insert into Event (id,title,content,term,tstart,tend) values (5,'Wystawa','Psy myśliwskie','2018-05-28','10:00:00','16:00:00');
insert into Event (id,title,content,term,tstart,tend) values (6,'Wyścigi','Formuła F1','2018-05-29','08:00:00','11:00:00');
insert into Event (id,title,content,term,tstart,tend) values (7,'Koncert','Blues Brothers','2018-05-30','20:00:00','22:00:00');


insert into user (id,active,email,name,surname,password)values (1,true,'user','user','user','user');
insert into user (id,active,email,name,surname,password)values (2,true,'admin','admin','admin','admin');
insert into user (id,active,email,name,surname,password)values (3,true,'ak@wp.pl','Andrzej','Kowalski','andrzejkowalski1');
insert into user (id,active,email,name,surname,password)values (4,true,'pn@wp.pl','Piotr','Niewiadomski','piotrniewiadomski1');

insert into role ( id,name) values(1,'user');
insert into role ( id,name) values(2,'admin');

insert into user_role(user_id,roles_id) value(1,1);
insert into user_role(user_id,roles_id) value(2,2);
insert into user_role(user_id,roles_id) value(3,1);
insert into user_role(user_id,roles_id) value(4,1);

select * from event;
select * from user;
select * from role;
select * from user_role;

