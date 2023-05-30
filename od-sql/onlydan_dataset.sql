insert into countries
values
('US', 'United States of America'),
('CA', 'Canada'),
('UK', 'United Kingdom'),
('MX', 'Mexico'),
('JP', 'Japan'),
('KR', 'Korea'),
('CN', 'China'),
('MY', 'Malaysia'),
('ID', 'Indonesia'),
('VN', 'Vietnam'),
('FR', 'France'),
('BR', 'Brazil'),
('DE', 'Germany'),
('SE', 'Sweden'),
('PL', 'Poland'),
('IT', 'Italy'),
('AU', 'Australia'),
('NZ', 'New Zealand'),
('DK', 'Denmark'),
('NO', 'Norway'),
('NL', 'Netherlands'),
('RU', 'Russia');


insert into shipping_statuses
(status_name)
values
('Started'),
('In Transit'),
('Returning'),
('Delivered');

insert into payment_statuses
(status_name)
values
('Not paid'),
('Processing'),
('Payment failed'),
('Paid');

insert into payment_methods
(method_name)
values
('Cash'),
('Credit card'),
('Paypal'),
('Digital wallet');

INSERT INTO public.payment_details (payment_date,payment_status,account_id,payment_method_id) VALUES
	 ('2022-01-03','PROCESSING',3,2),
	 ('2022-01-10','PAID',6,2),
	 ('2022-01-28','NOT_PAID',2,4),
	 ('2022-02-03','PROCESSING',7,1),
	 ('2022-02-14','PAYMENT_FAILED',9,4),
	 ('2022-02-16','NOT_PAID',10,4),
	 ('2022-02-16','PROCESSING',10,2),
	 ('2022-08-14','NOT_PAID',10,3),
	 ('2022-09-27','PAID',6,2),
	 ('2022-09-18','PROCESSING',6,4);

insert into inventory_statuses
(status_name)
values
('In stock'),
('Out of stock'),
('On sale'),
('Unavailable');

insert into roles
(role_name, permissions)
VALUES 
('ADMIN', 'ALL PRIVILEGES'),
('EDITOR', 'SELECT, INSERT, UPDATE'),
('USER', 'SELECT');

insert into role_assignment
(assigned_date, role_name, account_id)
values
('2023-05-29', 'ROLE_ADMIN', 1),
('2023-05-29', 'ROLE_USER', 2),
('2023-05-29', 'ROLE_USER', 3),
('2023-05-29', 'ROLE_USER', 4),
('2023-05-29', 'ROLE_USER', 5),
('2023-05-29', 'ROLE_USER', 6),
('2023-05-29', 'ROLE_USER', 7),
('2023-05-29', 'ROLE_USER', 8),
('2023-05-29', 'ROLE_USER', 9),
('2023-05-29', 'ROLE_USER', 10);

INSERT INTO public.role_assignment (assigned_date,role_name,updated_date,account_id) VALUES
	 ('2023-05-29 00:00:00','ROLE_ADMIN','2023-05-29 00:00:00',1),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',2),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',3),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',4),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',5),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',6),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',7),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',8),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',9),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',10);

