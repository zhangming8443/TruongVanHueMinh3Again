create database book_management;

use book_management;

-- SS2 ===========================================================================================================================================

create table authors(
	id_authors int primary key auto_increment,
    name_authors varchar(45)
);

create table category(
	id_category int primary key auto_increment,
    name_category varchar(45)
);
create table students(
	id_student int primary key auto_increment,
    name_student varchar(45),
    birthday date,
    class_name varchar(45)
);

create table books(
	id_books int primary key auto_increment,
    title varchar(45),
    page_size int,
    id_authors int,
    id_category int,
    is_delete int default 0,
    foreign key (id_authors) references authors (id_authors),
    foreign key (id_category) references category (id_category)
);
select id_books, title, page_size, name_authors,name_category
from books b
join authors a on a.id_authors = b.id_authors
join category c on c.id_category= b.id_category;

create table borrows(
	id_borrows int primary key auto_increment,
	id_student int,
	id_books int,
	borrow_date date,
    return_date date,
	foreign key (id_student) references students(id_student),
	foreign key (id_books) references books(id_books)
);

-- SS3 ===========================================================================================================================================

insert into category (name_category) values
('Tự nhiên'),
('Xã Hội'),
('Truyện'),
('Tiểu Thuyết'),
('Khác');

insert into authors (name_authors) values
('Nguyễn Thái Học'),
('Trần Mình Hoàng'),
('Dương Trung Quốc'),
('Lê Văn Hiến'),
('Hà Văn Minh');

insert into students (name_student, birthday, class_name) values
('Nguyễn Văn A', '1999-12-12', 'C0822G1'),
('Nguyễn Văn B', '1999-12-13', 'C0822G1'),
('Nguyễn Văn C', '1999-12-14', 'C0822G1'),
('Nguyễn Văn D', '1999-12-15', 'C0922G1'),
('Nguyễn Văn E', '1999-12-16', 'C1022G1');

insert into books (title, page_size, id_authors, id_category) values
('Toán', 45, 1, 1),
('Văn', 34, 2, 2),
('Sử', 56, 3, 2),
('Địa', 76, 4, 2),
('Hoá', 32, 5, 1);

insert into borrows (id_student, id_books, borrow_date, return_date) values
(1, 1, '2022-12-12', '2022-12-13'),
(2, 2, '2022-12-12', '2022-12-15'),
(3, 3, '2022-12-12', '2022-12-15'),
(4, 4, '2022-12-12', '2022-12-12'),
(1, 5, '2022-12-13', '2022-12-15'),    
(1, 5, '2022-12-14', '2022-12-14'),
(3, 4, '2022-12-15', '2022-12-29'),
(3, 3, '2022-12-08', '2022-12-14'),
(1, 2, '2022-12-06', '2022-12-30');

-- Lấy ra toàn bộ sách có trong thư viện, cùng với tên thể loại và tác giả
select title, name_category, name_authors
from books b
join category c on b.id_category = c.id_category
join authors a on b.id_authors = a.id_authors
order by b.id_books;

-- Lấy ra danh sách các học viên đã từng mượn sách và sắp xếp danh sách theo theo tên từ a->z
select name_student, borrow_date
from students s
join borrows b on s.id_student = b.id_student
order by s.name_student;

-- Lấy ra  2 quyển sách được mượn nhiều nhất
select b.title, count(*) as borrow_count
from books b
join borrows br on b.id_books = br.id_books
group by b.id_books
order by borrow_count desc
limit 2;

-- SS4 ===========================================================================================================================================

-- Thông kê các đầu sách được mượn nhiều nhất
select b.title, count(*) as borrow_count
from books b
join borrows br on b.id_books = br.id_books
group by b.title
order by borrow_count desc;

-- - Thông kê các đầu sách chưa được mượn
select b.title
from books b
join borrows br on b.id_books = br.id_books
where br.id_books is null;

-- Lấy ra danh sách các học viên đã từng mượn sách và sắp xếp  theo số lượng mượn sách từ lớn đến nhỏ
select s.name_student, count(*) as borrow_count
from students s
inner join borrows b on s.id_student = b.id_student
group by s.id_student
order by borrow_count desc;

-- Lấy ra các học viên mượn sách nhiều nhất của thư viện
select s.name_student, count(*) as borrow_count
from students s
inner join borrows b on s.id_student = b.id_student
group by s.id_student
order by borrow_count desc
limit 1;

-- SS5 ===========================================================================================================================================

-- Tao index cho cột  title của bảng books
create index idx_title on books (title);

-- Tạo 1 view để lấy ra danh sách các quyển sách đã được mượn, có hiển thị thêm cột số lần đã được mượn
create view borrowed_books_view AS
select b.*, COUNT(*) AS borrow_count
from books b
join borrows br ON b.id_books = br.id_books
group by b.id_books;

-- Viết 1 stored procedure thêm mới book trong database với tham số kiểu IN
DELIMITER //
create procedure sp_add_book
(
    in p_title varchar(255),
    in p_page_size varchar(255),
    in p_id_authors int,
    in p_id_category varchar(255)
)
begin
    insert into books (title, page_size, id_authors, id_category)
    values (p_title, p_page_size, p_id_authors, p_id_category);
end //
DELIMITER // 

call sp_add_book('Công nghệ', 3000, 3, 4);

set sql_safe_updates = 1;

DELIMITER //
CREATE PROCEDURE sp_delete_book
	(
    b_book_id INT
    )
BEGIN
    UPDATE books
    SET is_delete = 1
    WHERE books.id_books = b_book_id;
END //
DELIMITER //

update books set is_delete = 1 where id_books = 3;

call sp_delete_book(5);






