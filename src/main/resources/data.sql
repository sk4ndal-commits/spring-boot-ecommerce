-- Tabellen löschen, falls vorhanden
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_category;

-- Tabelle product_category
CREATE TABLE product_category (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  category_name VARCHAR(255)
);

-- Tabelle product
CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         sku VARCHAR(255),
                         name VARCHAR(255),
                         description VARCHAR(255),
                         unit_price DECIMAL(13,2),
                         image_url VARCHAR(255),
                         active BIT,
                         units_in_stock INT,
                         date_created TIMESTAMP,
                         last_updated TIMESTAMP,
                         category_id BIGINT,
                         FOREIGN KEY (category_id) REFERENCES product_category(id)
);

-- Beispieldaten einfügen
INSERT INTO product_category(category_name) VALUES ('BOOKS');

INSERT INTO product (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1000', 'JavaScript - The Fun Parts', 'Learn JavaScript', 'assets/images/products/placeholder.png', 1, 100, 19.99, 1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1001', 'Spring Framework Tutorial', 'Learn Spring', 'assets/images/products/placeholder.png', 1, 100, 29.99, 1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1002', 'Kubernetes - Deploying Containers', 'Learn Kubernetes', 'assets/images/products/placeholder.png', 1, 100, 24.99, 1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1003', 'Internet of Things (IoT) - Getting Started', 'Learn IoT', 'assets/images/products/placeholder.png', 1, 100, 29.99, 1, NOW());

INSERT INTO product (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1004', 'The Go Programming Language: A to Z', 'Learn Go', 'assets/images/products/placeholder.png', 1, 100, 24.99, 1, NOW());