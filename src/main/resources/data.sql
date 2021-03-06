INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('ewoud', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO users (username, password, enabled) VALUES ('mechanic', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('backoffice', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('administrator', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('cashier', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('customer_1', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('customer_2', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('customer_3', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('customer_4', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('ewoud', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('mechanic', 'ROLE_MECHANIC');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_MECHANIC');
INSERT INTO authorities (username, authority) VALUES ('backoffice', 'ROLE_BACKOFFICE');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_BACKOFFICE');
INSERT INTO authorities (username, authority) VALUES ('administrator', 'ROLE_ADMINISTRATOR');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMINISTRATOR');
INSERT INTO authorities (username, authority) VALUES ('cashier', 'ROLE_CASHIER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_CASHIER');
INSERT INTO authorities (username, authority) VALUES ('customer_1', 'ROLE_CUSTOMER_1');
INSERT INTO authorities (username, authority) VALUES ('customer_2', 'ROLE_CUSTOMER_2');
INSERT INTO authorities (username, authority) VALUES ('customer_3', 'ROLE_CUSTOMER_3');
INSERT INTO authorities (username, authority) VALUES ('customer_4', 'ROLE_CUSTOMER_4');



INSERT INTO customers (voornaam, achternaam, woonplaats, telefoonnummer)
VALUES
('Ewoud', 'Koster', 'Apeldoorn', '0630900768'),
('Joost', 'van Aartsen', 'Raalte', '088888867');

INSERT INTO emplyees (job, naam, emplyee_number)
VALUES
('Mechanic', 'P. Pietjes', '#1324'),
('Backoffice', 'K. Veldhuis', '#9872'),
('Cashier', 'E. Koster', '#1769'),
('Administrator', 'B. Bel', '#4329');

INSERT INTO stock (item_name, price_in_euro, storage_location, phone_number)
VALUES
('APK-Keuring', '???45', 'Apeldoorn', '0639004321'),
('banden', '???180', 'Apeldoorn', '0639004321'),
('Remmen', '???400', 'Apeldoorn', '0639004321'),
('Ruitenwissers & ruitensproeier', '???30', 'Apeldoorn', '0639004321'),
('Verlichting', '???40', 'Apeldoorn', '0639004321'),
('Uitlaat', '???80', 'Apeldoorn', '0639004321'),
('Vergrendeling & gordels', '???350', 'Apeldoorn', '0639004321'),
('Carrosserie & claxon', '???1400', 'Apeldoorn', '0639004321'),
('Spiegels & voorruit', '???250', 'Apeldoorn', '0639004321');

INSERT INTO repair (item_name, price_in_euro, handeling, status)
VALUES
('APK-keuring', '???45', 'algemene kosten voor de APK-Keuring', 'status onbekend'),
('Remmen', '???400', 'remmen vervangen omdat ze versleten zijn', 'status onbekend'),
('banden', '???180', 'banden vervangen voor zomerbanden', 'status onbekend'),
('gordels', '???350', 'gordel links voor vervangen omdat die kapot is', 'status onbekend'),
('voorruit', '???250', 'sterretje in de voorruit maken', 'status onbekend');




