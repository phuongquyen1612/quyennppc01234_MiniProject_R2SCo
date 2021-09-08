CREATE DATABASE MiniProject;

USE MiniProject;
 
 /*--password: 123*/

	CREATE TABLE Users(
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	password VARCHAR(250)  NULL,
	activated BIT NOT NULL,
	verifycode VARCHAR(64)  NULL,
	fullname VARCHAR(50) NOT NULL
    );

	

	CREATE TABLE Roles(
	roleid VARCHAR(20) NOT NULL PRIMARY KEY,
	rolename VARCHAR(50) NOT NULL
	);
	

	CREATE TABLE roleuser(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
	roleid VARCHAR(20) NOT NULL,
	FOREIGN KEY(username) REFERENCES Users(username) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(roleid) REFERENCES Roles(roleid) ON UPDATE CASCADE ON DELETE CASCADE
	);
	

	INSERT INTO Users	   
	VALUES ('quyennppc01234@gmail.com', '$2a$10$a/7p7S4AnHNRax3KC6UvYuBjEFZFJycbV4G9/RcXr6is2EElcgl5e', 1, '', 'Nguyen Phuong Quyen'),
	('quyennguyen@gmail.com', '$2a$10$a/7p7S4AnHNRax3KC6UvYuBjEFZFJycbV4G9/RcXr6is2EElcgl5e', 1, '', 'Quyen Nguyen'),
	('quyennguyenphuong@gmail.com', '$2a$10$a/7p7S4AnHNRax3KC6UvYuBjEFZFJycbV4G9/RcXr6is2EElcgl5e', 1, '', N'Phuong Quyen'),
	('nhinttpc01290@gmail.com', '$2a$10$a/7p7S4AnHNRax3KC6UvYuBjEFZFJycbV4G9/RcXr6is2EElcgl5e', 1, '', 'Tuyet Nhi'),
	('ngocntypc01187@gmail.com', '$2a$10$a/7p7S4AnHNRax3KC6UvYuBjEFZFJycbV4G9/RcXr6is2EElcgl5e', 1, '', 'Yen Ngoc'),
	('hieuhuynh@gmail.com', '$2a$10$a/7p7S4AnHNRax3KC6UvYuBjEFZFJycbV4G9/RcXr6is2EElcgl5e', 1, '', 'Trong Hieu'),
	('tranlong@gmail.com', '$2a$10$a/7p7S4AnHNRax3KC6UvYuBjEFZFJycbV4G9/RcXr6is2EElcgl5e', 1, '', 'Tran Long'),
	('minhtai@gmail.com', '$2a$10$a/7p7S4AnHNRax3KC6UvYuBjEFZFJycbV4G9/RcXr6is2EElcgl5e', 1, '', 'Minh Tai');
	


	INSERT INTO Roles
	VALUES ('ROLE_MANAGER', 'QUẢN LÍ'),
		   ('ROLE_STAFF', 'NHÂN VIÊN' ),
		   ('ROLE_CUSTOMER', 'KHÁCH HÀNG');
	
		
			INSERT INTO roleuser
			VALUES (1, 'quyennppc01234@gmail.com', 'ROLE_MANAGER'), 
			(2, 'quyennguyenphuong@gmail.com', 'ROLE_MANAGER'), 
			(3, 'quyennguyen@gmail.com', 'ROLE_STAFF'),
			(4, 'nhinttpc01290@gmail.com', 'ROLE_STAFF'),
			(5, 'ngocntypc01187@gmail.com', 'ROLE_STAFF'),
			(6, 'hieuhuynh@gmail.com', 'ROLE_CUSTOMER'),  
			(7, 'tranlong@gmail.com', 'ROLE_CUSTOMER'),
			(8, 'minhtai@gmail.com', 'ROLE_CUSTOMER');
			
			
			

Create table Categories(
categoryid int not null AUTO_INCREMENT primary key,
name varchar(100) not null,
image varchar(100) not null,
description varchar(500) null
);


insert into Categories
values
(1, 'Nike1', 'pic1.jpg', ''),
(2, 'Nike2', 'pic2.jpg', ''),
(3, 'Nike3', 'pic3.jpg', ''),
(4, 'Nike4', 'pic4.jpg', ''),
(5, 'Nike5', 'pic5.jpg', ''),
(6, 'Nike6', 'pic6.jpg', ''),
(7, 'Nike7', 'pic7.jpg', ''),
(8, 'Nike8', 'pic8.jpg', ''),
(9, 'Nike9', 'pic9.jpg', ''),
(10, 'Nike10', 'pic10.jpg', '');



Create table Products(
productid varchar(20) not null primary key,
productname varchar(200) not null,
image varchar(100) not null,
price int not null,
sale int not null,
newprice int not null,
description varchar(500) null,
ctgid int not null,
foreign key(ctgid) references Categories(categoryid) on update cascade on delete cascade
);


insert into Products
values
('NK001', 'Nike 1', 'pic1.jpg', 250, 20, 230, '', 1),
('NK002', 'Nike 2', 'pic2.jpg', 240, 5, 235, '', 2),
('NK003', 'Nike 3', 'pic3.jpg', 180, 20, 160, '', 3),
('NK004', 'Nike 4', 'pic4.jpg', 190, 10, 180, '', 4),
('NK005', 'Nike 5', 'pic5.jpg', 210, 20, 190, '', 5),
('NK006', 'Nike 6', 'pic6.jpg', 245, 5, 240, '', 6),
('NK007', 'Nike 7', 'pic7.jpg', 170, 5, 165, '', 7),
('NK008', 'Nike 8', 'pic8.jpg', 70, 20, 50, '', 8),
('NK009', 'Nike 9', 'pic9.jpg', 55, 5, 50, '', 9),
('NK0010', 'Nike 10', 'pic10.jpg', 222, 22, 200, '', 10);



Create table Orders(
orderid int not null AUTO_INCREMENT primary key,
email varchar(50) not null,
fullname varchar(50) not null,
total int not null,
address varchar(200) not null,
phone varchar(10) not null,
foreign key(email) references Users(username) on update cascade on delete no action
);


insert into Orders
values
(1, 'hieuhuynh@gmail.com', 'Huynh Trong Hieu', 500, 'Ho Chi Minh', '0908997788'),
(2, 'tranlong@gmail.com', 'Tran Long', 800, 'Tra Vinh', '0907233456'),
(3, 'minhtai@gmail.com', 'Nguyen Minh Tai', 300, 'Hau Giang', '0906785432');


Create table Orderdetails(
detailid int not null AUTO_INCREMENT primary key,
ordid int not null,
prodid varchar(20) not null,
productname varchar(200) not null,
price int not null,
qty int not null,
foreign key(ordid) references Orders(orderid) on update cascade on delete cascade,
foreign key(prodid) references Products(productid) on update cascade on delete no action
);

insert into Orderdetails
values
(1, 1, 'NK003', 'Nike 3', 180, 3),
(2, 2, 'NK008', 'Nike 8', 70, 3),
(3, 3, 'NK002', 'Nike 3', 240, 2);




 









				

				