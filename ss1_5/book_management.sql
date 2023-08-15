create database book_management;

use book_management;

create table books(
	id int primary key auto_increment, 
    name_book varchar(45),
    page_size int,
    author varchar(45)
);

insert into books (name_book, page_size, author) values
('Toán', 45, 'Nguyễn Thái Học'),
('Văn',	34,	'Trần Mình Hoàng'),
('Sử',	56,	'Dương Trung Quốc'),
('Địa',	76,	'Lê Văn Hiến'),
('Hoá',	32,	'Hà Văn Minh');

SET SQL_SAFE_UPDATES = 0;
update books 
set page_size = 50
where name_book = 'Sử';
SET SQL_SAFE_UPDATES = 1;

delete
from books
where id = 5;

drop table books;

drop database book_management;