insert into accounts
(account_name, account_password, first_name, last_name, phone_number, address, email, gender)
values 
('bqkhanh', 'asdkjE943aw', 'Khanh', 'Bui', '084-690-1653', '123 Fake Street', 'kbuiblue@gmail.com', 'MALE'),
('fcutsforth0', 'iwcKjKGUib', 'Fielding', 'Cutsforth', '556-268-3625', '9 Florence Pass', 'fcutsforth0@shinystat.com', 'MALE'),
('gbrewers1', '13DQTc', 'Germaine', 'Brewers', '623-743-8058', '7 Grover Center', 'gbrewers1@samsung.com', 'FEMALE'),
('bgert2', 'olru1Sa', 'Barbette', 'Gert', '957-799-7088', '2114 Fulton Junction', 'bgert2@amazon.co.jp', 'FEMALE'),
('bhallmark3', 'q50PjKkXbJtR', 'Beitris', 'Hallmark', '723-686-5426', '30991 Milwaukee Drive', 'bhallmark3@ebay.com', 'NON_BINARY'),
('cclelle4', 'uad5jinPv', 'Cherise', 'Clelle', '700-198-2681', '50133 Kim Way', 'cclelle4@shop-pro.jp', 'FEMALE'),
('cgoodie5', 'hocHEa360F', 'Christophorus', 'Goodie', '225-345-1902', '09 Menomonie Avenue', 'cgoodie5@t.co', 'MALE'),
('aleadstone6', 'ovj4T34u', 'Atlante', 'Leadstone', '608-725-4610', '77 Russell Center', 'aleadstone6@ustream.tv', 'FEMALE'),
('ddrieu7', 'JNKwrFbN76', 'Dix', 'Drieu', '170-620-9923', '5229 International Trail', 'ddrieu7@discuz.net', 'NON_BINARY'),
('iwillarton8', 'dtFcwbgcxEl', 'Ingemar', 'Willarton', '180-578-9088', '704 Surrey Drive', 'iwillarton8@walmart.com', 'MALE'),
('ihumby9', 'BT4xUy', 'Ignatius', 'Humby', '772-588-1929', '32485 Thompson Terrace', 'ihumby9@typepad.com', 'MALE'),
('rleggata', 'GbofJ4', 3, 'Ronnica', 'Leggat', '175-253-6887', '19 Schiller Point', 'rleggata@jigsy.com', 'FEMALE'),
('ldeshonb', 'U09uyro', 3, 'Lacy', 'Deshon', '461-543-2451', '74480 Gina Park', 'ldeshonb@skyrock.com', 'FEMALE'),
('ddearellc', 'kE2Lrs9Y', 3, 'Desdemona', 'Dearell', '449-303-1306', '722 Melody Alley', 'ddearellc@a8.net', 'FEMALE'),
('sdumbltond', '3Aik69axt', 3, 'Standford', 'Dumblton', '399-496-1727', '872 Blue Bill Park Drive', 'sdumbltond@fda.gov', 'MALE'),
('lnazarethe', 'xOzNHrB', 3, 'Lawton', 'Nazareth', '122-948-9091', '07 Talmadge Circle', 'lnazarethe@dyndns.org', 'MALE'),
('adanseyf', 'mmXiBM5Z', 3, 'Arnuad', 'Dansey', '777-142-0669', '1 Bartillon Parkway', 'adanseyf@topsy.com', 'NON_BINARY'),
('nrookledgeg', 'fIique8qx726', 3, 'Nicolina', 'Rookledge', '457-692-5856', '67 Gateway Circle', 'nrookledgeg@chronoengine.com', 'FEMALE'),
('mhalsoh', 'Zq84k1', 3, 'Maynord', 'Halso', '293-593-8810', '3 Kim Plaza', 'mhalsoh@imgur.com', 'MALE'),
('pboanasi', 'FXV7HBFMaV', 3, 'Pavlov', 'Boanas', '791-854-7638', '147 Shoshone Park', 'pboanasi@is.gd', 'MALE'),
('rwhittenburyj', 'GjMs8wWi', 3, 'Rea', 'Whittenbury', '427-104-4536', '3162 Loftsgordon Crossing', 'rwhittenburyj@mac.com', 'FEMALE'),
('mgherardinik', 'sOW9Jjax', 3, 'Massimiliano', 'Gherardini', '551-429-5737', '90849 Westend Court', 'mgherardinik@newsvine.com', 'MALE'),
('mreppaportl', '4meYdru', 3, 'Marcellina', 'Reppaport', '239-132-9613', '85 Northport Court', 'mreppaportl@slideshare.net', 'FEMALE'),
('mgaynesm', 'Om9cuXFGEOo', 3, 'Marlyn', 'Gaynes', '636-146-4358', '2 Anzinger Drive', 'mgaynesm@flavors.me', 'FEMALE'),
('mboltern', '4ZjeVNNJw1d', 3, 'Marrilee', 'Bolter', '366-397-0109', '35612 Lakeland Junction', 'mboltern@parallels.com', 'FEMALE'),
('tcheero', 'AWTrXjNkL', 3, 'Theodosia', 'Cheer', '893-797-4932', '0396 Cardinal Park', 'tcheero@ibm.com', 'NON_BINARY'),
('jtaylorp', 'SmLmhTOyBSW', 3, 'Jaine', 'Taylor', '131-450-8468', '8 Kenwood Center', 'jtaylorp@reuters.com', 'FEMALE'),
('mjurschq', 'SIlREU9bOYy6', 3, 'Marga', 'Jursch', '187-113-8796', '36374 Shoshone Place', 'mjurschq@dell.com', 'FEMALE'),
('wstronackr', 'c8WxHfnot', 3, 'Wain', 'Stronack', '802-237-1579', '4 Sundown Hill', 'wstronackr@slate.com', 'MALE'),
('eeakins', 'lNr9Fy', 3, 'Esme', 'Eakin', '260-533-9189', '79 Monica Place', 'eeakins@gmpg.org', 'MALE'),
('vlemart', 'AgyZqtf', 3, 'Valenka', 'Lemar', '226-548-7386', '98 Cherokee Alley', 'vlemart@washingtonpost.com', 'FEMALE'),
('scellau', 'oow21o3k', 3, 'Selestina', 'Cella', '497-519-8782', '8252 La Follette Circle', 'scellau@dell.com', 'FEMALE'),
('kbulfootv', '9IKkLE3vFpn', 3, 'Kailey', 'Bulfoot', '996-400-4148', '56758 Daystar Center', 'kbulfootv@opera.com', 'FEMALE'),
('iwoodesonw', '0wuC9R', 3, 'Isa', 'Woodeson', '336-922-3722', '79 Scofield Place', 'iwoodesonw@technorati.com', 'MALE'),
('ldealeyx', 'TcojW1V', 3, 'Lilyan', 'Dealey', '278-367-5303', '0 Ridge Oak Hill', 'ldealeyx@time.com', 'FEMALE'),
('lseattery', 'SyqVHgJM', 3, 'Lorant', 'Seatter', '631-783-4029', '012 Banding Way', 'lseattery@auda.org.au', 'MALE'),
('aknokz', 'CFpn6Xko', 3, 'Angelika', 'Knok', '593-625-5655', '195 Eagle Crest Court', 'aknokz@wisc.edu', 'FEMALE'),
('cmayer10', 'JrVrC4', 3, 'Caldwell', 'Mayer', '753-718-8340', '940 Magdeline Crossing', 'cmayer10@samsung.com', 'MALE'),
('ystaden11', 'GZ9mrf', 3, 'Yard', 'Staden', '687-102-0555', '18685 Kinsman Road', 'ystaden11@furl.net', 'MALE'),
('aturl12', 'MWJa4hx', 3, 'Adriaens', 'Turl', '127-543-5044', '5 Transport Street', 'aturl12@skype.com', 'FEMALE'),
('pburmaster13', '1GBuNaz2f', 3, 'Phylys', 'Burmaster', '154-517-4368', '82 Eggendart Crossing', 'pburmaster13@who.int', 'FEMALE'),
('gwennam14', '4RqGsFDjV', 3, 'Gabe', 'Wennam', '596-809-1630', '06987 Carey Way', 'gwennam14@cmu.edu', 'MALE'),
('tblasdale15', 'iI6hYqIiPB', 3, 'Tann', 'Blasdale', '180-651-2478', '87 Fairview Drive', 'tblasdale15@shinystat.com', 'MALE'),
('dfiggures16', 'yDlN1XoBS0', 3, 'Daisie', 'Figgures', '308-975-3579', '28 Dunning Road', 'dfiggures16@hhs.gov', 'FEMALE'),
('gduffield17', 'TBH7P0Wfzd', 3, 'Gage', 'Duffield', '182-263-0650', '9 Becker Parkway', 'gduffield17@google.cn', 'NON_BINARY'),
('atidman18', 'iLXSt4T3JT', 3, 'Aveline', 'Tidman', '729-558-1673', '21 Hovde Center', 'atidman18@vkontakte.ru', 'FEMALE'),
('jbatchelor19', 'lhvugck3Bw2S', 3, 'Jerri', 'Batchelor', '744-735-1245', '28 Nelson Crossing', 'jbatchelor19@free.fr', 'MALE'),
('lscrewton1a', 'r3LVpG', 3, 'Lyda', 'Screwton', '468-900-2410', '4 Ridgeway Place', 'lscrewton1a@sciencedirect.com', 'FEMALE'),
('agreated1b', '5Vx47Gi', 3, 'Aksel', 'Greated', '547-620-1630', '3 Portage Avenue', 'agreated1b@intel.com', 'MALE'),
('cboot1c', 'mj1X6U7e', 3, 'Clio', 'Boot', '115-530-5746', '734 Lake View Way', 'cboot1c@ucoz.ru', 'FEMALE'),
('bmacpharlain1d', 'XKZolhTgUJq', 3, 'Brice', 'MacPharlain', '613-470-7531', '112 Sugar Drive', 'bmacpharlain1d@tumblr.com', 'NON_BINARY');

