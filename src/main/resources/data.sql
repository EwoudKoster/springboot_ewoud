INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('ewoud', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('ewoud', 'ROLE_USER');

INSERT INTO customers (voornaam, achternaam, woonplaats, telefoonnummer)
VALUES
('Ewoud', 'Koster', 'Apeldoorn', '0630900768'),
('Joost', 'van Aartsen', 'Raalte', '088888867');

INSERT INTO emplyees (job, naam, emplyee_number)
VALUES
('Mechanic', 'Pietjes', '#1324'),
('Backoffice', 'Veldhuis', '#9872'),
('Cashier', 'Koster', '#1769'),
('Administrator', 'Bel', '#4329');

INSERT INTO stock (item_name, price_in_euro, storage_location, phone_number)
VALUES
('aandrijfas', '50', 'Apeldoorn', '0639004321'),
('test', 'test', 'test', 'test'),
('test', 'test', 'test', 'test'),
('test', 'test', 'test', 'test'),
('test', 'test', 'test', 'test'),
('test', 'test', 'test', 'test');


