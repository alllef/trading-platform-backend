insert into category (category_name) values 
('NFT'),
('ACCOUNT');

insert into currency(currency_name) values
('DOLLAR'),
('EURO'),
('HRYVNA');

insert into role(role_name) values
('MODERATOR'),
('CLIENT');

insert into platform_user("name","password",registration_date,surname,telegram_nickname,role_id) values 
('gerg','ger',CURRENT_DATE,'gedf','geferf',1),
('gerg','ger',CURRENT_DATE,'gedf','geferf',2);

insert into advertisement (advert_name,creation_date ,description ,price ,"type" ,author_id,category_id,currency_id) values 
('Something',CURRENT_DATE,'Simple advertisement',657890,'BUY',1,1,1),
('Someteg',CURRENT_DATE,'Not so simple',134567,'SELL',1,1,1);

insert into review ("content",creation_date,mark,advertisement_id,review_author_id) values
('gef',current_Date,456,1,1),
('gd',current_Date,46,2,2);