INSERT INTO public.accounts (account_name,account_password,address,creation_date,email,first_name,gender,is_active,last_name,phone_number) values
	 ('bqkhanh','$2y$10$TmKITfv0tm08gJ5gtuncZOve2q6AkBUilfDHOvjgQyRZe8.ae18py','123 Fake Street','2023-05-29 00:00:00','kbuiblue@gmail.com','Khanh','MALE',true,'Bui','084-690-1653'),
	 ('cclelle4','$2a$12$mpPqmqGGszToNMyjXOhc1.Ml4BF1BC9F/7nkY0h3FjPMk5vsK17Hm','50133 Kim Way','2023-05-29 00:00:00','cclelle4@shop-pro.jp','Cherise','FEMALE',true,'Clelle','700-198-2681'),
	 ('cgoodie5','hocHEa360F','09 Menomonie Avenue','2023-05-29 00:00:00','cgoodie5@t.co','Christophorus','MALE',true,'Goodie','225-345-1902'),
	 ('aleadstone6','ovj4T34u','77 Russell Center','2023-05-29 00:00:00','aleadstone6@ustream.tv','Atlante','FEMALE',true,'Leadstone','608-725-4610'),
	 ('ddrieu7','JNKwrFbN76','5229 International Trail','2023-05-29 00:00:00','ddrieu7@discuz.net','Dix','NON_BINARY',true,'Drieu','170-620-9923'),
	 ('iwillarton8','dtFcwbgcxEl','704 Surrey Drive','2023-05-29 00:00:00','iwillarton8@walmart.com','Ingemar','MALE',true,'Willarton','180-578-9088'),
	 ('fcutsforth0','$2a$12$mOiqj2tCP0k/OFoddmpzOupf1vJMQ0yzekoP9MGNNjcdUNk1NSVvK','9 Florence Pass','2023-05-29 00:00:00','fcutsforth0@shinystat.com','Fielding','MALE',true,'Cutsforth','556-268-3625'),
	 ('gbrewers1','13DQTc','7 Grover Center','2023-05-29 00:00:00','gbrewers1@samsung.com','Germaine','FEMALE',true,'Brewers','623-743-8058'),
	 ('bgert2','olru1Sa','2114 Fulton Junction','2023-05-29 00:00:00','bgert2@amazon.co.jp','Barbette','FEMALE',true,'Gert','957-799-7088'),
	 ('bhallmark3','q50PjKkXbJtR','30991 Milwaukee Drive','2023-05-29 00:00:00','bhallmark3@ebay.com','Beitris','NON_BINARY',true,'Hallmark','723-686-5426');


