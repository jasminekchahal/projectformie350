INSERT INTO customer (name, email, number) VALUES ('Meherin', 'meherin@gmail.com', '647789213');
INSERT INTO customer (name, email, number) VALUES ('Amulya', 'amulya@gmail.com', '123456789');
INSERT INTO customer (name, email, number) VALUES ('Naeer', 'naeer@gmail.com', '444555777');

INSERT INTO tables (id, table_capacity) VALUES (1, 3);
INSERT INTO tables (id, table_capacity) VALUES (2, 2);
INSERT INTO tables (id, table_capacity) VALUES (3, 4);

INSERT INTO server(id, name, availability, serving_capacity) VALUES (1, 'lol', 0, 1);
INSERT INTO server(id, name, availability, serving_capacity) VALUES (2, 'lol1', 0, 3);

--INSERT INTO reservation_completed(reservation_id, customerNumber, guest_size, date_time, completed_time) VALUES (4, '123456789',2,'2022-09-06','2022-09-06');
--
INSERT INTO reservation_active(reservation_id,  customerNumber , guest_size, date_time) VALUES (1, '647789213', 3, '2022-10-31' );
--
--INSERT INTO reservation_cancelled(reservation_id, customerNumber, guest_size, date_time, date_cancelled) VALUES (3, '444555777',3,'2022-09-09','2022-09-10');



