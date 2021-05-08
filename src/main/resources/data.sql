INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('ewoud', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO users (username, password, enabled) VALUES ('mechenic', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('backoffice', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('administrator', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('customer_1', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('customer_2', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('customer_3', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('customer_4', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);





INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('ewoud', 'ROLE_USER');

INSERT INTO authorities (username, authority) VALUES ('mechanic', 'ROLE_MECHANIC');
INSERT INTO authorities (username, authority) VALUES ('backoffice', 'ROLE_BACKOFFICE');
INSERT INTO authorities (username, authority) VALUES ('administrator', 'ROLE_ADMINISTRATOR');
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
('Mechanic', 'Pietjes', '#1324'),
('Backoffice', 'Veldhuis', '#9872'),
('Cashier', 'Koster', '#1769'),
('Administrator', 'Bel', '#4329');

INSERT INTO stock (item_name, price_in_euro, storage_location, phone_number)
VALUES
('Algemeen', '€45', 'Apeldoorn', '0639004321'),
('banden', '€180', 'Apeldoorn', '0639004321'),
('Remmen', '€400', 'Apeldoorn', '0639004321'),
('Ruitenwissers & ruitensproeier', '€30', 'Apeldoorn', '0639004321'),
('Verlichting', '€40', 'Apeldoorn', '0639004321'),
('Uitlaat', '€80', 'Apeldoorn', '0639004321'),
('Vergrendeling & gordels', '€350', 'Apeldoorn', '0639004321'),
('Carrosserie & claxon', '€1400', 'Apeldoorn', '0639004321'),
('Spiegels & voorruit', '€250', 'Apeldoorn', '0639004321');

INSERT INTO repair (item_name, price_in_euro, handeling)
VALUES
('APK-keuring', '€45', 'algemene kosten voor de APK-Keuring'),
('Remmen', '€400', 'remmen vervangen omdat ze versleten zijn'),
('banden', '€180', 'banden vervangen voor zomerbanden'),
('gordels', '€350', 'gordel links voor vervangen omdat die kapot is'),
('voorruit', '€250', 'sterretje in de voorruit maken');