insert into role_assignment
(assigned_date, role_name, account_id)
values
('2023-05-29', 'ROLE_ADMIN', 1),
('2023-05-29', 'ROLE_USER', 2),
('2023-05-29', 'ROLE_USER', 3),
('2023-05-29', 'ROLE_USER', 4),
('2023-05-29', 'ROLE_USER', 5),
('2023-05-29', 'ROLE_USER', 6),
('2023-05-29', 'ROLE_USER', 7),
('2023-05-29', 'ROLE_USER', 8),
('2023-05-29', 'ROLE_USER', 9),
('2023-05-29', 'ROLE_USER', 10);

INSERT INTO public.role_assignment (assigned_date,role_name,updated_date,account_id) VALUES
	 ('2023-05-29 00:00:00','ROLE_ADMIN','2023-05-29 00:00:00',1),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',2),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',3),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',4),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',5),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',6),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',7),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',8),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',9),
	 ('2023-05-29 00:00:00','ROLE_USER','2023-05-29 00:00:00',10);

insert into payment_details
(account_id, payment_status, payment_method_id, payment_date)
values
(3, 'PROCESSING', 2, '2022-01-03'),
(6, 'PAID', 2, '2022-01-10'),
(2, 'NOT_PAID', 4, '2022-01-28'),
(7, 'PROCESSING', 1, '2022-02-03'),
(9, 'PAYMENT_FAILED', 4, '2022-02-14'),
(10, 'NOT_PAID', 4, '2022-02-16'),
(10, 'PROCESSING', 2, '2022-02-16'),
(10, 'NOT_PAID', 3, '2022-08-14'),
(6, 'PAID', 2, '2022-09-27'),
(6, 'PROCESSING', 4, '2022-09-18'),
(6, 3, 3, null, 7, '2022-09-27'),
(25, 4, 1, null, 25, '2022-05-31'),
(18, 1, 4, null, 13, '2023-03-10'),
(25, 1, 1, null, 15, '2022-09-19'),
(14, 2, 2, 'mastercard 5100720637384695', 11, '2022-12-09'),
(44, 3, 3, null, 8, '2022-05-31'),
(10, 2, 4, null, 6, '2022-05-05'),
(44, 2, 2, 'visa 4041369826813', 49, '2022-10-23'),
(30, 4, 4, null, 30, '2022-09-03'),
(19, 4, 2, 'mastercard 5100132534086821', 33, '2023-01-12'),
(22, 1, 1, null, 39, '2023-01-27'),
(44, 1, 2, 'jcb 3574524359057642', 32, '2023-04-07'),
(19, 2, 2, 'mastercard 5100132534086821', 28, '2023-04-14'),
(28, 4, 4, null, 36, '2023-03-06'),
(50, 3, 3, null, 27, '2022-12-04'),
(27, 2, 2, 'jcb 3529426188990611', 42, '2023-02-03'),
(44, 4, 4, null, 2, '2022-05-25'),
(4, 2, 4, null, 38, '2022-10-10'),
(26, 2, 2, 'americanexpress 337941864278915', 22, '2023-04-11'),
(41, 1, 4, null, 40, '2022-11-08'),
(22, 3, 2, 'mastercard 5561377675271029', 49, '2022-07-03'),
(47, 4, 1, null, 8, '2022-08-28'),
(15, 4, 1, null, 31, '2022-11-15'),
(33, 1, 4, null, 30, '2022-12-13'),
(27, 1, 1, null, 9, '2023-01-03'),
(6, 4, 2, 'mastercard 5002352640770873', 46, '2022-08-26'),
(3, 4, 2, 'visa 4041376349551', 17, '2023-01-13'),
(24, 2, 1, null, 51, '2022-10-25'),
(16, 2, 2, 'mastercard 5588281263716008', 25, '2022-05-14'),
(4, 4, 1, 'jcb 3543207013625206', 17, '2022-12-24'),
(48, 2, 1, null, 25, '2022-12-06'),
(32, 3, 4, null, 8, '2022-09-11'),
(50, 3, 1, null, 47, '2023-03-22'),
(20, 4, 3, null, 19, '2022-05-11'),
(43, 1, 3, null, 26, '2022-06-13'),
(23, 4, 2, 'bankcard 5602240819479935', 6, '2022-06-10'),
(21, 4, 4, null, 13, '2022-05-30'),
(13, 4, 2, 'jcb 3572478857712012', 29, '2022-10-10'),
(21, 2, 2, 'jcb 3563813843314740', 7, '2023-01-07'),
(7, 1, 4, null, 41, '2022-10-13'),
(8, 1, 2, 'visa-electron 4917677967355453', 13, '2023-03-19');

