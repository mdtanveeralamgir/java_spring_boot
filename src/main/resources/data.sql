--Insertion into user table
insert into user_details (id, birth_date, name) values(1001, current_date(), 'opel');
insert into user_details (id, birth_date, name) values(1002, current_date(), 'Aayid');
insert into user_details (id, birth_date, name) values(1003, current_date(), 'Shamma');

--Insertion into Post table

insert into post (id, description, user_id) values (2001, 'This is 2001 post', 1001);
insert into post (id, description, user_id) values (2002, 'This is 2002 post', 1002);
insert into post (id, description, user_id) values (2003, 'This is 2003 post', 1003);
insert into post (id, description, user_id) values (2004, 'This is 2004 post', 1003);
