drop table if exists own;
drop table if exists dog;
drop table if exists join_member;
drop table if exists meetup;
drop table if exists user;


create table user(
user_id int auto_increment primary key,
user_pwd varchar(64),
user_name varchar(30),
email varchar(30),
user_city varchar(20),
regdate datetime
);

create table dog(
dog_id int auto_increment primary key,
dog_name varchar(64),
dog_breed varchar(64),
dog_age int,
dog_info varchar(200)
);

create table own(
user_id int,
dog_id int,
constraint user_id_pk1
foreign key (user_id) references user(user_id),
constraint dog_id_pk
foreign key (dog_id) references dog(dog_id)
);

create table meetup(
meetup_id int auto_increment primary key,
host_id int,
meetup_date datetime,
meetup_address varchar(64),
meetup_info varchar(200)
);

create table join_member(
meetup_id int,
user_id int,
constraint user_id_pk2
foreign key (user_id) references user(user_id),
constraint meetup_id_pk2
foreign key (meetup_id) references meetup(meetup_id)
);