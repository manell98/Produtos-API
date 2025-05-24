CREATE TABLE PRODUCT (
     ID VARCHAR(36) PRIMARY KEY,
     NAME VARCHAR(100) NOT NULL,
     DESCRIPTION VARCHAR(500),
     PRICE DECIMAL(10,2) NOT NULL
);

INSERT INTO PRODUCT (ID, NAME, DESCRIPTION, PRICE) VALUES
     ('550e8400-e29b-41d4-a716-446655440000', 'Smartphone X', 'Último modelo com câmera de 108MP', 3599.99),
     ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'Notebook Pro', '16GB RAM, SSD 512GB, tela 15.6"', 5299.00),
     ('6ba7b811-9dad-11d1-80b4-00c04fd430c8', 'Fone Bluetooth', 'Cancelamento de ruído ativo', 899.90),
     ('6ba7b812-9dad-11d1-80b4-00c04fd430c8', 'Smartwatch', 'Monitoramento de saúde e GPS', 1299.50),
     ('6ba7b813-9dad-11d1-80b4-00c04fd430c8', 'Tablet 10"', '128GB armazenamento, caneta inclusa', 2199.00);
