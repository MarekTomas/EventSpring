create database Event;
use Event;

create table Event(
id INT AUTO_INCREMENT,
title VARCHAR(250) not null,
content VARCHAR(250) not null,
startDate VARCHAR(250) not null,
startTime VARCHAR(250) not null,
endTime VARCHAR(250) not null,
primary key (id)
);

Drop table event;

insert into Event (id,title,content, startDate, startTime, endTime) values (1,'Auta','Wystawa samochodowa','2018-01-25','09:00:00','18:00:00');
insert into Event (id,title,content, startDate, startTime, endTime) values (2,'Auta2','Wystawa samochodowa2','2018-01-26','09:00:00','18:00:00');
insert into Event (id,title,content, startDate, startTime, endTime) values (3,'Auta3','Wystawa samochodowa3','2018-01-27','09:00:00','18:00:00');

select * from Event;