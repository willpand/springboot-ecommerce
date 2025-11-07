-- Users
INSERT INTO users (username, email, password, role) VALUES
('admin', 'admin@example.com', '$2a$10$ah8b8ohqWQvLSexYuCfs/OJEa1vkjQCjxzR0ftbY81zVtAN1LRfg6', 'ADMIN'),
('user', 'user@example.com', '$2a$10$ZPsgKVy.twGGItizlC3qJO5JBXY0VWa9kv.6lPpWERR6C4gwM.8QO', 'USER');

--Products

INSERT INTO products (name, description, price, category) VALUES
('Wireless Mouse', 'Ergonomic wireless mouse with high precision sensor', 25.99, 'Electronics'),
('Mechanical Keyboard', 'RGB backlit mechanical keyboard with blue switches', 79.99, 'Electronics'),
('Noise Cancelling Headphones', 'Over-ear, wireless headphones with ANC', 129.99, 'Electronics'),
('USB-C Charger', 'Fast charging USB-C wall charger', 19.99, 'Electronics'),
('Laptop Stand', 'Adjustable laptop stand for desk', 39.99, 'Accessories'),
('Gaming Chair', 'Ergonomic gaming chair with lumbar support', 199.99, 'Furniture'),
('Smartphone Case', 'Shockproof protective case for smartphones', 15.99, 'Accessories'),
('Bluetooth Speaker', 'Portable Bluetooth speaker with deep bass', 49.99, 'Electronics'),
('Webcam HD', '1080p HD webcam with built-in microphone', 59.99, 'Electronics'),
('External Hard Drive', '1TB portable external hard drive', 69.99, 'Electronics'),
('Desk Lamp', 'LED desk lamp with adjustable brightness', 29.99, 'Furniture'),
('Wireless Earbuds', 'True wireless earbuds with charging case', 89.99, 'Electronics'),
('Coffee Mug', 'Ceramic coffee mug 350ml', 9.99, 'Kitchen'),
('Notebook', '200-page ruled notebook', 5.99, 'Stationery'),
('Pen Set', 'Set of 5 gel pens', 4.99, 'Stationery'),
('Water Bottle', 'Stainless steel 750ml water bottle', 14.99, 'Accessories'),
('Backpack', 'Waterproof backpack with multiple compartments', 49.99, 'Accessories'),
('Smart Watch', 'Fitness tracker with heart rate monitor', 99.99, 'Electronics'),
('Table Lamp', 'Modern table lamp for bedroom', 34.99, 'Furniture'),
('Yoga Mat', 'Non-slip yoga mat 6mm thick', 24.99, 'Sports');