INSERT INTO public.stock_changes (change_amount,change_date,change_type,remaining_amount) VALUES
	 (2,'2022-04-24','INCOMING',3),
	 (2,'2022-05-26','INCOMING',2),
	 (2,'2022-06-01','INCOMING',1),
	 (3,'2022-04-25','INCOMING',2),
	 (2,'2022-04-28','OUTGOING',1),
	 (2,'2022-05-24','OUTGOING',3),
	 (1,'2022-05-27','OUTGOING',0),
	 (4,'2022-06-11','OUTGOING',1),
	 (1,'2022-06-11','OUTGOING',2),
	 (9,'2022-04-30','OUTGOING',2),
	 (1,'2022-05-03','OUTGOING',1),
	 (2,'2022-06-06','OUTGOING',1),
	 (1,'2022-06-11','OUTGOING',2);

insert into inventory 
(product_id, shipping_status, inventory_status, stock_change_id)
values 
(1, 'STARTED', 'IN_STOCK', 1),
(16, 'IN_TRANSIT', 'IN_STOCK',2),
(4, 'DELIVERED', 'IN_STOCK', 3),
(15, 'DELIVERED', 'IN_STOCK',4),
(7, 'DELIVERED', 'IN_STOCK', 5),
(13, 'IN_TRANSIT', 'IN_STOCK',6),
(13, 'STARTED', 'IN_STOCK',7),
(15, 'IN_TRANSIT', 'IN_STOCK',8),
(2, 'IN_TRANSIT', 'IN_STOCK', 9),
(5, 'IN_TRANSIT', 'IN_STOCK', 10),
(10, 2, 1,11),
(5, 4, 1, 12),
(16, 'STARTED', 1,13),
(10, 1, 1,14),
(13, 1, 1,15),
(6, 2, 1, 16),
(15, 1, 1,17),
(6, 2, 1, 18),
(3, 1, 1, 19),
(13, 4, 1,20),
(9, 2, 1, 21),
(6, 1, 1, 22),
(9, 1, 1, 23),
(3, 1, 1, 24),
(14, 2, 1,25),
(4, 4, 1, 26),
(7, 4, 1, 27),
(14, 2, 1,28),
(6, 1, 1, 29),
(2, 4, 1, 30),
(3, 1, 1, 31),
(3, 3, 1, 32),
(14, 4, 1,33),
(12, 1, 1,34),
(15, 1, 1,35),
(14, 3, 1,36),
(19, 3, 1,37),
(19, 1, 1,38),
(12, 4, 1,39),
(1, 2, 1, 40),
(1, 1, 1, 41),
(15, 1, 1,42),
(8, 3, 1, 43),
(19, 2, 1,44),
(7, 1, 1, 45),
(15, 1, 1,46),
(20, 2, 1,47),
(6, 4, 1, 48),
(18, 3, 1,49),
(20, 3, 1,50),
(17, 3, 1, 51);

