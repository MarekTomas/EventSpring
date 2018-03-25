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


Drop table event;
Drop table user;
Drop table role;
drop table user_role;


insert into Event (id,title,content,term,tstart,tend) values (1,'Auta','10:00','2018-01-25','10:00:00','19:00:15');
insert into Event (id,title,content,term,tstart,tend) values (2,'Auta','Wystawa samochodowa','2018-01-26','10:00:00','19:00:15');


insert into user (id,active,email,name,surname,password)values (1,true,'user','user','user','user');
insert into user (id,active,email,name,surname,password)values (2,true,'admin','admin','admin','admin');

insert into role ( id,name) values(1,'user');
insert into role ( id,name) values(2,'admin');

insert into user_role(user_id,roles_id) value(1,1);
insert into user_role(user_id,roles_id) value(2,2);

Select email, password, active from user where email = 'user';

select u.email, u.name from user u inner join user_role ur on u.id=ur.user_id inner join role r on r.id=ur.roles_id where email = 'admin';


select * from event;
select * from user;
select * from role;
select * from user_role;

