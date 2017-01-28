INSERT INTO delivery (id, title) VALUES (1, 'Minsk Delivery');
INSERT INTO orders (id, order_description, delivery_id) VALUES (1, 'test', 1);
INSERT INTO tag (id, value, order_id) VALUES (1, 'tag1', 1), (2, 'tag2', 1);