INSERT INTO public.inventory (inventory_status,shipping_status,product_id,stock_change_id) VALUES
	 ('IN_STOCK','STARTED',1,1),
	 ('IN_STOCK','IN_TRANSIT',16,2),
	 ('IN_STOCK','DELIVERED',4,3),
	 ('IN_STOCK','DELIVERED',15,4),
	 ('IN_STOCK','DELIVERED',7,5),
	 ('IN_STOCK','IN_TRANSIT',13,6),
	 ('IN_STOCK','STARTED',13,7),
	 ('IN_STOCK','IN_TRANSIT',2,9),
	 ('IN_STOCK','IN_TRANSIT',5,10),
	 ('OUT_OF_STOCK','IN_TRANSIT',15,8),
	 ('IN_STOCK','IN_TRANSIT',20,11),
	 ('IN_STOCK','DELIVERED',8,12),
	 ('IN_STOCK','DELIVERED',9,13);

INSERT INTO stock_changes
(change_date,change_type,change_amount,remaining_amount)
VALUES 
('2022-04-24','INCOMING',2,3),
('2022-04-25','INCOMING',3,2),
('2022-04-28','INCOMING',5,3),
('2022-04-30','INCOMING',5,1),
('2022-05-03','INCOMING',6,9),
('2022-05-24','INCOMING',4,3),
('2022-05-26','INCOMING',2,2),
('2022-05-27','INCOMING',3,3),
('2022-06-01','INCOMING',2,1),
('2022-06-11','INCOMING',2,3),
('2022-07-17','INCOMING',6,3),
('2022-08-06','INCOMING',3,1),
('2022-08-17','INCOMING',5,1),
('2022-08-18','INCOMING',2,1),
('2022-08-20','INCOMING',5,2),
('2022-08-23','INCOMING',4,3),
('2022-08-24','INCOMING',5,1),
('2022-08-26','INCOMING',3,1),
('2022-09-30','INCOMING',3,2),
('2022-10-01','INCOMING',2,1),
('2022-10-14','OUTGOING',2,3),
('2022-10-24','OUTGOING',5,1),
('2022-10-25','OUTGOING',3,2),
('2022-10-25','OUTGOING',3,1),
('2022-11-02','OUTGOING',5,1),
('2022-11-03','OUTGOING',3,2),
('2022-11-04','OUTGOING',3,3),
('2022-11-04','OUTGOING',5,1),
('2022-11-10','OUTGOING',2,1),
('2022-11-18','OUTGOING',4,1),
('2022-11-30','OUTGOING',5,2),
('2022-12-03','OUTGOING',6,1),
('2022-12-04','OUTGOING',1,2),
('2022-12-13','OUTGOING',5,2),
('2022-12-23','OUTGOING',4,0),
('2023-01-16','OUTGOING',5,2),
('2023-01-23','OUTGOING',4,3),
('2023-01-25','OUTGOING',3,1),
('2023-01-29','OUTGOING',1,2),
('2023-02-13','OUTGOING',1,2),
('2023-02-19','INCOMING',5,3),
('2023-03-05','OUTGOING',3,2),
('2023-03-09','OUTGOING',3,3),
('2023-03-16','OUTGOING',2,1),
('2023-03-16','OUTGOING',2,3),
('2023-03-16','OUTGOING',4,3),
('2023-03-17','INCOMING',3,2),
('2023-03-24','OUTGOING',5,3),
('2023-04-01','INCOMING',5,1),
('2023-04-11','OUTGOING',3,3),
('2023-04-12','INCOMING',2,3);

