INSERT INTO `product`(`name`,`price`) VALUES ('Lego Batman' ,'600.25');
INSERT INTO `product`(`name`,`price`) VALUES ('Microscopio Mi Alegría' ,'500.25');
INSERT INTO `product`(`name`,`price`) VALUES ('Balón Siuuu' ,'1000.15');

INSERT INTO `customer` (`first_name`,`last_name`,`email`,`avatar`, `password`,`is_active`) VALUES ('Patricio','Estrella','patricio@email.com','https://randomuser.me/api/portraits/men/30.jpg', '123', 0b1);
INSERT INTO `customer` (`first_name`,`last_name`,`email`,`avatar`, `password`,`is_active`) VALUES ('Selena','Gómez','selena@email.com','https://randomuser.me/api/portraits/women/26.jpg', '123', 0b0);
INSERT INTO `customer` (`first_name`,`last_name`,`email`,`avatar`, `password`,`is_active`) VALUES ('Benito','Bodoque','benito@email.com','https://randomuser.me/api/portraits/men/38.jpg', '123', 0b1);
INSERT INTO `customer` (`first_name`,`last_name`,`email`,`avatar`, `password`,`is_active`) VALUES ('Edna','Krabappel','edna@email.com','https://randomuser.me/api/portraits/women/28.jpg', '123', 0b1);
INSERT INTO `customer` (`first_name`,`last_name`,`email`,`avatar`, `password`,`is_active`) VALUES ('Cristiano','Ronado','cristiano@email.com','https://randomuser.me/api/portraits/men/20.jpg', '123', 0b1);

INSERT INTO `shopping_order`(`customer_id`,`created_at`) VALUES ('1' ,'2022-11-01 06:25:31');
INSERT INTO `shopping_order`(`customer_id`,`created_at`) VALUES ('2' ,'2022-05-01 12:25:41');
INSERT INTO `shopping_order`(`customer_id`,`created_at`) VALUES ('2' ,'2022-07-02 12:45:33');
INSERT INTO `shopping_order`(`customer_id`,`created_at`) VALUES ('2' ,'2022-09-20 12:02:10');
INSERT INTO `shopping_order`(`customer_id`,`created_at`) VALUES ('4' ,'2022-10-01 19:25:31');

INSERT INTO `delivery`(`order_id`,`product_id`,`created_at`) VALUES ('1','1','2022-11-01 20:25:31');
INSERT INTO `delivery`(`order_id`,`product_id`,`created_at`) VALUES ('2','1','2022-06-01 20:25:31');
INSERT INTO `delivery`(`order_id`,`product_id`,`created_at`) VALUES ('2','2','2022-07-15 20:25:31');
INSERT INTO `delivery`(`order_id`,`product_id`,`created_at`) VALUES ('2','3','2022-10-01 20:25:31');