INSERT INTO delivery (id, title) VALUES (1, 'Minsk Delivery');
INSERT INTO orders (id, order_description, delivery_id, status)
VALUES (1, 'test', 1, 'IN_PROGRESS'), (2, 'new', 1, 'COMPLETED');
--INSERT INTO orders (id, order_description, delivery_id) VALUES (2, 'new', 1);
INSERT INTO tag (id, value, order_id) VALUES (1, 'tag1', 1), (2, 'tag2', 1), (3, 'tt', 2);