create database Event;
use Event;

create table event(
id INT AUTO_INCREMENT primary key,
title VARCHAR(250) not null,
content VARCHAR(250) not null,
term date,
timeStart VARCHAR(250),
timeEnd VARCHAR(250)
);

create table user(
id INT auto_increment primary key,
active boolean default true,
email VARCHAR(250) not null,
name VARCHAR(250) not null,
surname VARCHAR(250) not null,
password VARCHAR(250) not null,
role VARCHAR(250) default 'user'

);

#create table role(
#id INT primary key,
#name VARCHAR(250) default 'user'
#);


Drop table event;
Drop table user;


insert into Event (id,title,content,term,timeStart,timeEnd) values (1,'Auta','Wystawa samochodowa','2018-01-25','10:00','18:00');
#insert into Event (id,title,content, startDate, startTime, endTime) values (2,'Auta2','Wystawa samochodowa2','2018-01-26','09:00:00','18:00:00');
#insert into Event (id,title,content, startDate, startTime, endTime) values (3,'Auta3','Wystawa samochodowa3','2018-01-27','09:00:00','18:00:00');

insert into user (id,active,email,name,surname,password,role)values (1,true,'user','user','user','user','user');
insert into user (id,active,email,name,surname,password,role)values (2,true,'admin','admin','admin','admin','admin');

insert into role ( id,name) values(1,'user');
insert into role ( id,name) values(2,'admin');
Select email, password, active from user where email = 'user';
select u.email, r.name from user u inner join user_role ur on u.id=ur.user_id inner join role r on r.id=ur.roles_id where u.email='MT@wp.pl';

select email, role from user where email = 'user';
select * from event;
select * from user;
select * from role;

