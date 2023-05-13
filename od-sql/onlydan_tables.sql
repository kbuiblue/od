create table countries (
	country_id char(2) NOT NULL,
	country_name varchar(50) NULL,
	primary key (country_id)
);

create table product_info (
	product_id serial not null,
	stock_price real not null,
	product_brand varchar(100) not null,
	product_name varchar(200) not null,
	product_condition varchar(100) not null,
	product_type varchar(50),
	product_year int4,
	country_id char(2) references countries(country_id),
	description varchar(2000),
	primary key (product_id)
);

create table roles (
	role_id serial not null,
	role_name varchar(50) not null,
	permissions varchar(100),
	primary key (role_id)
);


create table accounts (
	account_id serial not null,
	account_name varchar(25) not null,
	account_password varchar(50) not null,
	role_id int4 references roles (role_id),
	first_name varchar(50) null,
	last_name varchar(50) null,
	phone_number varchar(25) null,
	address varchar(100) null,
	email varchar(50) null,
	gender varchar(50) null,
	primary key (account_id)
);


create table shipping_statuses (
	shipping_status serial not null,
	status_name varchar(100) not null,
	primary key (shipping_status)
);


create table payment_statuses (
	payment_status serial not null,
	status_name varchar(100) not null,
	primary key (payment_status)
);

create table payment_methods (
	payment_method serial not null,
	method_name varchar(100) not null,
	primary key (payment_method)
);

create table inventory_statuses (
	inventory_status serial not null,
	status_name varchar(100) not null,
	primary key (inventory_status)
);


create table payment_detail (
	payment_id serial not null,
	account_id int4 not null references accounts(account_id),
	payment_status int4 not null references payment_statuses(payment_status),
	payment_method int4 not null references payment_methods(payment_method),
	payment_info varchar(300),
	order_id int4 references orders(order_id),
	payment_date date,
	primary key (payment_id)
);

create table orders (
	order_id serial not null,
	payment_id int4 not null references payment_detail(payment_id),
	primary key (order_id)
);

create table order_detail (
	order_id int4 not null references orders(order_id),
	product_id int4 not null references product_info(product_id),
	product_price real not null,
	on_sale boolean not null,
	product_quantity int4 not null,
	order_date date
);


create table stock_changes (
	change_id serial, 
	change_date date not null,
	change_type varchar(25) not null,
	change_amount int4,
	remaining_stock int4,
	primary key (change_id)
);


create table inventory (
	inventory_id serial not null,
	product_id int4 not null references product_info(product_id),
	shipping_status int4 references shipping_statuses(shipping_status),
	inventory_status int4 references inventory_statuses(inventory_status),
	change_id int4 references stock_changes(change_id),
	primary key (inventory_id)
);