INSERT INTO public.stock_changes (change_amount,change_date,change_type,remaining_amount) VALUES
	 (2,'2022-04-24','INCOMING',3),
	 (2,'2022-05-26','INCOMING',2),
	 (2,'2022-06-01','INCOMING',1),
	 (3,'2022-04-25','INCOMING',2),
	 (2,'2022-04-28','OUTGOING',1),
	 (2,'2022-05-24','OUTGOING',3),
	 (1,'2022-05-27','OUTGOING',0),
	 (4,'2022-06-11','OUTGOING',1),
	 (1,'2022-06-11','OUTGOING',2),
	 (9,'2022-04-30','OUTGOING',2),
	 (1,'2022-05-03','OUTGOING',1),
	 (2,'2022-06-06','OUTGOING',1),
	 (1,'2022-06-11','OUTGOING',2);

insert into order_details
(is_on_sale, order_date, product_price, product_quantity, sale_percentage, order_id, product_id)
values
(FALSE, '2022-10-25', 11000, 1, 0, 1, 1),
(FALSE, '2022-10-25', 9500, 1, 0, 1, 2),
(FALSE, '2022-10-25', 6000, 1, 0, 1, 3),
(FALSE, '2022-10-25', 6000, 1, 0, 1, 4),
(FALSE, '2022-10-25', 5500, 1, 0, 1, 5),
(FALSE, '2022-10-25', 5000, 1, 0, 1, 6),
(FALSE, '2022-10-25', 5000, 1, 0, 1, 7),
(FALSE, '2022-10-25', 5000, 1, 0, 1, 8),
(FALSE, '2022-10-25', 3000, 1, 0, 1, 9),
(FALSE, '2022-10-25', 2800, 1, 0, 1, 10);

insert into orders
(payment_details_id)
values
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);

INSERT INTO public.order_details (is_on_sale,order_date,product_price,product_quantity,sale_percentage,order_id,product_id) VALUES
	 (false,'2022-04-30',1000.0,9,0.0,2,15),
	 (false,'2022-05-27',6500.0,1,0.0,5,5),
	 (false,'2022-04-28',7000.0,1,0.0,1,4),
	 (false,'2022-05-03',6000.0,2,0.0,3,7),
	 (false,'2022-05-24',1000.0,6,0.0,4,15),
	 (false,'2022-06-06',6000.0,3,0.0,6,8),
	 (false,'2022-06-11',6000.0,2,0.0,7,7),
	 (false,'2022-06-11',500.0,7,0.0,7,20),
	 (false,'2022-06-11',4000.0,2,0.0,8,9),
	 (false,'2022-10-25',2800.0,4,0.0,1,10);


