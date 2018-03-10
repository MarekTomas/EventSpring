create database Event;
use Event;

create table Event(
id INT AUTO_INCREMENT,
title VARCHAR(250) not null,
content VARCHAR(250) not null,
primary key (id)
);

create table user(
id INT auto_increment,
name VARCHAR(250) not null,
surname VARCHAR(250) not null,
login VARCHAR(250) not null,
password VARCHAR(250) not null,
role VARCHAR(250) not null default 'user',
primary key (id)
);

Drop table event;

insert into Event (id,title,content) values (1,'Auta','Wystawa samochodowa');
#insert into Event (id,title,content, startDate, startTime, endTime) values (2,'Auta2','Wystawa samochodowa2','2018-01-26','09:00:00','18:00:00');
#insert into Event (id,title,content, startDate, startTime, endTime) values (3,'Auta3','Wystawa samochodowa3','2018-01-27','09:00:00','18:00:00');

insert into user (id,name,surname,login,password,role)values (1,'user','user','user','user','user');
insert into user (id,name,surname,login,password,role)values (2,'admin','admin','admin','admin','admin');

select * from Event;
select*from user;